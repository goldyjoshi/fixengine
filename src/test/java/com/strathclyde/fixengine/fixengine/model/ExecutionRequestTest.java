package com.strathclyde.fixengine.fixengine.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ExecutionRequestTest {

    @Autowired
    private ExecutionRequest executionRequest = new ExecutionRequest();


    @Test
    public void getAndSetPreviousExecQuantity() {
        double expectedExecutedQuantity = 23.4;
        executionRequest.setExecutionPrice(expectedExecutedQuantity);
        double actualExecutedQuantity = executionRequest.getExecutionPrice();
        assertEquals(actualExecutedQuantity, expectedExecutedQuantity);

    }
}
