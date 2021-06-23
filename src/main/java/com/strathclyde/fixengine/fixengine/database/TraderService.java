package com.strathclyde.fixengine.fixengine.database;

import com.strathclyde.fixengine.fixengine.model.TraderDetails;
import com.strathclyde.fixengine.fixengine.model.TraderLoginDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class TraderService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void signup(TraderDetails tradeDetails) {
        String insertTraderDetails = "insert into trader_details(trader_employee_id, trader_email, trader_password) " +
                "values(?, ?, ?)";
        int status = jdbcTemplate.update(insertTraderDetails, tradeDetails.getTraderEmployeeId(),
                tradeDetails.getTraderEmailId(), tradeDetails.getTraderPassword());
        if (status > 0) {
            System.out.println("Trader " + tradeDetails.toString() + " has been successfully signup.");
        } else {
            System.out.println("Signup for " + tradeDetails.toString() + " has been unsuccessful.");
        }
    }

//    public void login(TraderLoginDetails traderLoginDetailsDetails) {
//        String selectLogInDetails = "select trader_email, trader_password from trader_details where trader_email= ? ";
//        int loginStatus = jdbcTemplate.update(selectLogInDetails, traderLoginDetailsDetails.getTraderEmailId());
//
//    }
}
