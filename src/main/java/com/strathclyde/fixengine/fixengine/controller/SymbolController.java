package com.strathclyde.fixengine.fixengine.controller;

import com.strathclyde.fixengine.fixengine.database.SymbolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/***
 * This class represent the rest controller of Symbol is used to build REST api in a declarative way and
 * provide the RESTFUL web service at runtime.
 * @author vijayshreejoshi
 */
@RestController
public class SymbolController {

    /***
     * Variable symbolService using annotation Autowired used to inject the dependent bean of SymbolService
     */
    @Autowired
    private SymbolService symbolService;

    /***
     * This method is used to get list of symbols and @GetMapping is used to handle Get type of handle method
     * by provided appropriate path.
     * @return listOfSymbol of type String.
     */
    @GetMapping("/symbols")
    public List<String> getSymbols() {
        List<String> listOfSymbol = symbolService.getSymbolList();
        return listOfSymbol;
    }

}
