package com.strathclyde.fixengine.fixengine.database;

import com.strathclyde.fixengine.fixengine.model.SingleOrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@SpringBootTest
public class OrderServiceTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private OrderService orderService;

    public void insertOrderInDatabaseTest() {
        //Given
        SingleOrderRequest singleOrderRequest = new SingleOrderRequest();
        singleOrderRequest.setAccountId("testaccount");
        Date currentDate = new Date();
        String orderId = UUID.randomUUID().toString();
        singleOrderRequest.setOrderId(orderId);

        Timestamp currentTimeStamp = new Timestamp(currentDate.getTime());

        //when
        orderService.insertOrderInDatabase(singleOrderRequest, currentTimeStamp);

        //Then check order inserted in database
//        jdbcTemplate.query("select * from order_detail where order_id = ?");


    }


}
