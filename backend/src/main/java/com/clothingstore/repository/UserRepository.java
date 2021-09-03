package com.clothingstore.repository;

import com.clothingstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserById(Long id);

    Optional<User> findUserByEmail(String email);

    void deleteUserById(Long id);

    @Query("SELECT o.user FROM Order o WHERE o.id = :id")
    User findUserByOrderId(@Param("id") Long id);
}
