package com.clothingstore.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TokenCreator {

    private final JwtConfig jwtConfig;
    private final Algorithm algorithm;

    public TokenCreator(JwtConfig jwtConfig) {
        this.jwtConfig = jwtConfig;
        this.algorithm = Algorithm.HMAC256(jwtConfig.getSecret().getBytes());
    }

    public String createAccessToken(String username, String authority) {
        return JWT.create()
                .withSubject(username)
                .withExpiresAt(new Date(System.currentTimeMillis() + jwtConfig.getAccessTokenExpirationTime()))
                .withClaim("role", authority)
                .sign(algorithm);
    }

    public String createRefreshToken(String username) {
        return JWT.create()
                .withSubject(username)
                .withExpiresAt(new Date(System.currentTimeMillis() + jwtConfig.getRefreshTokenExpirationTime()))
                .sign(algorithm);
    }
}
