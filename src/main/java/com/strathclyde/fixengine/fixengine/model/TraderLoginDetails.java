package com.strathclyde.fixengine.fixengine.model;

import java.util.Objects;

/***
 * This class represent the login details of trader and its fields loginStatus, loginRole, employeeId.
 * @author vijayshreejoshi
 */
public class TraderLoginDetails {

    private String loginStatus; //variable to represent login Status during login
    private String loginRole; //variable to represent login Role during login
    private String employeeId; //variable to represent employee Id during login

    /***
     *  This constructor is used to initialize the value of variable.
     * @param employeeId to give value of  employee Id
     * @param loginStatus to give value of employee login status
     * @param loginRole to give value of employee login role
     */
    public TraderLoginDetails(final String employeeId, final String loginStatus, final String loginRole ) {
        this.employeeId = employeeId;
        this.loginStatus = loginStatus;
        this.loginRole = loginRole;
    }

    /***
     * This getter method give value of  employee id.
     * @return string value of employeeId
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /***
     * This setter method is used to set value of employeeId
     * @param employeeId variable to store employee id.
     */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    /***
     * This getter method give value of  login status.
     * @return loginStatus of type String
     */
    public String getLoginStatus() {
        return loginStatus;
    }

    /***
     * This setter method to set login status.
     * @param loginStatus variable to store  login status of type string
     */
    public void setLoginStatus(String loginStatus) {
        this.loginStatus = loginStatus;
    }

    /***
     * This getter method give value of login role.
     * @return loginRole of type String
     */
    public String getLoginRole() {
        return loginRole;
    }

    /***
     * This setter method to set login role.
     * @param loginRole variable to store of type string
     */
    public void setLoginRole(String loginRole) {
        this.loginRole = loginRole;
    }

    /***
     * String representation of class.
     * @return value of all fields as a string.
     */
    @Override
    public String toString() {
        return "TraderLoginDetails{" +
                "loginStatus='" + loginStatus + '\'' +
                ", loginRole='" + loginRole + '\'' +
                ", employeeId='" + employeeId + '\'' +
                '}';
    }

    /***
     * To compare quality of two object of TraderLoginDetails.
     * @param o to be compare
     * @return true if two object are equal else false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TraderLoginDetails)) return false;
        TraderLoginDetails that = (TraderLoginDetails) o;
        return loginStatus.equals(that.loginStatus) && loginRole.equals(that.loginRole) && employeeId.equals(that.employeeId);
    }

    /***
     * Generate unique code for each object.
     * @return unique hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(loginStatus, loginRole, employeeId);
    }

}
