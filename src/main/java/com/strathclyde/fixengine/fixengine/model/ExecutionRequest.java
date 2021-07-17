package com.strathclyde.fixengine.fixengine.model;

/***
 * This class represent
 */
public class ExecutionRequest {
    private String orderId; //Variable to store unique value of order Id.
    private String accountId;//Variable to store unique value of account Id.
    private String symbol; //Variable to store the names of symbol.
    private String side; //To represent the trader side buy or sell
    private double totalQuantity; //to represent the quantity of orders symbol.
    private double quantityRequestedForExec; // current request quantity for execution.
    private double previousExecQuantity;   // total of previously executed quantity.
    private double executionPrice; //Variable to represent price of symbol for execution
    private String execType; //Variable to represent type of execution(partial/full)


    public double getPreviousExecQuantity() {
        return previousExecQuantity;
    }

    /***
     * This setter method is used to set value of employee email id.
     * @param previousExecQuantity
     */
    public void setPreviousExecQuantity(double previousExecQuantity) {
        this.previousExecQuantity = previousExecQuantity;
    }

    /***
     * This getter method give value of Email id.
     * @return
     */
    public String getExecType() {
        return execType;
    }

    /***
     * This setter method is used to set value of employee email id.
     * @param execType
     */
    public void setExecType(String execType) {
        this.execType = execType;
    }

    /***
     * This getter method give value of Email id.
     * @return
     */
    public String getOrderId() {
        return orderId;
    }

    /***
     * This setter method is used to set value of employee email id.
     * @param orderId
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /***
     * This getter method give value of Email id.
     * @return
     */
    public String getAccountId() {
        return accountId;
    }

    /***
     * This setter method is used to set value of employee email id.
     * @param accountId
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    /***
     * This getter method give value of Email id.
     * @return
     */
    public double getTotalQuantity() {
        return totalQuantity;
    }

    /***
     * This setter method is used to set value of employee email id.
     * @param totalQuantity
     */
    public void setTotalQuantity(double totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    /***
     * This getter method give value of Email id.
     * @return
     */
    public String getSymbol() {
        return symbol;
    }

    /***
     * v
     * @param symbol
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /***
     * This getter method give value of Email id.
     * @return
     */
    public String getSide() {
        return side;
    }

    /***
     * This setter method is used to set value of employee email id.
     * @param side
     */
    public void setSide(String side) {
        this.side = side;
    }

    /***
     * This getter method give value of Email id.
     * @return
     */
    public double getQuantityRequestedForExec() {
        return quantityRequestedForExec;
    }

    /***
     * This setter method is used to set value of employee email id.
     * @param quantityRequestedForExec
     */
    public void setQuantityRequestedForExec(double quantityRequestedForExec) {
        this.quantityRequestedForExec = quantityRequestedForExec;
    }

    /***
     * This getter method give value of Email id.
     * @return
     */
    public double getExecutionPrice() {
        return executionPrice;
    }

    /***
     * This setter method is used to set value of employee email id.
     * @param executionPrice
     */
    public void setExecutionPrice(double executionPrice) {
        this.executionPrice = executionPrice;
    }
}
