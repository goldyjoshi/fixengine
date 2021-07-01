package com.strathclyde.fixengine.fixengine.database;

import com.strathclyde.fixengine.fixengine.model.SingleOrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;
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
        String orderId = UUID.randomUUID().toString();
        singleOrderRequest.setOrderId(orderId);

        //when
        orderService.insertOrderInDatabase(singleOrderRequest);

        //Then check order inserted in database
        List<Map<String, Object>> orderResultSet = jdbcTemplate.queryForList("select * from order_detail where order_id = " + orderId);
        for(Map<String, Object>  orderRow : orderResultSet) {
            for (String orderColumn: orderRow.keySet()) {
                if(orderColumn == orderId ) {

                }


            }
        }

    }


}
