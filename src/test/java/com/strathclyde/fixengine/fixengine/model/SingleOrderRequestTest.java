package com.strathclyde.fixengine.fixengine.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SingleOrderRequestTest {

    @Test
    public void singleOrderRequestGetterSetterTest() {
        //Given
        String orderIdModifiedValue = "Test1234";
        String accountIdModifiedValue = "AC12345";
        double quantityModifiedValue = 101.5;
        double executedQuantityModifiedValue = 70.5;
        String statusModifiedValue = "Created";
        String symbolModifiedValue = "Apple";
        String sideModifiedValue = "Buy" ;

        // When object of SingleOrderRequest created,
        SingleOrderRequest singleOrderRequest = new SingleOrderRequest();

        // Then check initial value
        assertNull(singleOrderRequest.getOrderId());
        assertNull(singleOrderRequest.getStatus());
        assertNull(singleOrderRequest.getSide());
        assertNull(singleOrderRequest.getSymbol());
        assertNull(singleOrderRequest.getAccountId());
        assertEquals(singleOrderRequest.getQuantity(), 0.0);
        assertEquals(singleOrderRequest.getExecutedQuantity(), 0.0);

        // When initial value modified
        singleOrderRequest.setOrderId(orderIdModifiedValue);
        singleOrderRequest.setAccountId(accountIdModifiedValue);
        singleOrderRequest.setStatus(statusModifiedValue);
        singleOrderRequest.setSide(sideModifiedValue);
        singleOrderRequest.setSymbol(symbolModifiedValue);
        singleOrderRequest.setQuantity(quantityModifiedValue);
        singleOrderRequest.setExecutedQuantity(executedQuantityModifiedValue);

        // Then check modified value.
        assertEquals(singleOrderRequest.getOrderId(), orderIdModifiedValue);
        assertEquals(singleOrderRequest.getStatus(), statusModifiedValue);
        assertEquals(singleOrderRequest.getSide(), sideModifiedValue);
        assertEquals(singleOrderRequest.getSymbol(), symbolModifiedValue);
        assertEquals(singleOrderRequest.getAccountId(), accountIdModifiedValue);
        assertEquals(singleOrderRequest.getQuantity(), quantityModifiedValue);
        assertEquals(singleOrderRequest.getExecutedQuantity(), executedQuantityModifiedValue);
    }

}
