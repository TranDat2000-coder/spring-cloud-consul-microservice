package com.example.authorization_server.config;

import com.example.authorization_server.utils.PemUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@Configuration
public class JwtConfig {

    @Bean
    public KeyPair keyPair() throws Exception {

        Resource privateKeyResource = new ClassPathResource("/keys/private.pem");
        Resource publicKeyResource = new ClassPathResource("/keys/public.pem");

        RSAPrivateKey rsaPrivateKey = PemUtils.readPrivateKey(privateKeyResource.getInputStream());
        RSAPublicKey rsaPublicKey = PemUtils.readPublicKey(publicKeyResource.getInputStream());

        return new KeyPair(rsaPublicKey, rsaPrivateKey);
    }
}
