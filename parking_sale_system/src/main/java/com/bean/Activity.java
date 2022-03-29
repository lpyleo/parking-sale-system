package com.bean;

public class Activity {
    String activityId;
    String activityName;
    String activityDeveloperId;
    Integer activityContent;
    String activityCategory;
    Double activityDiscount;
    String activityResidentialQuartersId;

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityDeveloperId() {
        return activityDeveloperId;
    }

    public void setActivityDeveloperId(String activityDeveloperId) {
        this.activityDeveloperId = activityDeveloperId;
    }

    public String getActivityCategory() {
        return activityCategory;
    }

    public void setActivityCategory(String activityCategory) {
        this.activityCategory = activityCategory;
    }

    public Double getActivityDiscount() {
        return activityDiscount;
    }

    public void setActivityDiscount(Double activityDiscount) {
        this.activityDiscount = activityDiscount;
    }

    public Integer getActivityContent() {
        return activityContent;
    }

    public void setActivityContent(Integer activityContent) {
        this.activityContent = activityContent;
    }

    public String getActivityResidentialQuartersId() {
        return activityResidentialQuartersId;
    }

    public void setActivityResidentialQuartersId(String activityResidentialQuartersId) {
        this.activityResidentialQuartersId = activityResidentialQuartersId;
    }
}
