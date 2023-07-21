package com.example.loginpage.config;

import com.example.loginpage.model.UserDtls;
import com.example.loginpage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDtls user = userRepository.findByEmail(email);
        if(user!=null) {
            return new CustomUserDetails(user);
        }
        throw new UsernameNotFoundException("User not found, please try again");
    }
}