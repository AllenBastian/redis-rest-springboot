package com.todo.demo.http.request;


import jakarta.validation.constraints.Size;

public class LoginRequest {

    @Size(max = 10,message = "Exceeded size")
    private String username;

    private String password;


    public LoginRequest(String username, String password){
        this.username = username;
        this.password = password;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
