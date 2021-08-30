package com.strathclyde.fixengine.fixengine.app;

import com.strathclyde.fixengine.fixengine.database.OrderService;
import com.strathclyde.fixengine.fixengine.model.SingleOrderRequest;
import com.strathclyde.fixengine.fixengine.utility.TestUtility;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import quickfix.Message;
import quickfix.fix42.NewOrderSingle;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FixMessageHandlerTest {

    @Autowired
    private FixMessageHandler fixMessageHandler;

    @Autowired
    private OrderService orderService;

    @Autowired
    private JdbcTemplate jdbcTemplateForOrder;

    @Test
    public void handleIncomingMessageTest() {
        //Given
        fixMessageHandler.setFixType("initiator");
        String orderId = UUID.randomUUID().toString();
        insertOrder(orderId);
        Message message = TestUtility.createFixMessage(orderId, "8");
        message.setString(39, "2");

        // When
        fixMessageHandler.handleIncomingMessage(message);

        // Then
        SingleOrderRequest singleOrderByOrderId  = orderService.getOrder(orderId);
        assertEquals("Order Completed", singleOrderByOrderId.getStatus());

        // clean up
        deleteOrder(orderId);
    }

    @Test
    public void handleOutgoingMessageTest() {
        //Given
        fixMessageHandler.setFixType("initiator");
        String orderId = UUID.randomUUID().toString();
        insertOrder(orderId);

        NewOrderSingle newOrderSingle = TestUtility.createNewOrderSingle(orderId);

        // When
        fixMessageHandler.handleOutgoingMessage(newOrderSingle);

        SingleOrderRequest singleOrderByOrderId  = orderService.getOrder(orderId);

        // Then
        assertEquals("Sent for Execution", singleOrderByOrderId.getStatus());

        deleteOrder(orderId);
    }


    private void insertOrder(final String orderId) {
        SingleOrderRequest singleOrderRequest = TestUtility.createSingleOrderRequest();
        singleOrderRequest.setAccountId("testAccount");
        singleOrderRequest.setOrderId(orderId);
        orderService.insertOrderInDatabase(singleOrderRequest);
    }

    private void deleteOrder(final String orderId) {
        String deleteSingleOrderSql = "delete from order_detail where order_id = ?";
        int deleteStatus = jdbcTemplateForOrder.update(deleteSingleOrderSql, orderId);
        if (deleteStatus > 0) {
            System.out.println("Database clean up has been done successfully.");
        } else {
            fail("Failed to remove order from Database.");
        }
    }

}