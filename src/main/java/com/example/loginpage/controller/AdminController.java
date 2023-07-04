package com.example.loginpage.controller;

import com.example.loginpage.model.UserDtls;
import com.example.loginpage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;

    @ModelAttribute
    public void getAdminDetails(Model m, Principal p){
        String email = p.getName();
        UserDtls user = userService.findByEmail(email);
        m.addAttribute("user", user);
    }

    @GetMapping("")
    public String admin(){
        return "admin";
    }
}
