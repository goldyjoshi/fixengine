package com.strathclyde.fixengine.fixengine.model;

public class TraderLoginDetails {
    private String loginStatus;
    private String loginRole;
    private String employeeId;

    public TraderLoginDetails(final String employeeId, final String loginStatus, final String loginRole ) {
        this.employeeId = employeeId;
        this.loginStatus = loginStatus;
        this.loginRole = loginRole;
    }

    @Override
    public String toString() {
        return "TraderLoginDetails{" +
                "traderEmailId='" + loginStatus + '\'' +
                ", traderPassword='" + loginRole + '\'' +
                ", employeeId='" + employeeId + '\'' +
                '}';
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(String loginStatus) {
        this.loginStatus = loginStatus;
    }

    public String getLoginRole() {
        return loginRole;
    }

    public void setLoginRole(String loginRole) {
        this.loginRole = loginRole;
    }
}
