package com.clothingstore;

import com.clothingstore.model.AccountType;
import com.clothingstore.model.User;
import com.clothingstore.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClothingStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClothingStoreApplication.class, args);
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            User james = new User("jamessmith@example.com", "password123", "James", "Smith", "987654321", AccountType.ROLE_ADMIN);
            User john = new User("johndoe@example.com", "password123", "John", "Doe", "123456789", AccountType.ROLE_CUSTOMER);
            userService.registerNewUser(james);
            userService.registerNewUser(john);
        };
    }
}
