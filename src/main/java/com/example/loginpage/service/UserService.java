package com.example.loginpage.service;

import com.example.loginpage.model.UserDtls;
import org.springframework.stereotype.Service;

public interface UserService {
    UserDtls createUser(UserDtls user);
    Boolean existsByEmail(String email);
    UserDtls findByEmail(String email);
}