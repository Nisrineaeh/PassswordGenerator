package com.lockgenius.passwordGenerator.Utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class JWT {
    private String secretKey = "secret";

    public String generateToken(String username) {
        long now = System.currentTimeMillis();
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(now + 3600000)) // Expiration en 1 heure
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

}
