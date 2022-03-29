package com.bean;
import java.io.Serializable;
import java.util.Date;
public class UserAdminBill implements Serializable{
    private String id;
    private String type;
    private String snederId;
    private String receiverId;
    private double money;
    private Date time;
    private String orderId;

    public UserAdminBill() {
    }

    public UserAdminBill(String id, String type, String snederId, String receiverId, double money, Date time, String orderId) {
        this.id = id;
        this.type = type;
        this.snederId = snederId;
        this.receiverId = receiverId;
        this.money = money;
        this.time = time;
        this.orderId = orderId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSnederId() {
        return snederId;
    }

    public void setSnederId(String snederId) {
        this.snederId = snederId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
