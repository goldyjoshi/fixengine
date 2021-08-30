package com.strathclyde.fixengine.fixengine.database;

import com.strathclyde.fixengine.fixengine.model.TraderDetails;
import com.strathclyde.fixengine.fixengine.model.TraderLoginDetails;

/***
 * ISignupAndLoginService represent contract to be implemented for signup and login operation related to database.
 * @author Vijayshreejoshi
 */
public interface ISignupAndLoginService {

    void signup(final TraderDetails tradeDetails);
    TraderLoginDetails login(final String loginId, final String loginPassword);

}
