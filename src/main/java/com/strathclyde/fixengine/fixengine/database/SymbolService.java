package com.strathclyde.fixengine.fixengine.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/***
 * This class is represent the SymbolService like get symbols and retrieve symbols from database
 * @author vijayshreejoshi
 */
@Service
public class SymbolService implements ISymbolService {

    @Autowired
    private JdbcTemplate jdbcTemplateForSymbol;

    /***
     * This getter method is used to get all list of symbol.
     * @return value of symbolList of type List.
     */
    public List<String> getSymbolList() {
        List<String> symbolList = new ArrayList<>();
        List<Map<String, Object>> resultSet = retrieveSymbolsFromDatabase();
        for (Map<String, Object> row: resultSet) {
            for (String column : row.keySet()) {
                if(column.equalsIgnoreCase("symbol_name")) {
                    symbolList.add(row.get(column).toString());
                }
            }
        }
        return symbolList;

    }

    /***
     * This method is used to retrieve symbols list from database using sql query.
     * @return value of result of type List.
     */
    private List<Map<String, Object>> retrieveSymbolsFromDatabase() {
        String retrieveSymbolsSql = "select symbol_name from symbol";
        List<Map<String, Object>> result = jdbcTemplateForSymbol.queryForList(retrieveSymbolsSql);
        return result;
    }

}
