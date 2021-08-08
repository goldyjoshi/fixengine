package com.strathclyde.fixengine.fixengine.model;

import com.strathclyde.fixengine.fixengine.utility.TestUtility;
import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TraderDetailsTest {

    private TraderDetails tradeDetails;
    private TestUtility testUtility;

//    @BeforeAll
//  public void init() {
//      tradeDetails = TestUtility.employeeDetails();
//  }

  @Test
    public void sample() {
      System.out.println("true");
  }


//    @IgnoreForBinding
//        public void setAndGetTraderEmployeeIdTest(){
//            final String expectedEmployeeId = "E75";
//            try {
//                tradeDetails.setTraderEmployeeId(expectedEmployeeId);
//                final String actualEmployeeId = tradeDetails.getTraderEmployeeId();
//                assertEquals( "Actual and expected employee Id are not same.", expectedEmployeeId, actualEmployeeId );
//            } catch (NullPointerException nullPointerException) {
//                System.out.println("Trader details arre empty");
//            }
//        }
//
//        @Test
//        @IgnoreForBinding
//        public void setAndGetTraderEmailIdTest() {
//            final String expectedEmailId = "Goldy@gmail.com";
//            try {
//                tradeDetails.setTraderEmailId( expectedEmailId );
//                final String actualEmployeeEmailId = tradeDetails.getTraderEmailId();
//                assertEquals( "Actual and expected employee Email Id are not same,", expectedEmailId, actualEmployeeEmailId );
//            } catch (NullPointerException nullPointerException) {
//                System.out.println("Trader details are empty");
//            }
//        }
//
//        @Test
//        public void setAndGetTraderPasswordIdTest() {
//            final String expectedPasswordId = "2goldy33@";
//            try {
//                tradeDetails.setTraderPassword( expectedPasswordId );
//                final String actualEmployeePasswordId = tradeDetails.getTraderPassword();
//                assertEquals( "Actual and expected employee password  are not same,", expectedPasswordId, actualEmployeePasswordId );
//            } catch (NullPointerException nullPointerException) {
//                System.out.println( "Trader details are empty" );
//            }
//        }
//
//        @Test
//        public void setAndGetLoginRoleTest() {
//            final String expectedLoginRole = "Trader";
//            try {
//                tradeDetails.setLoginRole( expectedLoginRole );
//                final String actualLoginRole = tradeDetails.getLoginRole();
//                assertEquals( "Actual and expected employee login role  are not same,", expectedLoginRole, actualLoginRole );
//            } catch (NullPointerException nullPointerException) {
//                System.out.println("Trader details are empty");
//            }
//        }

    }


