package com.bean;

import java.io.Serializable;

public class ExamineApprove implements Serializable {
    private String id;
    private String developerId;
    private String file;
    private int state;
    private String adId;
    private String developerName;

    public ExamineApprove() {
    }

    public ExamineApprove(String id, String developerId, String file, int state, String adId, String developerName) {
        this.id = id;
        this.developerId = developerId;
        this.file = file;
        this.state = state;
        this.adId = adId;
        this.developerName = developerName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(String developerId) {
        this.developerId = developerId;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getAdId() {
        return adId;
    }

    public void setAdId(String adId) {
        this.adId = adId;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }
}
