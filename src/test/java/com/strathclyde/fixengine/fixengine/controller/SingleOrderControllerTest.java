package com.strathclyde.fixengine.fixengine.controller;

import com.strathclyde.fixengine.fixengine.app.FixMessageService;
import com.strathclyde.fixengine.fixengine.database.OrderService;
import com.strathclyde.fixengine.fixengine.model.SingleOrderRequest;
import com.strathclyde.fixengine.fixengine.utility.TestUtility;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import quickfix.Message;
import quickfix.Session;
import quickfix.SessionNotFound;

import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SingleOrderControllerTest {

    @Mock
    private OrderService orderService;

    @Mock
    private FixMessageService fixMessageService;

    @Autowired
    private SingleOrderController singleOrderController;

    @Test
    public void submitOrderTest() throws SessionNotFound {
        // Given singleOrderRequest is available.
        SingleOrderRequest singleOrderRequest = TestUtility.createSingleOrderRequest();

//        Mockito.when(Session.sendToTarget(Mockito.any(Message.class))).then(assertDo);
//        Mockito.doNothing().when(Session.class);

        Mockito.mockStatic(Session.class);
        //when submit order method is called
        singleOrderController.submitOrder(singleOrderRequest);

        //then verify order has been sent.
        ArgumentCaptor<SingleOrderRequest> captureOrder = ArgumentCaptor.forClass(SingleOrderRequest.class);
        ArgumentCaptor<SingleOrderRequest> captureFix = ArgumentCaptor.forClass(SingleOrderRequest.class);
        Mockito.verify(orderService, Mockito.times(1)).
                insertOrderInDatabase(captureOrder.capture());
        Mockito.verify(fixMessageService, Mockito.times(1)).
                createAndSendSingleOrderMessage(captureFix.capture());

        SingleOrderRequest actualOrder = captureOrder.getValue();


    }

}
