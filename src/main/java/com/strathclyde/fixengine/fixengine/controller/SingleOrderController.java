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

@RestController
public class SingleOrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private FixMessageService fixMessageService;

    @PostMapping("/submitorder")
    public void submitOrder(@RequestBody SingleOrderRequest singleOrderRequest) {
        Date currentDate = new Date();
        Timestamp currentTimeStamp = new Timestamp(currentDate.getTime());
        fixMessageService.createAndSendSingleOrderMessage(singleOrderRequest, currentTimeStamp.toString());

        orderService.insertOrderInDatabase(singleOrderRequest, currentTimeStamp);

    }

    @GetMapping("/orders")
    public List<SingleOrderRequest> getOrders() {
        List<SingleOrderRequest> orderList = orderService.getOrders();
        return orderList;
    }

}
