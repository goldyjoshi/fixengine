package com.strathclyde.fixengine.fixengine.controller;

import com.strathclyde.fixengine.fixengine.database.ISignupAndLoginService;
import com.strathclyde.fixengine.fixengine.model.TraderDetails;
import com.strathclyde.fixengine.fixengine.model.TraderLoginDetails;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;

/***
 *  This class implements a rest controller for signup and login function.
 *  is used to build REST api
 *  in a declarative way and provide the RESTFUL web service at runtime.
 * @author vijayshreejoshi
 */
@RestController
public class SignupLoginController implements ISignupLoginController{

    @Autowired
    private ISignupAndLoginService signupAndLoginService; //Variable to store the instances of TraderService.

    /***
     * This method is used to signup and having parameters  as object of TraderDetails (having variable
     * employee ID, EmailID, password, and login role. object of TraderService call its method.
     * @param traderDetails variable to store unique details of trader.
     */
    @PostMapping("/signup")
    public TraderDetails signup(@RequestBody TraderDetails traderDetails) {
        System.out.println("Trader details are " + traderDetails);
        signupAndLoginService.signup(traderDetails);
        return traderDetails;
    }

    /***
     * This method is used to authorize the login details which comes through header of message
     * and change login details in byte form for encoding. @GetMapping is used to  handle get type of
     * request method.
     * @param authHeader
     * @return traderLoginDetails as encoded form of type TraderLoginDetails.
     */
    @GetMapping("/login")
    public TraderLoginDetails login(@RequestHeader("Authorization") String authHeader) {
        System.out.println("Login with authHeader " + authHeader);
        String base64Credentials = authHeader.substring("Basic".length()).trim();
        byte[] credDecoded = Base64.decodeBase64(base64Credentials);
        String credentials = new String(credDecoded, StandardCharsets.UTF_8);
        final String[] values = credentials.split(":", 2);
        TraderLoginDetails traderLoginDetails = signupAndLoginService.login(values[0], values[1]);
        return traderLoginDetails;
    }

}
