package com.strathclyde.fixengine.fixengine.controller;

import java.util.List;

/***
 * ISymbolController represent contract to be implemented for symbol related data.
 * @author Vijayshreejoshi
 */
public interface ISymbolController {

    List<String> getSymbols();

}
