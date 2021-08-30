package com.clothingstore.service;

import com.clothingstore.exception.ResourceNotFoundException;
import com.clothingstore.model.ShippingInfo;
import com.clothingstore.model.User;
import com.clothingstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findUserById(Long id) {
        return userRepository.findUserById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + id + " not found"));
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User with email " + email + " not found"));
        List<SimpleGrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(user.getAccountType().name()));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }

    public User registerNewUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
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
