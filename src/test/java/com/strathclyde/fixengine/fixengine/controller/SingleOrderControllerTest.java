package com.strathclyde.fixengine.fixengine.controller;

import com.strathclyde.fixengine.fixengine.app.FixMessageService;
import com.strathclyde.fixengine.fixengine.database.OrderService;
import com.strathclyde.fixengine.fixengine.model.SingleOrderRequest;
import com.strathclyde.fixengine.fixengine.utility.TestUtility;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import static org.mockito.Mockito.*;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SingleOrderControllerTest {

    @Mock
    private OrderService orderServiceMock;

    @Mock
    private FixMessageService fixMessageServiceMock;

    @InjectMocks
    private SingleOrderController singleOrderControllerMock;

    @Test
    public void submitOrderTest() {
        SingleOrderRequest singleOrderRequest = TestUtility.createSingleOrderRequest();
        Mockito.when(fixMessageServiceMock.createAndSendSingleOrderMessage(any(SingleOrderRequest.class))).thenReturn(true);
        Mockito.doNothing().when(orderServiceMock).insertOrderInDatabase(any(SingleOrderRequest.class));
        Boolean status = singleOrderControllerMock.submitOrder(singleOrderRequest);
        Mockito.verify(fixMessageServiceMock, Mockito.times(1))
                .createAndSendSingleOrderMessage(singleOrderRequest);
        assertTrue(status);
    }

    @Test
    public  void getOrdersTest() {
        List<SingleOrderRequest> mockOrderList = new ArrayList<>();
        mockOrderList.add(TestUtility.createSingleOrderRequest());
        Mockito.when(orderServiceMock.getOrders()).thenReturn(mockOrderList);
        List<SingleOrderRequest>  listOfOrders = singleOrderControllerMock.getOrders();
        assertNotNull(listOfOrders);
        assertTrue(listOfOrders.size() > 0);
        Mockito.verify(orderServiceMock, Mockito.times(1)).getOrders();
    }

}


