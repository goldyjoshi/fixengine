package com.strathclyde.fixengine.fixengine.database;

import java.util.List;

/***
 * ISymbolService represent contract to be implemented for symbol operation related to database.
 * @author Vijayshreejoshi
 */
public interface ISymbolService {

    List<String> getSymbolList();

}
