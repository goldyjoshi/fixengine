package com.strathclyde.fixengine.fixengine.controller;

import com.strathclyde.fixengine.fixengine.model.ExecutionRequest;
import org.springframework.web.bind.annotation.RequestBody;

/***
 * IExecutionController represent contract to be implemented for execution request.
 * @author Vijayshreejoshi
 */
public interface IExecutionController {

    Boolean sendExecution(@RequestBody ExecutionRequest executionRequest);

}
