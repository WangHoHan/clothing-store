package com.clothingstore.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.clothingstore.model.User;
import com.clothingstore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TokenVerifier {

    private final JwtConfig jwtConfig;
    private final TokenCreator tokenCreator;
    private final UserService userService;

    public void verifyAccessToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(jwtConfig.getSecret().getBytes());
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = verifier.verify(token);
        String subject = decodedJWT.getSubject();
        List<SimpleGrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(decodedJWT.getClaim("role").toString().replaceAll("\"", "")));
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(subject, null, authorities);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
    }

    public String verifyRefreshToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(jwtConfig.getSecret().getBytes());
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = verifier.verify(token);
        String subject = decodedJWT.getSubject();
        User user = userService.findUserByEmail(subject);
        return tokenCreator.createAccessToken(subject, user.getAccountType().name());
    }
}
