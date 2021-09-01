package com.clothingstore.security.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.clothingstore.security.jwt.JwtConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
public class AuthorizationFilter extends OncePerRequestFilter {

    private final JwtConfig jwtConfig;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        if (httpServletRequest.getServletPath().equals("/login")
            || httpServletRequest.getServletPath().equals("/register")
            || httpServletRequest.getServletPath().startsWith("/product")
            && httpServletRequest.getMethod().equals("GET")) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        } else {
            String authorizationHeader = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);
            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                try {
                    String token = authorizationHeader.substring("Bearer ".length());
                    Algorithm algorithm = Algorithm.HMAC256(jwtConfig.getSecret().getBytes());
                    JWTVerifier verifier = JWT.require(algorithm).build();
                    DecodedJWT decodedJWT = verifier.verify(token);
                    String subject = decodedJWT.getSubject();
                    List<SimpleGrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(decodedJWT.getClaim("role").toString().replaceAll("\"", "")));
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(subject, null, authorities);
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                    filterChain.doFilter(httpServletRequest, httpServletResponse);
                } catch (Exception e) {
                    httpServletResponse.setHeader("error", e.getMessage());
                    httpServletResponse.sendError(HttpStatus.FORBIDDEN.value());
                }
            } else {
                filterChain.doFilter(httpServletRequest, httpServletResponse);
            }
        }
    }
}
