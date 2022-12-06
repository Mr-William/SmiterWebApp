package com.org.njproject.smiter.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.org.njproject.smiter.api.dao.UserDAO;
import com.org.njproject.smiter.api.model.User;
import com.org.njproject.smiter.api.service.LoginService;
import com.org.njproject.smiter.app.model.UserImpl;

@Controller
public class UserController {
	
	@Autowired
	private UserDAO userDao;
	@Autowired
	private LoginService loginService;
	
	boolean active;
	
	@GetMapping("registration")
	public String getRegistration(@ModelAttribute("user")UserImpl u,Model model) {
		active  = loginService.isLoggedIn();
		User user = new UserImpl();
		model.addAttribute("user", user);
		model.addAttribute("loggedIn", active);
		return "registration";
	}
	
	@PostMapping("registration")
	public String addRegistration(@ModelAttribute("registration")UserImpl registration, Model model) {	
		
		userDao.createUser(registration);
		
		if(userDao.findAllUsers().contains(registration)) {
			loginService.setLoggedIn(registration);
			active  = loginService.isLoggedIn();
			model.addAttribute("message", registration.getName() + " successfully registered!");
			model.addAttribute("user", registration);
			model.addAttribute("loggedIn", active);
			return "welcome";
		}
		else {
			model.addAttribute("error", "User not registered!");
			return "registration";			
		}		
	}	
}
