package com.example.authorization_server.response;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Data
public class JWTResponse {

    private String accessToken;
    private String refreshToken;
    private String type = "Bearer";
    private String username;
    private String fullName;
    private String email;
    private Collection<? extends GrantedAuthority> roles;

    public JWTResponse(String accessToken, String refreshToken, String username, String fullName, String email,
                       Collection<? extends GrantedAuthority> roles) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.username = username;
        this.fullName = fullName;
        this.email = email;
        this.roles = roles;
    }

    public JWTResponse(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}
