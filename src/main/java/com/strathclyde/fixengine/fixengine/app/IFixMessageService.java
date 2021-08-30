package com.strathclyde.fixengine.fixengine.app;

import com.strathclyde.fixengine.fixengine.model.ExecutionRequest;
import com.strathclyde.fixengine.fixengine.model.SingleOrderRequest;

/***
 * This interface is used to implements abstraction of message service.
 * @author Vijayshreejoshi
 */
public interface IFixMessageService {

    Boolean createAndSendExecutionReport(final ExecutionRequest executionRequest);
    Boolean createAndSendSingleOrderMessage(final SingleOrderRequest singleOrderRequest);

}
