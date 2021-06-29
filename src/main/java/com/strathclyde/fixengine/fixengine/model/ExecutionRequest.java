package com.strathclyde.fixengine.fixengine.model;

public class ExecutionRequest {
    private String orderId;
    private String accountId;
    private double totalQuantity;
    private String symbol;
    private String side;
    private int executedQuantity;
    private double executionPrice;
    private String execType;

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

    public int getExecutedQuantity() {
        return executedQuantity;
    }

    public void setExecutedQuantity(int executedQuantity) {
        this.executedQuantity = executedQuantity;
    }

    public double getExecutionPrice() {
        return executionPrice;
    }

    public void setExecutionPrice(double executionPrice) {
        this.executionPrice = executionPrice;
    }
}
