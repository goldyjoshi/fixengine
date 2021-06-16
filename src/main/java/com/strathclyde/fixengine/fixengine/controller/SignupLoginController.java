package com.strathclyde.fixengine.fixengine.controller;

import com.strathclyde.fixengine.fixengine.database.TraderService;
import com.strathclyde.fixengine.fixengine.model.TraderDetails;
import com.strathclyde.fixengine.fixengine.model.TraderLoginDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


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

//    @GetMapping("/login")
//    public void login(@RequestBody TraderLoginDetails traderLoginDetails) {
//        System.out.println("Successful Login");
//        traderService.login(traderLoginDetails);
//    }
}
