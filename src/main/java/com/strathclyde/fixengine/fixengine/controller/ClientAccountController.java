package com.strathclyde.fixengine.fixengine.controller;

import com.strathclyde.fixengine.fixengine.database.ClientAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/***
 * This class represent the rest controller of client account  is used to build REST api
 * in a declarative way and provide the RESTFUL web service at runtime.
 * @author vijayshreejoshi
 */
@RestController
public class ClientAccountController {

    /***
     * Variable to store value of ClientAccountService which perform all functionality of database.
     */
    @Autowired
    private ClientAccountService clientAccountService;


    /***
     * This method is used to get list of all clients account.
     * @return clientList of type string.
     */
    @GetMapping("/clients")
    public List<String> getClientsAccount() {
        List<String> clientList = clientAccountService.getAccountList();
        return clientList;
    }
}
