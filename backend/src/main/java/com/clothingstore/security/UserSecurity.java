package com.clothingstore.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

@Component
public class UserSecurity {

    public Boolean isCurrentUser(Authentication authentication, String email) {
        User user = (User) authentication.getPrincipal();
        return user.getUsername().equals(email);
    }
}
