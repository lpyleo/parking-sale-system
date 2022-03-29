package com.bean;
import java.io.Serializable;
public class Administrators implements Serializable{
    private String administratorsId;
    private String administratorsName;
    private String administratorsSex;
    private String administratorsAge;
    private String administratorsPhone;
    private String administratorsPassword;
    private double money;

    public Administrators() {
    }

    public Administrators(String administratorsId, String administratorsName, String administratorsSex, String administratorsAge, String administratorsPhone, String administratorsPassword, double money) {
        this.administratorsId = administratorsId;
        this.administratorsName = administratorsName;
        this.administratorsSex = administratorsSex;
        this.administratorsAge = administratorsAge;
        this.administratorsPhone = administratorsPhone;
        this.administratorsPassword = administratorsPassword;
        this.money = money;
    }

    public String getAdministratorsId() {
        return administratorsId;
    }

    public void setAdministratorsId(String administratorsId) {
        this.administratorsId = administratorsId;
    }

    public String getAdministratorsName() {
        return administratorsName;
    }

    public void setAdministratorsName(String administratorsName) {
        this.administratorsName = administratorsName;
    }

    public String getAdministratorsSex() {
        return administratorsSex;
    }

    public void setAdministratorsSex(String administratorsSex) {
        this.administratorsSex = administratorsSex;
    }

    public String getAdministratorsAge() {
        return administratorsAge;
    }

    public void setAdministratorsAge(String administratorsAge) {
        this.administratorsAge = administratorsAge;
    }

    public String getAdministratorsPhone() {
        return administratorsPhone;
    }

    public void setAdministratorsPhone(String administratorsPhone) {
        this.administratorsPhone = administratorsPhone;
    }

    public String getAdministratorsPassword() {
        return administratorsPassword;
    }

    public void setAdministratorsPassword(String administratorsPassword) {
        this.administratorsPassword = administratorsPassword;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
