package com.strathclyde.fixengine.fixengine.database;

import com.strathclyde.fixengine.fixengine.model.SingleOrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service
public class OrderService {

    @Autowired
    private JdbcTemplate jdbcTemplateForOrder;

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

    public void updateOrderStatus(final String orderId, final String statusToBeUpdated, final double totalExecutedQuantity) {
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

    public List<SingleOrderRequest> getOrders() {
        List<SingleOrderRequest> orderList = new ArrayList<>();
        List<Map<String, Object>> orderResultSet = getOrdersFromDatabase();
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


    private List<Map<String, Object>>  getOrdersFromDatabase() {
        String ordersSql = "select * from order_detail";
        List<Map<String, Object>> orderResultSet = jdbcTemplateForOrder.queryForList(ordersSql);
        return orderResultSet;
    }

}
