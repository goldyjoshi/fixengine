package com.strathclyde.fixengine.fixengine.controller;

import com.strathclyde.fixengine.fixengine.database.ClientAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientAccountController {

    @Autowired
    private ClientAccountService clientAccountService;

    @GetMapping("/clients")
    public List<String> getClientsAccount() {
        List<String> clientList = clientAccountService.getAccountList();
        return clientList;
    }
}
