package com.clothingstore.controller;

import com.clothingstore.model.User;
import com.clothingstore.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AccountController {

    private final UserService userService;

    public AccountController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerNewUser(@RequestBody User user) {
        User newUser = userService.registerNewUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
}
