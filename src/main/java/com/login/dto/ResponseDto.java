package com.login.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class ResponseDto {

    String username;
    List<String> rolUser;
    String token;

    public ResponseDto(String username, List<String> rolUser, String token) {
        this.username = username;
        this.rolUser = rolUser;
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<String> getRolUser() {
        return rolUser;
    }

    public void setRolUser(List<String> rolUser) {
        this.rolUser = rolUser;
    }
}
