package com.example.loginpage.service;

import com.example.loginpage.model.UserDtls;
import com.example.loginpage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public String createUser(UserDtls user) {
        if(userRepository.existsByEmail(user.getEmail())){
            return "Email already exists";
        }else if(userRepository.existsByEmployeeId(user.getEmployeeId())){
            return "Employee already exists";
        }else{
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRole("ROLE_USER");
            userRepository.save(user);
        }
        return null;
    }

    @Override
    public UserDtls findByEmail(String email){
        return userRepository.findByEmail(email);
    }

}
