package com.example.loginpage.service;

import com.example.loginpage.config.InputValidation;
import com.example.loginpage.model.UserDtls;
import com.example.loginpage.repository.UserRepository;
import jdk.internal.util.xml.impl.Input;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserServiceImplementation implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<UserDtls> getAllUsers() {
        ArrayList<UserDtls> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public String createUser(UserDtls user) {
        InputValidation inputValidation = new InputValidation();
        if(!(inputValidation.validateEmail(user.getEmail()) && inputValidation.validateName(user.getFullName()) &&
                inputValidation.validatePhoneNumber(user.getMobileNum()) && inputValidation.validateId(user.getEmployeeId()))){
            return "please try again";
        }
        if(userRepository.existsByEmail(user.getEmail())){
            return "Email already exists";
        }
        if(userRepository.existsByEmployeeId(user.getEmployeeId())){
            return "Employee already exists";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return null;
    }

    @Override
    public UserDtls findByEmail(String email){
        return userRepository.findByEmail(email);
    }
}
