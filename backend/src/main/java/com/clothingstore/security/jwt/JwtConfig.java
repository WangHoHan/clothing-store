package com.clothingstore.security.jwt;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "jwt")
@Getter
@Setter
public class JwtConfig {

    private String secret;
    private Long accessTokenExpirationTime;
    private Long refreshTokenExpirationTime;

    public JwtConfig() {}
}
