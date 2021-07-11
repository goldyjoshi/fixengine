package com.strathclyde.fixengine.fixengine.controller;

import com.strathclyde.fixengine.fixengine.database.TraderService;
import com.strathclyde.fixengine.fixengine.model.TraderDetails;
import com.strathclyde.fixengine.fixengine.model.TraderLoginDetails;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;


/***
 *  This class implements a rest controller for signup and login function.
 * @author vijayshreejoshi
 */
@RestController
public class SignupLoginController {
    @Autowired
    private TraderService traderService;


    @PostMapping("/signup")
    public void signup(@RequestBody TraderDetails traderDetails) {
        System.out.println("Trader details are " + traderDetails);
        traderService.signup(traderDetails);
    }

    @GetMapping("/login")
    public TraderLoginDetails login(@RequestHeader( "Authorization") String authHeader) {
        System.out.println("Login with authHeader " + authHeader);
        String base64Credentials = authHeader.substring("Basic".length()).trim();
        byte[] credDecoded = Base64.decodeBase64(base64Credentials);
        String credentials = new String(credDecoded, StandardCharsets.UTF_8);
        final String[] values = credentials.split(":", 2);
        TraderLoginDetails traderLoginDetails = traderService.login(values[0], values[1]);
        return traderLoginDetails;
    }

//    @PostMapping("/submittrade")
//    public void submitTrade(@RequestBody Trade trade) {

//    }
//
//    @GetMapping("/getOrderStatus")
//    public OrderStatus getOrderStatus(@RequestParam("orderId") orderId) {

//    }

}
