package com.strathclyde.fixengine.fixengine.database;

import java.util.List;

/***
 * IClientAccountService represent contract to be implemented for client account operation related to database.
 * @author Vijayshreejoshi
 */
public interface IClientAccountService {

    List<String> getAccountList();

}
