package com.strathclyde.fixengine.fixengine.model;

public class TraderDetails {
    private String traderEmployeeId;
    private String traderEmailId;
    private String traderPassword;

    /***
     * This constructor is used to initialize the value of variable.
     * @param traderEmployeeId to give value of trder employee Id.
     * @param traderEmailId to give value of trader email Id.
     * @param traderPassword to give value of trader password
     */
    public TraderDetails(final String traderEmployeeId, final String traderEmailId, final String traderPassword) {
        this.traderEmployeeId = traderEmployeeId;
        this.traderEmailId = traderEmailId;
        this.traderPassword = traderPassword;
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

    @Override
    public String toString() {
        return "TraderDetails{" +
                "traderEmployeeId='" + traderEmployeeId + '\'' +
                ", traderEmailId='" + traderEmailId + '\'' +
                ", traderPassword='" + traderPassword + '\'' +
                '}';
    }
}
