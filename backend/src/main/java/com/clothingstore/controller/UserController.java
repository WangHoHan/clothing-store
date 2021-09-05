package com.clothingstore.controller;

import com.clothingstore.model.ShippingInfo;
import com.clothingstore.model.User;
import com.clothingstore.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{email}")
    @PreAuthorize("authentication.principal.equals(#email) and hasAuthority('ROLE_CUSTOMER') or hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<User> getUserByEmail(@PathVariable("email") String email) {
        User user = userService.findUserByEmail(email);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/{id}/shippingInfo")
    public ResponseEntity<User> addShippingInfoToUser(@RequestBody ShippingInfo shippingInfo,
                                                      @PathVariable("id") Long id) {
        User user = userService.addShippingInfoToUser(shippingInfo, id);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping("/{email}/shippingInfo")
    @PreAuthorize("authentication.principal.equals(#email) and hasAuthority('ROLE_CUSTOMER') or hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<User> addShippingInfoToUserByEmail(@RequestBody ShippingInfo shippingInfo,
                                                             @PathVariable("email") String email) {
        User user = userService.addShippingInfoToUserByEmail(shippingInfo, email);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user,
                                           @PathVariable("id") Long id) {
        User updatedUser = userService.updateUser(user, id);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
