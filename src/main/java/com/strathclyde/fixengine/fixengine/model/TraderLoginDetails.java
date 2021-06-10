package com.strathclyde.fixengine.fixengine.model;

public class TraderLoginDetails {
    private String traderEmailId;
    private String traderPassword;

    public TraderLoginDetails(String traderEmailId, String traderPassword) {
        this.traderEmailId = traderEmailId;
        this.traderPassword = traderPassword;
    }

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
}
