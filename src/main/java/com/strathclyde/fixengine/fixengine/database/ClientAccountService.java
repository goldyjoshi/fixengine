package com.strathclyde.fixengine.fixengine.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ClientAccountService {

    @Autowired
    private JdbcTemplate jdbcTemplateForAccountRetrieval;

    public List<String> getAccountList() {
        List<String> accountList = new ArrayList<>();
        List<Map<String, Object>> resultList = retrieveAccountFromDatabase();
        for(Map<String, Object> row : resultList) {
            for(String column : row.keySet()) {
                if (column.equalsIgnoreCase("clinet_account_id")) {
                    accountList.add(row.get(column).toString());
                }
            }
        }
        return accountList;
    }

    private List<Map<String, Object>>  retrieveAccountFromDatabase() {
        String sql = "select clinet_account_id from client_account";
        List<Map<String, Object>> resultList = jdbcTemplateForAccountRetrieval.queryForList(sql);
        return resultList;
    }


}
