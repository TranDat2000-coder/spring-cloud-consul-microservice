package com.example.authorization_server.service.impl;

import com.example.authorization_server.request.AuthRequest;
import com.example.authorization_server.response.JWTResponse;
import com.example.authorization_server.service.IAuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements IAuthService {

    @Override
    public ResponseEntity<JWTResponse> generateToken(AuthRequest authRequest) {
        return null;
    }
}
