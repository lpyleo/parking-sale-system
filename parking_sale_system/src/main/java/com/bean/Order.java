package com.bean;
import java.io.Serializable;
import java.util.Date;

public class Order extends Developer_administrator implements Serializable{
    private String orderId;
    private String parkingSpaceId;
    private String contractSignatory;
    private String contractInitiator;
    private String contractContent;
    private Date orderTime;
    private String paymentMethod;
    private double finalPrice;
    private double deposit;
    private int state;
    private String purchaseMethod;
    private Date finalPaymentTime;

    public Order() {
    }

    public Order(String orderId, String parkingSpaceId, String contractSignatory, String contractInitiator, String contractContent, Date orderTime, String paymentMethod, double finalPrice, double deposit, int state, String purchaseMethod, Date finalPaymentTime) {
        this.orderId = orderId;
        this.parkingSpaceId = parkingSpaceId;
        this.contractSignatory = contractSignatory;
        this.contractInitiator = contractInitiator;
        this.contractContent = contractContent;
        this.orderTime = orderTime;
        this.paymentMethod = paymentMethod;
        this.finalPrice = finalPrice;
        this.deposit = deposit;
        this.state = state;
        this.purchaseMethod = purchaseMethod;
        this.finalPaymentTime = finalPaymentTime;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getParkingSpaceId() {
        return parkingSpaceId;
    }

    public void setParkingSpaceId(String parkingSpaceId) {
        this.parkingSpaceId = parkingSpaceId;
    }

    public String getContractSignatory() {
        return contractSignatory;
    }

    public void setContractSignatory(String contractSignatory) {
        this.contractSignatory = contractSignatory;
    }

    public String getContractInitiator() {
        return contractInitiator;
    }

    public void setContractInitiator(String contractInitiator) {
        this.contractInitiator = contractInitiator;
    }

    public String getContractContent() {
        return contractContent;
    }

    public void setContractContent(String contractContent) {
        this.contractContent = contractContent;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getPurchaseMethod() {
        return purchaseMethod;
    }

    public void setPurchaseMethod(String purchaseMethod) {
        this.purchaseMethod = purchaseMethod;
    }

    public Date getFinalPaymentTime() {
        return finalPaymentTime;
    }

    public void setFinalPaymentTime(Date finalPaymentTime) {
        this.finalPaymentTime = finalPaymentTime;
    }
}
