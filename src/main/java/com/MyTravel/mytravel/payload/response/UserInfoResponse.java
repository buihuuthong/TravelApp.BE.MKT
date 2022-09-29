package com.MyTravel.mytravel.payload.response;

import java.util.List;

public class UserInfoResponse {
    private String id;
    private String username;
    private String email;
    private List<String> roles;

    private String phone;

    public UserInfoResponse(String id, String username, String email, String phone, List<String> roles) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }
}