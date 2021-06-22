package com.strathclyde.fixengine.fixengine.controller;

import com.strathclyde.fixengine.fixengine.database.SymbolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SymbolController {

    @Autowired
    private SymbolService symbolService;

    @GetMapping("/symbols")
    public List<String> getSymbols() {
        List<String> listOfSymbol = symbolService.getSymbolList();
        return listOfSymbol;
    }

}
