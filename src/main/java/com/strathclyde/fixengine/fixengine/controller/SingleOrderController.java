package com.strathclyde.fixengine.fixengine.controller;

import com.strathclyde.fixengine.fixengine.app.FixMessageService;
import com.strathclyde.fixengine.fixengine.database.OrderService;
import com.strathclyde.fixengine.fixengine.model.SingleOrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/***
 * This class represent the rest controller of Single order, is used to build REST api
 * in a declarative way and provide the RESTFUL web service at runtime.
 *  @author vijayshreejoshi
 */
@RestController
public class SingleOrderController {

    /***
     * Using annotation Autowired declaring a variable of type OrderService.
     */
    @Autowired
    private OrderService orderService;

    /***
     * Variable fixMessageService using annotation Autowired used to inject the dependent bean of FixMessageService.
     */
    @Autowired
    private FixMessageService fixMessageService;

    /***
     * This method is used to submit order for single order on calling method of OrderService,
     * FixMessageService. @PostMapping is used to handle the post type of request method
     * @param singleOrderRequest represent the values of SingleOrderRequest.
     */
    @PostMapping("/submit_order")
    public Boolean submitOrder(@RequestBody SingleOrderRequest singleOrderRequest) {

        Boolean status = fixMessageService.createAndSendSingleOrderMessage(singleOrderRequest);
        if (status) {
            orderService.insertOrderInDatabase(singleOrderRequest);
        }
        return status;
    }

    /***
     * This method is used to get list of single order request. @GetMapping is used to handle Get type of handle method
     * by provided appropriate path.
     * @return orderList of type SingleOrderRequest
     */
    @GetMapping("/orders")
    public List<SingleOrderRequest> getOrders() {
        List<SingleOrderRequest> orderList = orderService.getOrders();
        return orderList;
    }

}
