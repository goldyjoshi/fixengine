package com.strathclyde.fixengine.fixengine.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TraderLoginDetailsTest {

    @Test
    public void traderLoginDetailsGetterAndSetterTest() {
        // Given TraderLoginDetails exist
        String loginStatusInitialValue = "Failed";
        String loginRoleInitialValue = "Trader";
        String employeeIdInitialValue = "EMP1234";

        TraderLoginDetails traderLoginDetails = new TraderLoginDetails(employeeIdInitialValue, loginStatusInitialValue,
                loginRoleInitialValue);

        // Check getter
        assertEquals(traderLoginDetails.getEmployeeId(), employeeIdInitialValue);
        assertEquals(traderLoginDetails.getLoginRole(), loginRoleInitialValue);
        assertEquals(traderLoginDetails.getLoginStatus(), loginStatusInitialValue);

        String loginStatusModifiedValue = "Success";
        String loginRoleModifiedValue = "Broker";
        String employeeIdModifiedValue = "EMP4321";
        // when value modified.
        traderLoginDetails.setLoginRole(loginRoleModifiedValue);
        traderLoginDetails.setLoginStatus(loginStatusModifiedValue);
        traderLoginDetails.setEmployeeId(employeeIdModifiedValue);

        // Check modified value
        assertEquals(traderLoginDetails.getEmployeeId(), employeeIdModifiedValue);
        assertEquals(traderLoginDetails.getLoginRole(), loginRoleModifiedValue);
        assertEquals(traderLoginDetails.getLoginStatus(), loginStatusModifiedValue);
    }

}
