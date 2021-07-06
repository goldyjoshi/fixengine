package com.strathclyde.fixengine.fixengine.model;

public class ExecutionRequest {
    private String orderId;
    private String accountId;
    private String symbol;
    private String side;
    private double totalQuantity; // total order quantity.
    private double quantityRequestedForExec; // current request for execution.
    private double previousExecQuantity;   // total of previously executed quantity.
    private double executionPrice;
    private String execType;


    public double getPreviousExecQuantity() {
        return previousExecQuantity;
    }

    public void setPreviousExecQuantity(double previousExecQuantity) {
        this.previousExecQuantity = previousExecQuantity;
    }

    public String getExecType() {
        return execType;
    }

    public void setExecType(String execType) {
        this.execType = execType;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public double getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(double totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public double getQuantityRequestedForExec() {
        return quantityRequestedForExec;
    }

    public void setQuantityRequestedForExec(double quantityRequestedForExec) {
        this.quantityRequestedForExec = quantityRequestedForExec;
    }

    public double getExecutionPrice() {
        return executionPrice;
    }

    public void setExecutionPrice(double executionPrice) {
        this.executionPrice = executionPrice;
    }
}
