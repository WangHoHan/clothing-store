package com.clothingstore.service;

import com.clothingstore.exception.ResourceNotFoundException;
import com.clothingstore.model.ShippingInfo;
import com.clothingstore.model.User;
import com.clothingstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findUserById(Long id) {
        return userRepository.findUserById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + id + " not found"));
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User addShippingInfoToUser(ShippingInfo shippingInfo, Long id) {
        User user = userRepository.findUserById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + id + " not found"));
        user.addShippingInfo(shippingInfo);
        return userRepository.save(user);
    }

    public User updateUser(User user, Long id) {
        user.setId(id);
        return userRepository.save(user);
    }

    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteUserById(id);
    }
}
