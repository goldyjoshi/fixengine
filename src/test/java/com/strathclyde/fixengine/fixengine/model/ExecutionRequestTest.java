package com.strathclyde.fixengine.fixengine.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


@SpringBootTest
public class ExecutionRequestTest {

    @Test
    public void executionRequestGetterSetterTest() {
        //Given
        String orderIdModifiedValue = "Test1234";
        String accountIdModifiedValue = "ACC123";
        String symbolModifiedValue = "Apple";
        String sideModifiedValue = "Sell";
        String execTypeModifiedValue = "Partial";
        double totalQuantityModifiedValue = 120.75;
        double quantityRequestedForExecModifiedValue =70.2;
        double previousExecQuantityModifiedValue = 40.1;
        double executionPriceModifiedValue = 47.8;


        // When object of SRequest created,
        ExecutionRequest executionRequest = new ExecutionRequest();

        // Then check initial value
        assertNull(executionRequest.getOrderId());
        assertNull(executionRequest.getAccountId());
        assertNull(executionRequest.getSide());
        assertNull(executionRequest.getSymbol());
        assertNull(executionRequest.getExecType());
        assertEquals(executionRequest.getTotalQuantity(), 0.0);
        assertEquals(executionRequest.getQuantityRequestedForExec(), 0.0);
        assertEquals(executionRequest.getPreviousExecQuantity(), 0.0);
        assertEquals(executionRequest.getExecutionPrice(), 0.0);

        // When initial value modified
        executionRequest.setOrderId(orderIdModifiedValue);
        executionRequest.setAccountId(accountIdModifiedValue);
        executionRequest.setSymbol(symbolModifiedValue);
        executionRequest.setSide(sideModifiedValue);
        executionRequest.setExecType(execTypeModifiedValue);
        executionRequest.setTotalQuantity(totalQuantityModifiedValue);
        executionRequest.setQuantityRequestedForExec(quantityRequestedForExecModifiedValue);
        executionRequest.setPreviousExecQuantity(previousExecQuantityModifiedValue);
        executionRequest.setExecutionPrice(executionPriceModifiedValue);

        // Then check modified value.
        assertEquals(executionRequest.getOrderId(), orderIdModifiedValue);
        assertEquals(executionRequest.getSide(), sideModifiedValue);
        assertEquals(executionRequest.getSymbol(), symbolModifiedValue);
        assertEquals(executionRequest.getAccountId(), accountIdModifiedValue);
        assertEquals(executionRequest.getExecType(), execTypeModifiedValue);
        assertEquals(executionRequest.getTotalQuantity(), totalQuantityModifiedValue);
        assertEquals(executionRequest.getQuantityRequestedForExec(), quantityRequestedForExecModifiedValue);
        assertEquals(executionRequest.getPreviousExecQuantity(), previousExecQuantityModifiedValue);
        assertEquals(executionRequest.getExecutionPrice(), executionPriceModifiedValue);
    }

}
