package com.bean;
import java.io.Serializable;
public class ParkingSpace implements Serializable{
    private String id;
    private String residentialQuartersId;
    private String photo;
    private String address;
    private double price;
    private String preferentialMeasures;
    private int state;
    private String buyersId;
    private int views;

    public ParkingSpace() {
    }

    public ParkingSpace(String id, String residentialQuartersId, String photo, String address, double price, String preferentialMeasures, int state, String buyersId, int views) {
        this.id = id;
        this.residentialQuartersId = residentialQuartersId;
        this.photo = photo;
        this.address = address;
        this.price = price;
        this.preferentialMeasures = preferentialMeasures;
        this.state = state;
        this.buyersId = buyersId;
        this.views = views;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResidentialQuartersId() {
        return residentialQuartersId;
    }

    public void setResidentialQuartersId(String residentialQuartersId) {
        this.residentialQuartersId = residentialQuartersId;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPreferentialMeasures() {
        return preferentialMeasures;
    }

    public void setPreferentialMeasures(String preferentialMeasures) {
        this.preferentialMeasures = preferentialMeasures;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getBuyersId() {
        return buyersId;
    }

    public void setBuyersId(String buyersId) {
        this.buyersId = buyersId;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
}
