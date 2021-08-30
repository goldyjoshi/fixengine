package com.strathclyde.fixengine.fixengine.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class RequestTest {

    @Test
    public void requestGetterSetterTest() {
        //Given
       String orderIdModifiedValue = "Test1234";
       String accountIdModifiedValue = "ACC123";
       String symbolModifiedValue = "Apple";
       String sideModifiedValue = "Sell";

        // When object of Request created,
        Request request = new Request();

        // Then check initial value
        assertNull(request.getOrderId());
        assertNull(request.getAccountId());
        assertNull(request.getSide());
        assertNull(request.getSymbol());

        // When initial value modified
        request.setOrderId(orderIdModifiedValue);
        request.setAccountId(accountIdModifiedValue);
        request.setSymbol(symbolModifiedValue);
        request.setSide(sideModifiedValue);

        // Then check modified value.
        assertEquals(request.getOrderId(), orderIdModifiedValue);
        assertEquals(request.getSide(), sideModifiedValue);
        assertEquals(request.getSymbol(), symbolModifiedValue);
        assertEquals(request.getAccountId(), accountIdModifiedValue);
    }

}
