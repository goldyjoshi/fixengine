package com.strathclyde.fixengine.fixengine.utility;

import com.strathclyde.fixengine.fixengine.model.SingleOrderRequest;
import com.strathclyde.fixengine.fixengine.model.TraderDetails;

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

    public static TraderDetails employeeDetails() {
       TraderDetails traderDetails = new TraderDetails("235", "vijayshree@hotmail.com", "vj2985@",
               "Trader");
       return traderDetails;
    }

}
