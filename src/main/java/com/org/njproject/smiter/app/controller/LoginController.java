package com.org.njproject.smiter.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.org.njproject.smiter.api.dao.UserDAO;
import com.org.njproject.smiter.api.model.Login;
import com.org.njproject.smiter.api.model.User;
import com.org.njproject.smiter.api.service.LoginService;
import com.org.njproject.smiter.app.model.LoginImpl;
import com.org.njproject.smiter.app.model.UserImpl;

@Controller
public class LoginController {

  @Autowired
  private LoginService loginService;
  @Autowired
  private UserDAO users;
  boolean active;
  

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public ModelAndView loginPage(@ModelAttribute("login")LoginImpl login) {
		active  = loginService.isLoggedIn();
		login = new LoginImpl();
		return new ModelAndView("login").addObject("loggedIn", active).addObject("login", login);
	}
  
  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public ModelAndView newLogin(@ModelAttribute("login")LoginImpl login ){ 
	  
	  String valid = "";
	  User user = new UserImpl();
	  ModelAndView ret = new ModelAndView();
	  if(users.findUserByUserName(login.getUserName()) == null) {
		  valid = "User does not exist!";
		  ret.addObject("error", valid);
		  ret.setViewName("login");
	  }else {
		  valid = loginService.validateUser(login);
	  }
				
	  if (valid.equals("valid")) {
		  user = users.findUserByUserName(login.getUserName());
		  loginService.setLoggedIn(user);
		  ret.addObject("groups", user.memberOfGroups()); 
		  ret.setViewName("welcome");
	    }else {
	    	ret.addObject("error", valid);
	    }

	  ret.addObject("user", user);
	  active = loginService.isLoggedIn();
	  ret.addObject("loggedIn", active);
	  return ret;
	}
  
  @RequestMapping("/logout")
  public String logout(Model model) {
	  
	  loginService.setLoggedIn(new UserImpl()); 
	  active = false;
	  model.addAttribute("loggedIn", active);
	  
	  return "home";
  }
  

}