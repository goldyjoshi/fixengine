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
import org.springframework.jdbc.core.JdbcTemplate;
import quickfix.Message;
import quickfix.Session;
import quickfix.SessionNotFound;

import java.util.List;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SingleOrderControllerTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

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

    @Test
    public void getSingleOrderList()
    {
        String orderId = "TestOrderId";
        String quantity = "TestQuantity";
        String symbol = "TestSymbol";
        String clientAccountId = "TestClientAccountId";
        String orderDate = "TestOrderDate";
        String orderStatus = "TestOrderStatus";
        String side = "TestSide";
        String quantityExecuted = "TestQuantityExecuted";
        String insertSingleOrderController = "insert into  order_detail (order_id, quantity, symbol, client_account_Id, order_date," +
                " order_status, side, quantity_executed) values(?, ?, ?, ?, ?, ?, ?, ?)";
        int result = jdbcTemplate.update(insertSingleOrderController,orderId,quantity, symbol, clientAccountId, orderDate,
                orderStatus,side, quantityExecuted );
        if (result > 0) {
            List<SingleOrderRequest> orderList = singleOrderController.getOrders();
            assertTrue(orderList.contains(orderId));

            String deleteSingleOrderSql = "delete from order_detail where order_id = ?";
            int deleteStatus = jdbcTemplate.update(deleteSingleOrderSql, orderId);
            if (deleteStatus > 0) {
                System.out.println("Database clean up has been done successfully.");
            } else {
                fail("Failed to remove order from Database.");
            }

        } else {
            fail("Insertion of order Id in the database has been failed ");
        }

        }
    }


