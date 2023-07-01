package com.example.loginpage.repository;

import com.example.loginpage.model.UserDtls;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDtls, Integer> {
    Boolean existsByEmail(String email);
    UserDtls findByEmail(String email);
}