package com.strathclyde.fixengine.fixengine.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/***
 * This class represent ClientAccountService.
 * @author vijayshreejoshi
 */
@Service
public class ClientAccountService implements IClientAccountService {

    /***
     * variable of type JdbcTemplate which execute SQL queries over ResultSets to retrieve the account
     */
    @Autowired
    private JdbcTemplate jdbcTemplateForAccountRetrieval;

    /***
     * This method is used to get account by using for loop first on list of map and second on map of string and
     *  object to find client account id.
     * @return account list of type string
     */
    public List<String> getAccountList() {
        List<String> accountList = new ArrayList<>();
        List<Map<String, Object>> resultList = retrieveAccountFromDatabase();
        for(Map<String, Object> row : resultList) {
            for(String column : row.keySet()) {
                if (column.equalsIgnoreCase("client_account_id")) {
                    accountList.add(row.get(column).toString());
                }
            }
        }
        return accountList;
    }

    /***
     * This method is used to get data from database using sql query.
     * @return list of account
     */
    private List<Map<String, Object>>  retrieveAccountFromDatabase() {
        String sql = "select client_account_id from client_account";
        List<Map<String, Object>> resultList = jdbcTemplateForAccountRetrieval.queryForList(sql);
        return resultList;
    }

}
