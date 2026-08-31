package com.example.authorization_server.service;

import com.example.authorization_server.request.AuthRequest;
import com.example.authorization_server.response.JWTResponse;
import org.springframework.http.ResponseEntity;

public interface IAuthService {

    ResponseEntity<JWTResponse> generateToken(AuthRequest authRequest);
}
