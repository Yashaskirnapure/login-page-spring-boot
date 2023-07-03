package com.example.loginpage.service;

import com.example.loginpage.model.UserDtls;
import org.springframework.stereotype.Service;

public interface UserService {
    String createUser(UserDtls user);
    UserDtls findByEmail(String email);
}