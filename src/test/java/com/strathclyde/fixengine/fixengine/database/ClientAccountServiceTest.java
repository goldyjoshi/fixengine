package com.strathclyde.fixengine.fixengine.database;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
public class ClientAccountServiceTest {

    @Autowired
    private ClientAccountService clientAccountService;

    @Test
    public void getAccountListTest() {
        List<String> accountList = clientAccountService.getAccountList();

        // Validate that we have more than one account in the system.
        assertNotNull(accountList);
        assertTrue(accountList.size() > 0);
    }
}
