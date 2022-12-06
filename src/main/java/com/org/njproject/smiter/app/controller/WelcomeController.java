package com.org.njproject.smiter.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.org.njproject.smiter.api.model.Login;
import com.org.njproject.smiter.api.service.LoginService;
import com.org.njproject.smiter.app.model.LoginImpl;
import com.org.njproject.smiter.app.model.UserImpl;


@Controller
@RequestMapping("/")
public class WelcomeController{
	
	@Autowired
	private LoginService loggedIn;
	boolean active;
	
	@GetMapping("/")
	public String welcome(Model model) {
		active  = loggedIn.isLoggedIn();
		
		model.addAttribute("message", "Welcome to Smiter!");
		model.addAttribute("loggedIn", active);
		model.addAttribute("login", new LoginImpl());
		return "home";
	}
	@GetMapping("welcome")
	public String index(@ModelAttribute("user") UserImpl user,Model model) {
		
		active  = loggedIn.isLoggedIn();
		
		if(active) {
			model.addAttribute("user", loggedIn.getLoggedIn());
			model.addAttribute("groups", loggedIn.getLoggedIn().memberOfGroups());
		}

		model.addAttribute("login", new LoginImpl());
		model.addAttribute("loggedIn", active);
		return "welcome";
	}
	
	@GetMapping("editgroupusers")
	public String editGroupUsers() {
		return "groupeditpage";
	}
}