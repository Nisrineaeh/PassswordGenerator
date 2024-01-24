package com.lockgenius.passwordGenerator.Utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Base64;
import java.util.Date;

@Component
public class JWT {
    private final Key secretKey;

    public JWT(@Value("${jwt.secretKey}") String encodedSecretKey) {
        byte[] decodedKey = Base64.getDecoder().decode(encodedSecretKey);
        this.secretKey = Keys.hmacShaKeyFor(decodedKey);
    }

    public String generateToken(String username) {
        long now = System.currentTimeMillis();
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(now + 3600000)) // Exp 1h
                .signWith(secretKey, SignatureAlgorithm.HS512)
                .compact();
    }
}