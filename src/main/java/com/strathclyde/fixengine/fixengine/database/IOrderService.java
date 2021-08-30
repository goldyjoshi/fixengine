package com.strathclyde.fixengine.fixengine.database;

import com.strathclyde.fixengine.fixengine.model.SingleOrderRequest;

import java.util.List;

/***
 * IOrderService represent contract to be implemented for order operation related to database.
 * @author Vijayshreejoshi
 */
public interface IOrderService {

    void insertOrderInDatabase(final SingleOrderRequest singleOrderRequest);
    void updateOrderStatus(final String orderId, final String statusToBeUpdated, final double totalExecutedQuantity);
    List<SingleOrderRequest> getOrders();
    SingleOrderRequest getOrder(final String orderId);

}
