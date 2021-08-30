package com.strathclyde.fixengine.fixengine.model;

import java.util.Objects;

/***
 * This class represent model for execution request. It is child class of Request class.
 * @author vijayshreejoshi
 */
public class ExecutionRequest extends Request {

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

    /***
     * String representation of class.
     * @return value of all fields as a string.
     */
    @Override
    public String toString() {
        return "ExecutionRequest{" +
                "orderId='" + orderId + '\'' +
                ", accountId='" + accountId + '\'' +
                ", symbol='" + symbol + '\'' +
                ", side='" + side + '\'' +
                ", totalQuantity=" + totalQuantity +
                ", quantityRequestedForExec=" + quantityRequestedForExec +
                ", previousExecQuantity=" + previousExecQuantity +
                ", executionPrice=" + executionPrice +
                ", execType='" + execType + '\'' +
                '}';
    }

    /***
     * To compare quality of two object of ExecutionReport.
     * @param o to be compare
     * @return true if two object are equal else false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExecutionRequest)) return false;
        ExecutionRequest that = (ExecutionRequest) o;
        return Double.compare(that.totalQuantity, totalQuantity) == 0 && Double.compare(that.quantityRequestedForExec, quantityRequestedForExec) == 0 && Double.compare(that.previousExecQuantity, previousExecQuantity) == 0 && Double.compare(that.executionPrice, executionPrice) == 0 && orderId.equals(that.orderId) && accountId.equals(that.accountId) && symbol.equals(that.symbol) && side.equals(that.side) && execType.equals(that.execType);
    }

    /***
     * Generate unique code for each object.
     * @return unique hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(orderId, accountId, symbol, side, totalQuantity, quantityRequestedForExec, previousExecQuantity, executionPrice, execType);
    }

}
