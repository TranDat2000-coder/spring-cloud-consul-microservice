package com.example.authorization_server.service.impl;

import org.springframework.stereotype.Component;

@Component
public class JWTService {

    private static final long EXPIRE_TIME = 60000;

    public static final String SECRET_KEY = "5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";


}
