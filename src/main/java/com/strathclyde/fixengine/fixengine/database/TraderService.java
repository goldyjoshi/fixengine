package com.strathclyde.fixengine.fixengine.database;

import com.strathclyde.fixengine.fixengine.model.TraderDetails;
import com.strathclyde.fixengine.fixengine.model.TraderLoginDetails;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

@Service
public class TraderService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void signup(TraderDetails tradeDetails) {
        String insertTraderDetails = "insert into trader_details(trader_employee_id, trader_email, trader_password, " +
                "login_role) " +
                "values(?, ?, ?, ?)";
        String rawPassword = tradeDetails.getTraderPassword();
//        String encodedPassword = Base64.encodeBase64(rawPassword.getBytes(StandardCharsets.UTF_8)).toString();
        int status = jdbcTemplate.update(insertTraderDetails, tradeDetails.getTraderEmployeeId(),
                tradeDetails.getTraderEmailId(), rawPassword, tradeDetails.getLoginRole());
        if (status > 0) {
            System.out.println("Trader " + tradeDetails.toString() + " has been successfully signup.");
        } else {
            System.out.println("Signup for " + tradeDetails.toString() + " has been unsuccessful.");
        }
    }

    public TraderLoginDetails login(final String loginId, final String loginPassword) {
        String selectLogInDetails = "select * from trader_details where trader_email= ? ";

        List<Map<String, Object>> result = jdbcTemplate.queryForList(selectLogInDetails, loginId);

        String employeeId = "";
        String status = "failed";
        String loginRole = "";
        if (result != null && result.size() == 1 ) {
            Map<String, Object> row = result.get(0);
            employeeId = row.get("trader_employee_id").toString();
            loginRole = row.get("login_role").toString();
            String password = row.get("trader_password").toString();
            if (password.equals(loginPassword)) {
                status = "success";
            }
        }
        TraderLoginDetails traderLoginDetails = new TraderLoginDetails(employeeId, status, loginRole);
        return traderLoginDetails;
    }
}