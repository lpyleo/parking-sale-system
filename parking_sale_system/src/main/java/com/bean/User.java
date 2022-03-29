package com.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @author miao
 */
public class User implements Serializable {


    private String userIdentity;
    private String userName;
    private String userPassword;
    private String userSex;
    private int userAge;
    private Date userBirthday;
    private String userPhone;
    /**
     * 用户小区号
     */
    private String userResidentialQuarters;
    /**
     * 用户楼房号
     */
    private String userBuildingNumber;
    /**
     * 用户楼层
     */
    private int userFloor;
    /**
     * 用户房间号
     */
    private String userHouseNumber;
    /**
     * 邀请人
     */
    private String userInvitee;
    /**
     * 账户余额
     */
    private Double money;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + userIdentity +
                ", username='" + userName + '\'';
    }

    public String getUserIdentity() {
        return userIdentity;
    }

    public void setUserIdentity(String userIdentity) {
        this.userIdentity = userIdentity;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserResidentialQuarters() {
        return userResidentialQuarters;
    }

    public void setUserResidentialQuarters(String userResidentialQuarters) {
        this.userResidentialQuarters = userResidentialQuarters;
    }

    public String getUserBuildingNumber() {
        return userBuildingNumber;
    }

    public void setUserBuildingNumber(String userBuildingNumber) {
        this.userBuildingNumber = userBuildingNumber;
    }

    public int getUserFloor() {
        return userFloor;
    }

    public void setUserFloor(int userFloor) {
        this.userFloor = userFloor;
    }

    public String getUserHouseNumber() {
        return userHouseNumber;
    }

    public void setUserHouseNumber(String userHouseNumber) {
        this.userHouseNumber = userHouseNumber;
    }

    public String getUserInvitee() {
        return userInvitee;
    }

    public void setUserInvitee(String userInvitee) {
        this.userInvitee = userInvitee;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
