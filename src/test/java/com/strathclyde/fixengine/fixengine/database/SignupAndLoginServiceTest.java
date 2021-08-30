package com.strathclyde.fixengine.fixengine.database;

import com.strathclyde.fixengine.fixengine.model.TraderDetails;
import com.strathclyde.fixengine.fixengine.model.TraderLoginDetails;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class SignupAndLoginServiceTest {

    @Autowired
    private SignupAndLoginService signupAndLoginService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void signupTest() {
        // Given trade details are provided.
        String tradeEmployeeId = "E12345";
        String loginId = "Ram@gmail.com";
        String password = "rAm1234#";
        String loginRole = "Trader";
        TraderDetails tradeDetails = new TraderDetails(tradeEmployeeId, loginId,
                password, loginRole);

        // when api is called to store trader details.
        signupAndLoginService.signup(tradeDetails);

        //then trade details are present in the database.
        String checkSignUp = "select * from trader_details where trader_employee_id = ?";
        List<Map<String, Object>> result = jdbcTemplate.queryForList(checkSignUp, tradeEmployeeId);
        String actualTradeEmployeeId = (String) result.get(0).get("trader_employee_id");
        // check trade with same trade employee id is present in database.
        Assertions.assertEquals(tradeEmployeeId, actualTradeEmployeeId);

        // When same user login into system
        TraderLoginDetails traderLoginDetails = signupAndLoginService.login(loginId, password);

        //then user able to login successfully.
        Assertions.assertNotNull(traderLoginDetails);
        Assertions.assertEquals(traderLoginDetails.getLoginRole(), loginRole);
        Assertions.assertEquals(traderLoginDetails.getEmployeeId(), tradeEmployeeId);
        Assertions.assertEquals(traderLoginDetails.getLoginStatus(), "success");

        // cleaning dummy data from database.
        cleanupDummySignUp(tradeEmployeeId);
    }

    private void cleanupDummySignUp(String tradeEmployeeId) {
        String sql = "delete from trader_details where trader_employee_id = ?";
        int status = jdbcTemplate.update(sql, tradeEmployeeId);
        System.out.println("status of query = " + status);
    }

}
