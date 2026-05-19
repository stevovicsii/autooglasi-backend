package com.singidunum.autooglasi.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {


    private final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);


    private final long JWT_EXPIRATION = 1000 * 60 * 15;


    private final long REFRESH_EXPIRATION = 1000 * 60 * 60 * 24 * 7;

    public String generisiToken(String username) {
        return kreirajToken(username, JWT_EXPIRATION);
    }

    public String generisiRefreshToken(String username) {
        return kreirajToken(username, REFRESH_EXPIRATION);
    }

    private String kreirajToken(String username, long expirationTime) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(SECRET_KEY)
                .compact();
    }

    public String izvuciKorisnickoIme(String token) {
        return Jwts.parserBuilder().setSigningKey(SECRET_KEY).build().parseClaimsJws(token).getBody().getSubject();
    }

    public boolean daLiJeTokenValidan(String token, String username) {
        final String tokenUsername = izvuciKorisnickoIme(token);
        return (tokenUsername.equals(username) && !daLiJeIstekao(token));
    }

    private boolean daLiJeIstekao(String token) {
        return Jwts.parserBuilder().setSigningKey(SECRET_KEY).build().parseClaimsJws(token).getBody().getExpiration().before(new Date());
    }
}