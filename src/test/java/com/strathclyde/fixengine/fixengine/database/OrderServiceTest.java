package com.strathclyde.fixengine.fixengine.database;

import com.strathclyde.fixengine.fixengine.model.SingleOrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

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
        String orderid = UUID.randomUUID().toString();

        //when
//        orderService.insertOrderInDatabase(singleOrderRequest, orderid);

        //Then check order inserted in database
//        jdbcTemplate.query("select * from ordertable" whetwe otder = ?)


    }


}
