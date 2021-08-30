package com.strathclyde.fixengine.fixengine.database;

import com.strathclyde.fixengine.fixengine.model.SingleOrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

/***
 * This class represent OrderService and responsible to perform database operation related to order_details
 * @author vijayshreejoshi .
 */
@Service
public class OrderService implements IOrderService {

    @Autowired
    private JdbcTemplate jdbcTemplateForOrder;

    /***
     * Method prepare sql from singleOrderRequest and insert order/trade into database.
     * @param singleOrderRequest to insert into database.
     */
    public void insertOrderInDatabase(final SingleOrderRequest singleOrderRequest) {
        Date currentDate = new Date();
        Timestamp currentTimeStamp = new Timestamp(currentDate.getTime());
        String insertOrder = "insert into  order_detail (order_id, quantity, symbol, client_account_Id, order_date," +
                " order_status, side, quantity_executed) values(?, ?, ?, ?, ?, ?, ?,?)";
        int orderInsertionStatus = jdbcTemplateForOrder.update(insertOrder, singleOrderRequest.getOrderId(),
                singleOrderRequest.getQuantity(), singleOrderRequest.getSymbol(), singleOrderRequest.getAccountId(),
                currentTimeStamp, singleOrderRequest.getStatus(), singleOrderRequest.getSide(), singleOrderRequest.getExecutedQuantity());
        if (orderInsertionStatus > 0) {
            System.out.println("Order details " + singleOrderRequest.toString() + " has been successfully inserted into database.");
        } else {
            System.out.println("insertion into database for order:  " + singleOrderRequest.toString() + " has been failed.");
        }

    }

    /***
     * Method is responsible to update order status and total executed quantity of an order in to the database.
     * @param orderId string variable to store unique order id.
     * @param statusToBeUpdated string variable to store value of status.
     * @param totalExecutedQuantity double value of total quantity executed so far.
     */
    public void updateOrderStatus(final String orderId, final String statusToBeUpdated,
                                  final double totalExecutedQuantity) {
        String updateOrder = "update order_detail " +
                "set order_status = ?" +
                " where order_id = ? ";
        int orderInsertionStatus = jdbcTemplateForOrder.update(updateOrder, statusToBeUpdated, orderId);
        if (orderInsertionStatus > 0) {
            StringBuilder message = new StringBuilder();
            message.append("Order id ").
                    append(orderId)
                    .append(" has been successfully updated with status : " )
                    .append(statusToBeUpdated)
                    .append( "and quantity : ")
                    .append(totalExecutedQuantity);
            System.out.println(message);
        } else {
            System.out.println("Failed to update order : " + orderId);
        }
            String updateOrderQty = "update order_detail " +
                    "set quantity_executed = ?" +
                    " where order_id = ? ";
            int orderInsertionQty = jdbcTemplateForOrder.update(updateOrderQty, totalExecutedQuantity, orderId);
            if (orderInsertionQty > 0) {
                StringBuilder messageQty = new StringBuilder();
                messageQty.append("Order id ").
                        append(orderId)
                        .append(" has been successfully updated with status : " )
                        .append(statusToBeUpdated)
                        .append( "and quantity : ")
                        .append(totalExecutedQuantity);
                System.out.println(messageQty);
        } else {
            System.out.println("Failed to update order : " + orderId);
        }
    }

    /***
     * Method to get List of orders from the database.
     * @return value of orderList of type List
     */
    public List<SingleOrderRequest> getOrders() {
        List<Map<String, Object>> orderResultSet = getOrdersFromDatabase();
        List<SingleOrderRequest> orderList = prepareOrderList(orderResultSet);
        return orderList;
    }

    /***
     * Method to get order by order id.
     * @param orderId of order
     * @return SingleOrderRequest
     */
    public SingleOrderRequest getOrder(final String orderId) {
        List<Map<String, Object>> orderResultSet = getOrderFromDatabase(orderId);
        List<SingleOrderRequest> orderList = prepareOrderList(orderResultSet);
        return orderList.get(0);
    }

    /***
     * Method to map and prepare SingleOrderRequest list from list of result set map.
     * @param orderResultSet store the list of order result.
     * @return List<SingleOrderRequest>
     */
    private List<SingleOrderRequest> prepareOrderList(List<Map<String, Object>> orderResultSet) {
        List<SingleOrderRequest> orderList = new ArrayList<>();
        SingleOrderRequest singleOrderRequest;
        for (Map<String, Object> orderRow : orderResultSet) {
            singleOrderRequest = new SingleOrderRequest();
            for (String orderColumn : orderRow.keySet()) {
                switch(orderColumn) {
                    case "order_id":
                        singleOrderRequest.setOrderId(orderRow.get(orderColumn).toString());
                        break;
                    case "quantity":
                        singleOrderRequest.setQuantity(Double.valueOf(orderRow.get(orderColumn).toString()));
                        break;
                    case "symbol":
                        singleOrderRequest.setSymbol(orderRow.get(orderColumn).toString());
                        break;
                    case "client_account_Id":
                        singleOrderRequest.setAccountId(orderRow.get(orderColumn).toString());
                        break;
                    case "side":
                        singleOrderRequest.setSide(orderRow.get(orderColumn).toString());
                        break;
                    case "order_status":
                        singleOrderRequest.setStatus(orderRow.get(orderColumn).toString());
                        break;
                    case "quantity_executed":
                        singleOrderRequest.setExecutedQuantity(Double.valueOf(orderRow.get(orderColumn).toString()));
                        break;
                    default:
                        System.out.println("column not supported");
                }

            }
            orderList.add(singleOrderRequest);
        }
        return orderList;
    }

    /***
     * This method is used to get orders list from database.
     * @return orderResultSet value of type List.
     */
    private List<Map<String, Object>>  getOrdersFromDatabase() {
        String ordersSql = "select * from order_detail";
        List<Map<String, Object>> orderResultSet = jdbcTemplateForOrder.queryForList(ordersSql);
        return orderResultSet;
    }

    /***
     * This method is used to get order from database using order id.
     * @param orderId store the value of type String
     * @return orderResultSet value of type List.
     */
    private List<Map<String, Object>>  getOrderFromDatabase(String orderId) {
        String ordersSql = "select * from order_detail where order_id = ?";
        List<Map<String, Object>> orderResultSet = jdbcTemplateForOrder.queryForList(ordersSql, orderId);
        return orderResultSet;
    }

}
