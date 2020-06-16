package com.bl.demo.model;
public class Registration {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String registrationDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegistrationdate() {
        return registrationDate;
    }

    public void setRegistrationdate(String registrationdate) {
        this.registrationDate = registrationdate;
    }
}