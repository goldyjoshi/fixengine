package com.strathclyde.fixengine.fixengine.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class SymbolService {

    @Autowired
    private JdbcTemplate jdbcTemplateForSymbol;

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

    private List<Map<String, Object>> retrieveSymbolsFromDatabase() {
        String retrieveSymbolsSql = "select symbol_name from symbol";
        List<Map<String, Object>> result = jdbcTemplateForSymbol.queryForList(retrieveSymbolsSql);
        return result;
    }
}
