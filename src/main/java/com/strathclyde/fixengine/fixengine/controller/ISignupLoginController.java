package com.strathclyde.fixengine.fixengine.controller;

import com.strathclyde.fixengine.fixengine.model.TraderDetails;
import com.strathclyde.fixengine.fixengine.model.TraderLoginDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

/***
 * ISignupLoginController represent contract to be implemented for login and signup.
 * @author Vijayshreejoshi
 */
public interface ISignupLoginController {

    TraderDetails signup(@RequestBody TraderDetails traderDetails);
    TraderLoginDetails login(@RequestHeader("Authorization") String authHeader);

}
