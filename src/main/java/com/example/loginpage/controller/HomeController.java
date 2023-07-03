package com.example.loginpage.controller;

import com.example.loginpage.model.UserDtls;
import com.example.loginpage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String index() {
		return "login";
	}

	@GetMapping("/signin")
	public String login() {
		return "login";
	}

	@GetMapping("/register")
	public String register() {
		return "register";
	}

	@PostMapping("/createuser")
	public String createUser(@ModelAttribute UserDtls user, HttpSession session){
		String msg = userService.createUser(user);
		if(msg != null) {
			session.setAttribute("msg", msg);
		}else {
			session.setAttribute("msg", "Registration successful");
		}
		return "redirect:/register";
	}
}
