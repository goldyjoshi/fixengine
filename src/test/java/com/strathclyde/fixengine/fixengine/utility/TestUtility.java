package com.strathclyde.fixengine.fixengine.utility;

import com.strathclyde.fixengine.fixengine.model.SingleOrderRequest;

import java.util.UUID;

public class TestUtility {

    public static SingleOrderRequest createSingleOrderRequest() {
        String orderId = UUID.randomUUID().toString();
        SingleOrderRequest singleOrderRequest = new SingleOrderRequest();
        singleOrderRequest.setOrderId(orderId);
        singleOrderRequest.setAccountId("TestAccount");
        singleOrderRequest.setExecutedQuantity(0.0);
        singleOrderRequest.setStatus("test");
        singleOrderRequest.setSide("Buy");
        singleOrderRequest.setSymbol("test");
        singleOrderRequest.setQuantity(0.0);
        return singleOrderRequest;
    }
}
