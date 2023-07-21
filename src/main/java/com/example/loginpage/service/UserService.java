package com.example.loginpage.service;

import com.example.loginpage.model.UserDtls;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    List<UserDtls> getAllUsers();
    String createUser(UserDtls user);
    UserDtls findByEmail(String email);
}