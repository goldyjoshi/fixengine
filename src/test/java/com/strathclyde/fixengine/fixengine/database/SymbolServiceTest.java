package com.strathclyde.fixengine.fixengine.database;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class SymbolServiceTest {

    @Autowired
    private SymbolService symbolService;

    @Test
    public void getSymbolListTest() {
        List<String> symbolList =  symbolService.getSymbolList();
        // Validate that we have more than one symbol in the system.
        assertNotNull(symbolList);
        assertTrue(symbolList.size() > 0);
    }

}
