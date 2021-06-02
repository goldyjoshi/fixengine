package com.strathclyde.fixengine.fixengine.database;

import com.strathclyde.fixengine.fixengine.model.TradeDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class TradeService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void signup(TradeDetails tradeDetails) {
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
}
