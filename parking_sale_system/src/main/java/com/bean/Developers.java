package com.bean;

public class Developers {
    private String developerId;
    private String developerName;
    private String state;
    private double money;

    public Developers() {
    }

    public Developers(String developerId, String developerName, String state, double money) {
        this.developerId = developerId;
        this.developerName = developerName;
        this.state = state;
        this.money = money;
    }

    public String getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(String developerId) {
        this.developerId = developerId;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
