package com.clothingstore.controller;

import com.clothingstore.model.User;
import com.clothingstore.security.jwt.TokenVerifier;
import com.clothingstore.service.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AccountController {

    private final UserService userService;
    private final TokenVerifier tokenVerifier;

    public AccountController(UserService userService, TokenVerifier tokenVerifier) {
        this.userService = userService;
        this.tokenVerifier = tokenVerifier;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerNewUser(@RequestBody User user) {
        User newUser = userService.registerNewUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping("/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            try {
                String refreshToken = authorizationHeader.substring("Bearer ".length());
                String newAccessToken = tokenVerifier.verifyRefreshToken(refreshToken);
                response.setHeader("access_token", newAccessToken);
                response.setHeader("refresh_token", refreshToken);
            } catch (Exception e) {
                response.setHeader("error", e.getMessage());
                response.sendError(HttpStatus.FORBIDDEN.value());
            }
        } else throw new RuntimeException("Refresh token is missing");
    }
}
