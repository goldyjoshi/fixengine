package com.strathclyde.fixengine.fixengine.controller;

import com.strathclyde.fixengine.fixengine.app.FixMessageService;
import com.strathclyde.fixengine.fixengine.model.ExecutionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExecutionController {

    @Autowired
    private FixMessageService fixMessageService;

    @PostMapping("/execution")
    public void sendExecution(@RequestBody ExecutionRequest executionRequest) {
        fixMessageService.createAndSendExecutionReport(executionRequest);
    }
}
