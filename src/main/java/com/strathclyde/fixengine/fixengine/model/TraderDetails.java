package com.strathclyde.fixengine.fixengine.model;

public class TraderDetails {
    private String traderEmployeeId;
    private String traderEmailId;
    private String traderPassword;
    private String loginRole;       // variable to store role during signup.

    /***
     * This constructor is used to initialize the value of variable.
     * @param traderEmployeeId to give value of trder employee Id.
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

    public void setTraderEmployeeId(String traderEmployeeId) {
        this.traderEmployeeId = traderEmployeeId;
    }

    /***
     * This getter method give value of trader em id.
     * @return
     */
    public String getTraderEmailId() {
        return traderEmailId;
    }

    public void setTraderEmailId(String traderEmailId) {
        this.traderEmailId = traderEmailId;
    }

    public String getTraderPassword() {
        return traderPassword;
    }

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
     * @param loginRole value
     */
    public void setLoginRole(String loginRole) {
        this.loginRole = loginRole;
    }

    @Override
    public String toString() {
        return "TraderDetails{" +
                "traderEmployeeId='" + traderEmployeeId + '\'' +
                ", traderEmailId='" + traderEmailId + '\'' +
                ", traderPassword='" + traderPassword + '\'' +
                ", loginRole='" + loginRole + '\'' +
                '}';
    }
}
