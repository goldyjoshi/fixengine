package com.strathclyde.fixengine.fixengine.model;

/***
 * This class represent ExecutionRequest for single order and its fields.
 * @author vijayshreejoshi
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

    /***
     * This getter method give value of already partially executed quantity.
     * @return previousExecQuantity of type double
     */
    public double getPreviousExecQuantity() {
        return previousExecQuantity;
    }

    /***
     * This setter method is used to set value of partially executed quantity.
     * @param previousExecQuantity store the value of partially executed ordered quantity
     */
    public void setPreviousExecQuantity(double previousExecQuantity) {
        this.previousExecQuantity = previousExecQuantity;
    }

    /***
     * This getter method give value of type of execution(partially/fully).
     * @return execType of type String
     */
    public String getExecType() {
        return execType;
    }

    /***
     * This setter method is used to set value of type of execution(partially/fully).
     * @param execType variable to represent type of execution.
     */
    public void setExecType(String execType) {
        this.execType = execType;
    }

    /***
     * This getter method give value of id of requested order.
     * @return orderId of type String.
     */
    public String getOrderId() {
        return orderId;
    }

    /***
     * This setter method is used to set value of id of requested order.
     * @param orderId variable to store the Id of order.
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /***
     * This getter method give value of account id whose order is requested.
     * @return accountId of type String.
     */
    public String getAccountId() {
        return accountId;
    }

    /***
     * This setter method is used to set value of account id whose order is requested.
     * @param accountId store the value of account Id.
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    /***
     * This getter method give value of total quantity of requested order.
     * @return totalQuantity of type double.
     */
    public double getTotalQuantity() {
        return totalQuantity;
    }

    /***
     * This setter method is used to set value of total quantity of requested order.
     * @param totalQuantity variable to represent the total quantity of order.
     */
    public void setTotalQuantity(double totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    /***
     * This getter method give value of symbol(like facebook, amazon etc)
     * @return symbol of type string
     */
    public String getSymbol() {
        return symbol;
    }

    /***
     * This setter method is used to set value of symbol(like facebook, amazon etc).
     * @param symbol variable to represent the symbol
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /***
     * This getter method give value of side(Buy or Sell).
     * @return side of type String
     */
    public String getSide() {
        return side;
    }

    /***
     * This setter method is used to set value of side(Buy or Sell).
     * @param side variable to represent side(Buy/Sell).
     */
    public void setSide(String side) {
        this.side = side;
    }

    /***
     * This getter method give value of quantity which is requested for execution.
     * @return quantityRequestedForExec of type double.
     */
    public double getQuantityRequestedForExec() {
        return quantityRequestedForExec;
    }

    /***
     * This setter method is used to set value of quantity which is requested for execution.
     * @param quantityRequestedForExec variable to store quantity of order for execution.
     */
    public void setQuantityRequestedForExec(double quantityRequestedForExec) {
        this.quantityRequestedForExec = quantityRequestedForExec;
    }

    /***
     * This getter method give value of price of symbol for execution
     * @return executionPrice of type double
     */
    public double getExecutionPrice() {
        return executionPrice;
    }

    /***
     * This setter method is used to set value of price of symbol for execution.
     * @param executionPrice variable to store price of execution.
     */
    public void setExecutionPrice(double executionPrice) {
        this.executionPrice = executionPrice;
    }
}
