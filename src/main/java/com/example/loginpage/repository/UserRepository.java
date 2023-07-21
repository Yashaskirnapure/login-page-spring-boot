package com.example.loginpage.repository;

import com.example.loginpage.model.UserDtls;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserDtls, Integer> {
    Boolean existsByEmail(String email);
    UserDtls findByEmail(String email);
    Boolean existsByEmployeeId(String empId);
}