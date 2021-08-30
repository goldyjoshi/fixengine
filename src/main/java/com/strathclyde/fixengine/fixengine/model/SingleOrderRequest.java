package com.strathclyde.fixengine.fixengine.model;

import java.util.Objects;

/***
 * This model class represents Single Order Request. It is child class of Request class.
 * @author vijayshreejoshi
 */
public class SingleOrderRequest extends Request {

    private double quantity; //Variable to store the unique value of quantity of requested order.
    private double executedQuantity; //Variable to store the unique value of executed quantity of requested order.
    private String status; //Variable to represent the unique value of status of order.

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
     * String representation of class.
     * @return value of all fields as a string.
     */
    @Override
    public String toString() {
        return "SingleOrderRequest{" +
                "orderId='" + orderId + '\'' +
                ", accountId='" + accountId + '\'' +
                ", quantity=" + quantity +
                ", executedQuantity=" + executedQuantity +
                ", status='" + status + '\'' +
                ", symbol='" + symbol + '\'' +
                ", side='" + side + '\'' +
                '}';
    }

    /***
     * To compare quality of two object of SingleOrderRequest.
     * @param o to be compare
     * @return true if two object are equal else false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SingleOrderRequest)) return false;
        SingleOrderRequest that = (SingleOrderRequest) o;
        return Double.compare(that.quantity, quantity) == 0 && Double.compare(that.executedQuantity, executedQuantity) == 0 && orderId.equals(that.orderId) && accountId.equals(that.accountId) && status.equals(that.status) && symbol.equals(that.symbol) && side.equals(that.side);
    }

    /***
     * Generate unique code for each object.
     * @return unique hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(orderId, accountId, quantity, executedQuantity, status, symbol, side);
    }

}
