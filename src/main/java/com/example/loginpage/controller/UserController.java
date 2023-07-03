package com.example.loginpage.controller;

import com.example.loginpage.model.UserDtls;
import com.example.loginpage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.Access;
import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ModelAttribute
    private void getUserDetails(Model m, Principal p){
        String email = p.getName();
        UserDtls user = userService.findByEmail(email);
        m.addAttribute("user", user);
    }

    @GetMapping("")
    public String home(){
        return "home";
    }
}
