package com.strathclyde.fixengine.fixengine.model;

/***
 * This class represents the Single Order Request and its fields orderId, accountId, quantity, executedQuantity, status,
 * symbol, side
 * @author vijayshreejoshi
 */
public class SingleOrderRequest {
    private String orderId; //Variable to store the unique value of order Id.
    private String accountId; //Variable to store the unique value of account Id.
    private double quantity; //Variable to store the unique value of quantity of requested order.
    private double executedQuantity; //Variable to store the unique value of executed quantity of requested order.
    private String status; //Variable to represent the unique value of status of order.
    private String symbol; //Variable to represent the unique value of symbol.
    private String side; //Variable to represent the unique value of side(buy/sell).

    /***
     * This getter method is used to get executed quantity of order.
     * @return executedQuantity of type double
     */
    public double getExecutedQuantity() {
        return executedQuantity;
    }

    /***
     * This setter method is used to set value of executed quantity of order.
     * @param executedQuantity variable to store the value of executed quantity of  requested order
     */
    public void setExecutedQuantity(double executedQuantity) {
        this.executedQuantity = executedQuantity;
    }


    /***
     * This getter method is used to get  status of order.
     * @return status of type String
     */
    public String getStatus() {
        return status;
    }

    /***
     * This setter method is used to set value of status requested order.
     * @param status variable to represent value of type String
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /***
     * This getter method is used to get Id of requested order.
     * @return orderId of type String
     */
    public String getOrderId() {
        return orderId;
    }

    /***
     * This setter method is used to set value  requested order id.
     * @param orderId variable to store order id
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /***
     * This getter method is used to get account Id of requested order.
     * @return accountId of type String
     */
    public String getAccountId() {
        return accountId;
    }

    /***
     * This setter method is used to set value of account id whose order is requested.
     * @param accountId variable to store Id of account who want to place an order
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    /***
     * This getter method is used to get value of quantity requested order.
     * @return quantity of type double
     */
    public double getQuantity() {
        return quantity;
    }

    /***
     * This setter method is used to set value of quantity of requested order.
     * @param quantity variable to store
     */
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    /***
     * This getter method is used to get value of symbol whose order is requested.
     * @return symbol of String
     */
    public String getSymbol() {
        return symbol;
    }

    /***
     * This setter method is used to set value of symbol whose order is requested.
     * @param symbol variable to represent symbol name of String
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /***
     * This getter method is used to get value of side either buy or sell.
     * @return side(buy/sell) of type String
     */
    public String getSide() {
        return side;
    }

    /***
     * This setter method is used to set value which represent side(Buy or Sell)
     * @param side variable to represent side value(buy/sell).
     */
    public void setSide(String side) {
        this.side = side;
    }


}
