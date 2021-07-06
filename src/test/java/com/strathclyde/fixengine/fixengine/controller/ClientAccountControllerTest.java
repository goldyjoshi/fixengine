package com.strathclyde.fixengine.fixengine.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClientAccountControllerTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ClientAccountController clientAccountController;

    @Test
    public void getClientsAccountTest() {
        // Given an account exist in db.
        // add one account in db.
        String clientAccountId = "TestAccount";
        String traderEmployeeId = "TradeTestId";
        String insertAccount = "INSERT INTO client_account VALUES(?, ?)";
        int insertStatus = jdbcTemplate.update(insertAccount, clientAccountId, traderEmployeeId);
        if (insertStatus > 0) {

            // when clientAccountController.getClientsAccount() has been called
            List<String> clientAccount = clientAccountController.getClientsAccount();

            //Then account added in Db should exist in the list
            assertTrue(clientAccount.contains(clientAccountId));

            // clean up database by deleting test account
            String deleteAccountSql = "delete from client_account where client_account_id = ?";
            int deleteStatus = jdbcTemplate.update(deleteAccountSql, clientAccountId);
            if (deleteStatus > 0) {
                System.out.println("Database clean up has been done successfully by removing.");
            } else {
                fail("Failed to remove account from Database.");
            }

        } else {
            fail("Insertion of Account Id in the database has been failed ");
        }




    }

}