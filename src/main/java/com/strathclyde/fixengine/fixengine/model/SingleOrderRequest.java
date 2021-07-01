package com.strathclyde.fixengine.fixengine.model;

public class SingleOrderRequest {
    private String orderId;
    private String accountId;
    private double quantity;
    private double executedQuantity;
    private String status;
    private String symbol;
    private String side;

    public double getExecutedQuantity() {
        return executedQuantity;
    }

    public void setExecutedQuantity(double executedQuantity) {
        this.executedQuantity = executedQuantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
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


}
