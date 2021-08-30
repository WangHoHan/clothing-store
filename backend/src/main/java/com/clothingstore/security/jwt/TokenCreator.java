package com.clothingstore.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TokenCreator {

    private final Algorithm algorithm;
    private final Long accessTokenExpirationTime;
    private final Long refreshTokenExpirationTime;

    public TokenCreator(@Value("${jwt.secret}") String secret,
                        @Value("${jwt.accessTokenExpirationTime}") Long accessTokenExpirationTime,
                        @Value("${jwt.refreshTokenExpirationTime}") Long refreshTokenExpirationTime) {
        this.algorithm = Algorithm.HMAC256(secret.getBytes());
        this.accessTokenExpirationTime = accessTokenExpirationTime;
        this.refreshTokenExpirationTime = refreshTokenExpirationTime;
    }

    public String createAccessToken(String username, String issuer, String authority) {
        return JWT.create()
                .withSubject(username)
                .withExpiresAt(new Date(System.currentTimeMillis() + accessTokenExpirationTime))
                .withIssuer(issuer)
                .withClaim("role", authority)
                .sign(algorithm);
    }

    public String createRefreshToken(String username, String issuer) {
        return JWT.create()
                .withSubject(username)
                .withExpiresAt(new Date(System.currentTimeMillis() + refreshTokenExpirationTime))
                .withIssuer(issuer)
                .sign(algorithm);
    }
}
