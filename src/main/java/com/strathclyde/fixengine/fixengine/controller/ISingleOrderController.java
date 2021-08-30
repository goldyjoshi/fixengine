package com.strathclyde.fixengine.fixengine.controller;

import com.strathclyde.fixengine.fixengine.model.SingleOrderRequest;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/***
 * ISingleOrderController represent contract to be implemented for order request.
 * @author Vijayshreejoshi
 */
public interface ISingleOrderController {

    Boolean submitOrder(@RequestBody SingleOrderRequest singleOrderRequest);
    List<SingleOrderRequest> getOrders();

}
