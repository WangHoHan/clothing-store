package com.clothingstore.security.filter;

import com.clothingstore.security.jwt.TokenVerifier;
import lombok.RequiredArgsConstructor;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
public class AuthorizationFilter extends OncePerRequestFilter {

    private final TokenVerifier tokenVerifier;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (request.getServletPath().equals("/login")
            || request.getServletPath().equals("/register")
            || request.getServletPath().equals("/refresh")
            || request.getServletPath().startsWith("/product")
            && request.getMethod().equals("GET")) {
            filterChain.doFilter(request, response);
        } else {
            String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                try {
                    String accessToken = authorizationHeader.substring("Bearer ".length());
                    tokenVerifier.verifyAccessToken(accessToken);
                    filterChain.doFilter(request, response);
                } catch (Exception e) {
                    response.setHeader("error", e.getMessage());
                    response.sendError(HttpStatus.FORBIDDEN.value());
                }
            } else filterChain.doFilter(request, response);
        }
    }
}
