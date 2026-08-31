package com.example.authorization_server.request;

import lombok.Data;

@Data
public class AuthRequest {

    private String username;

    private String password;
}
