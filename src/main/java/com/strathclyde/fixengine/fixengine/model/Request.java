package com.strathclyde.fixengine.fixengine.model;

import java.util.Objects;

/***
 * This model class represent Request and parent of ExecutionRequest and SingleOrderRequest class.
 * @author vijayshreejoshi
 */
public class Request {

    protected String orderId; //Variable to store unique value of order Id.
    protected String accountId;//Variable to store unique value of account Id.
    protected String symbol; //Variable to store the names of symbol.
    protected String side; //To represent the trader side buy or sell

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
     * String representation of class.
     * @return value of all fields as a string.
     */
    @Override
    public String toString() {
        return "Request{" +
                "orderId='" + orderId + '\'' +
                ", accountId='" + accountId + '\'' +
                ", symbol='" + symbol + '\'' +
                ", side='" + side + '\'' +
                '}';
    }

    /***
     * To compare quality of two object of Request.
     * @param o to be compare
     * @return true if two object are equal else false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Request)) return false;
        Request request = (Request) o;
        return orderId.equals(request.orderId) && accountId.equals(request.accountId) && symbol.equals(request.symbol) && side.equals(request.side);
    }

    /***
     * Generate unique code for each object.
     * @return unique hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(orderId, accountId, symbol, side);
    }

}
