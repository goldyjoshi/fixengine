package com.strathclyde.fixengine.fixengine.controller;

import com.strathclyde.fixengine.fixengine.app.FixMessageService;
import com.strathclyde.fixengine.fixengine.model.ExecutionRequest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class ExecutionControllerTest {

    @Mock
    private FixMessageService fixMessageService;

    @InjectMocks
    private ExecutionController executionController;

    @Test
    public void sendExecutionTest() {
        ExecutionRequest executionRequest = new ExecutionRequest();
        Mockito.when(fixMessageService.createAndSendExecutionReport(any(ExecutionRequest.class))).thenReturn(true);
        boolean executionStatus = executionController.sendExecution(executionRequest);
        Mockito.verify(fixMessageService, Mockito.times(1)).createAndSendExecutionReport(executionRequest);
        assertTrue(executionStatus);
    }

}
