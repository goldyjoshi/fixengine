package com.strathclyde.fixengine.fixengine.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class TraderDetailsTest {

    @Test
    public void traderDetailsGetterSetterTest() {
        //Given
        String traderEmployeeIdInitialValue = "ET740";
        String traderEmailIdInitialValue = "abc@gmail.com";
        String traderPasswordInitialValue = "password";
        String loginRoleInitialValue = "Broker";

        // When
        TraderDetails traderDetails = new TraderDetails(traderEmployeeIdInitialValue
                , traderEmailIdInitialValue
                , traderPasswordInitialValue
                , loginRoleInitialValue);

        // Then check initial value.
        assertEquals(traderDetails.getTraderEmailId(), traderEmailIdInitialValue);
        assertEquals(traderDetails.getTraderEmployeeId(), traderEmployeeIdInitialValue);
        assertEquals(traderDetails.getTraderPassword(), traderPasswordInitialValue);
        assertEquals(traderDetails.getLoginRole(), loginRoleInitialValue);

        // When value changed.
        String traderEmployeeIdModifiedValue = "ET777";
        String traderEmailIdModifiedValue = "pqr@gmail.com";
        String traderPasswordModifiedValue = "password@modified";
        String loginRoleModifiedValue = "Trader";

        traderDetails.setTraderEmployeeId(traderEmployeeIdModifiedValue);
        traderDetails.setTraderEmailId(traderEmailIdModifiedValue);
        traderDetails.setTraderPassword(traderPasswordModifiedValue);
        traderDetails.setLoginRole(loginRoleModifiedValue);

        // Then check modified value.
        assertEquals(traderDetails.getTraderEmailId(), traderEmailIdModifiedValue);
        assertEquals(traderDetails.getTraderEmployeeId(), traderEmployeeIdModifiedValue);
        assertEquals(traderDetails.getTraderPassword(), traderPasswordModifiedValue);
        assertEquals(traderDetails.getLoginRole(), loginRoleModifiedValue);
    }

}


