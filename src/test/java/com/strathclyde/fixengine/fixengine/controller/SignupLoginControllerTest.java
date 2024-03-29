package com.strathclyde.fixengine.fixengine.controller;

import com.strathclyde.fixengine.fixengine.model.TraderDetails;
import com.strathclyde.fixengine.fixengine.model.TraderLoginDetails;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class SignupLoginControllerTest {

    @Autowired
    private  SignupLoginController signupLoginController;

    @Mock
    private  SignupLoginController signupLoginControllerMock;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void loginTest() {
        // Given used exist.
        String authHeader = "Basic" + "Login" + ":" + "password";
        String tradeEmployeeId = "E12345";
        String loginRole = "Trader";
        String status = "success";
        Mockito.when(signupLoginControllerMock.login(authHeader)).thenReturn(new
                TraderLoginDetails(tradeEmployeeId, status, loginRole));

        // When used login.
        TraderLoginDetails traderLoginDetails = signupLoginControllerMock.login(authHeader);

        // Then user login successfully.
        Assertions.assertNotNull(traderLoginDetails);
        Assertions.assertEquals(traderLoginDetails.getLoginStatus(), status);
        Assertions.assertEquals(traderLoginDetails.getLoginRole(), loginRole);
        Assertions.assertEquals(traderLoginDetails.getEmployeeId(), tradeEmployeeId);
    }

    @Test
    public void signupTest() {
        //Given
        String tradeEmployeeId = "E12345";
        TraderDetails tradeDetails = new TraderDetails(tradeEmployeeId, "Ram@gmail.com",
                "rAm1234#", "Trader");

        // When user signup
        signupLoginController.signup(tradeDetails);

        //then trade details are present in the database.
        String checkSignUp = "select * from trader_details where trader_employee_id = ?";
        List<Map<String, Object>> result = jdbcTemplate.queryForList(checkSignUp, tradeEmployeeId);
        String actualTradeEmployeeId = (String) result.get(0).get("trader_employee_id");
        // check trade with same trade employee id is present in database.
        Assertions.assertEquals(tradeEmployeeId, actualTradeEmployeeId);

        // cleaning dummy data from database.
        cleanupDummySignUp(tradeEmployeeId);
    }

    private void cleanupDummySignUp(String tradeEmployeeId) {
        String sql = "delete from trader_details where trader_employee_id = ?";
        int status = jdbcTemplate.update(sql, tradeEmployeeId);
        System.out.println("status of query = " + status);
    }

}
