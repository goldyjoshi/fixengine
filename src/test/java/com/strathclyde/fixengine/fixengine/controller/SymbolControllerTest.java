package com.strathclyde.fixengine.fixengine.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
public class SymbolControllerTest {

    private static final String symbolID = "Test1234";
    private static final String symbolName = "TestSymbol";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private SymbolController symbolController;

    @Test
    public void getSymbolListTest() {
        //Given a symbol exist in DB
        //Add one symbol in db
        String insertSymbol = "INSERT INTO symbol VALUES( ?, ?)";
        int result = jdbcTemplate.update(insertSymbol, symbolID, symbolName);
//        update(insertSymbol, symbolID, symbolName);
        if (result > 0) {
            List<String> symbolList = symbolController.getSymbols();

            //Then symbol added in Db should exist in the list
            assertTrue(symbolList.contains(symbolName));
            cleanupSymbolData();
        } else {
            fail("Failed to remove account from Database");
        }
    }

    public void cleanupSymbolData() {
        String deleteSymbolSql = "delete from symbol where symbol_id = ?";
        int deleteResult = jdbcTemplate.update(deleteSymbolSql, symbolID);
        if (deleteResult > 0) {
            System.out.println("Database cleanup has been done successfully.");
        } else {
            fail("Failed to remove account from database.");
        }
    }

}
