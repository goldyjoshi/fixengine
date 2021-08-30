package com.strathclyde.fixengine.fixengine.database;

import com.strathclyde.fixengine.fixengine.model.TraderDetails;
import com.strathclyde.fixengine.fixengine.model.TraderLoginDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/***
 * This class represent SignupAndLoginService and responsible signup and login function.
 * It store user data into the database during signup and retrieve during login.
 * @author vijayshreejoshi .
 */
@Service
public class SignupAndLoginService implements  ISignupAndLoginService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /***
     * Method perform signup function and store user information into the database.
     * @param tradeDetails variable to hold value of trade details to be inserted.
     */
    public void signup(final TraderDetails tradeDetails) {
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

    /***
     * Method perform login function and validate user information by retrieving from database.
     * @param loginId string parameter to hold value of user login id.
     * @param loginPassword string parameter to hold value of user password.
     * @return TraderLoginDetails
     */
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