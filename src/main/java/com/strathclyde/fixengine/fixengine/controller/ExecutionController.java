package com.strathclyde.fixengine.fixengine.controller;

import com.strathclyde.fixengine.fixengine.app.FixMessageService;
import com.strathclyde.fixengine.fixengine.model.ExecutionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/***
 * This class represent the rest controller of Execution of order, is used to build REST api
 *  in a declarative way and provide the RESTFUL web service at runtime.
 * @author vijayshreejoshi
 */
@RestController
public class ExecutionController {

    @Autowired
    private FixMessageService fixMessageService; //Variable to store the all values of FixMessageService

    /***
     * This method is used to send execution message having parameters all execution request information and object of
     * FixMessageService call the method and generate report on requested execution to UI.
     * @param executionRequest
     */
    @PostMapping("/execution")
    public void sendExecution(@RequestBody ExecutionRequest executionRequest) {
        fixMessageService.createAndSendExecutionReport(executionRequest);
    }
}
