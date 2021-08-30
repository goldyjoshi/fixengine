package com.strathclyde.fixengine.fixengine.database;

import com.strathclyde.fixengine.fixengine.model.SingleOrderRequest;
import com.strathclyde.fixengine.fixengine.utility.TestUtility;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.UUID;

@SpringBootTest
public class OrderServiceTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private OrderService orderService;

    @Test
    public void insertOrderInDatabaseTest() {
        //Given
        SingleOrderRequest singleOrderRequest = TestUtility.createSingleOrderRequest();
        String orderId = UUID.randomUUID().toString();
        singleOrderRequest.setOrderId(orderId);

        //when
        orderService.insertOrderInDatabase(singleOrderRequest);

        //Then check order inserted in database
        SingleOrderRequest singleOrderRequestById = orderService.getOrder(orderId);
        assertNotNull(singleOrderRequestById);
        assertEquals(orderId, singleOrderRequestById.getOrderId());

        // clean up order after test.
        deleteOrder(orderId);
    }

    @Test
    public void updateOrderStatusTest() {

        //Given Order exist in the system.
        SingleOrderRequest singleOrderRequest = TestUtility.createSingleOrderRequest();
        String orderId = UUID.randomUUID().toString();
        singleOrderRequest.setOrderId(orderId);
        singleOrderRequest.setStatus("Created");
        orderService.insertOrderInDatabase(singleOrderRequest);

        // When
        String statusToModify = "TestStatus";
        orderService.updateOrderStatus(orderId, statusToModify, 100);

        //Then
        SingleOrderRequest singleOrderRequestById = orderService.getOrder(orderId);
        assertNotNull(singleOrderRequestById);
        assertEquals(statusToModify, singleOrderRequestById.getStatus());

        // clean up order after test.
        deleteOrder(orderId);
    }

    @Test
    public void getOrdersTest() {
        //Given Order exist in the system.
        SingleOrderRequest singleOrderRequest = TestUtility.createSingleOrderRequest();
        String orderId = UUID.randomUUID().toString();
        singleOrderRequest.setOrderId(orderId);
        singleOrderRequest.setStatus("Created");
        orderService.insertOrderInDatabase(singleOrderRequest);

        // When
        List<SingleOrderRequest> listOfOrders = orderService.getOrders();
        assertNotNull(listOfOrders);
        assertTrue(listOfOrders.size() > 0);

        // clean up order after test.
        deleteOrder(orderId);
    }

    private void deleteOrder(final String orderId) {
        String deleteSingleOrderSql = "delete from order_detail where order_id = ?";
        int deleteStatus = jdbcTemplate.update(deleteSingleOrderSql, orderId);
        if (deleteStatus > 0) {
            System.out.println("Database clean up has been done successfully.");
        } else {
            fail("Failed to remove order from Database.");
        }
    }

}
