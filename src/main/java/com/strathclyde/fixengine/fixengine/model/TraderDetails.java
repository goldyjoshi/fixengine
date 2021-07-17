package com.strathclyde.fixengine.fixengine.model;

/***
 * This class represent the traderDetails and it fields.
 */
public class TraderDetails {
    private String traderEmployeeId; // variable to store Employee Id during signup
    private String traderEmailId; // variable to store Email Id during signup
    private String traderPassword; // variable to store Password during signup
    private String loginRole;  // variable to store role during signup.

    /***
     * This constructor is used to initialize the value of variable.
     * @param traderEmployeeId to give value of trader employee Id.
     * @param traderEmailId to give value of trader email Id.
     * @param traderPassword to give value of trader password
     */
    public TraderDetails(final String traderEmployeeId, final String traderEmailId, final String traderPassword,
                         final String loginRole ) {
        this.traderEmployeeId = traderEmployeeId;
        this.traderEmailId = traderEmailId;
        this.traderPassword = traderPassword;
        this.loginRole = loginRole;
    }

    /***
     * This getter method give value of trader employee id.
     * @return String value of traderEmployeeId
     */
    public String getTraderEmployeeId() {
        return traderEmployeeId;
    }

    /***
     * This setter method is used to set value of employee id
     * @param traderEmployeeId variable to store traderEmployeeId
     */
    public void setTraderEmployeeId(String traderEmployeeId) {
        this.traderEmployeeId = traderEmployeeId;
    }

    /***
     * This getter method give value of Email id.
     * @return traderEmailId of type String
     */
    public String getTraderEmailId() {
        return traderEmailId;
    }

    /***
     * This setter method is used to set value of employee email id.
     * @param traderEmailId variable to store the employee email id
     */
    public void setTraderEmailId(String traderEmailId) {
        this.traderEmailId = traderEmailId;
    }

    /***
     * This getter method is used to get value of employee password.
     * @return traderPassword of type String
     */
    public String getTraderPassword() {
        return traderPassword;
    }

    /***
     * This setter method is used to set value of employee password.
     * @param traderPassword variable to store the password of employee
     */
    public void setTraderPassword(String traderPassword) {
        this.traderPassword = traderPassword;
    }

    /***
     * This method is used to get value of login role.
     * @return String value of loginRole
     */
    public String getLoginRole() {
        return loginRole;
    }

    /***
     * This setter method is used to set value of loginRole.
     * @param loginRole variablt to store role of employee
     */
    public void setLoginRole(String loginRole) {
        this.loginRole = loginRole;
    }

    @Override
    public String toString() {
        return "TraderDetails{" +
                "traderEmployeeId =" + traderEmployeeId + '\n' +
                "traderEmailId =" + traderEmailId + '\n' +
                "traderPassword =" + traderPassword + '\n' +
                "loginRole =" + loginRole ;
    }
}
