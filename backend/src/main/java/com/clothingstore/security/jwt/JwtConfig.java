package com.clothingstore.security.jwt;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "jwt")
@Data
public class JwtConfig {

    private String secret;
    private Long accessTokenExpirationTime;
    private Long refreshTokenExpirationTime;
}
