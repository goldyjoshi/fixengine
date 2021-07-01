package com.strathclyde.fixengine.fixengine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClientAccountControllerTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ClientAccountController clientAccountController;

    public void getClientsAccountTest() {

    }

}