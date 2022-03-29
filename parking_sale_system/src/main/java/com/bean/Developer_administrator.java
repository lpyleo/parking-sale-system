package com.bean;

public class Developer_administrator {
    private String id;
    private String developerId;
    private String role;
    private String password;

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Developer_administrator{" +
                "id=" + id +
                ", developerId='" +  developerId+ '\'' +
                ",role"+role+
                ", password='" + password + '\'' +
                '}';
    }
}
