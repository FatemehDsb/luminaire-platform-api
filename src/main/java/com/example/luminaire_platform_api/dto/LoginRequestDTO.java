package com.example.luminaire_platform_api.dto;


public class LoginRequestDTO {
    String name;
    String password;

    public LoginRequestDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
