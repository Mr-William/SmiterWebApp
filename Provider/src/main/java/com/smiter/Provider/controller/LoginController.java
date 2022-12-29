package com.smiter.Provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.smiter.Provider.api.dao.UserDAO;
import com.smiter.Provider.api.service.LoginService;
import com.smiter.Provider.app.model.Login;
import com.smiter.Provider.app.model.User;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class LoginController {
       
    @Autowired
    private LoginService loginService;
    @Autowired
    private UserDAO users;
    boolean active;
  

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public ResponseEntity<ModelAndView> loginPage(@ModelAttribute("login")Login login) {
		active  = loginService.isLoggedIn();
		login = new Login();
		ModelAndView ret = new ModelAndView("login").addObject("loggedIn", active).addObject("login", login);
        return new ResponseEntity<>(ret, HttpStatus.OK);
	}
  
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<ModelAndView> newLogin(@ModelAttribute("login")Login login ){ 
	  
	  String valid = "";
	  User user = new User();
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
		  ret.addObject("groups", user.getGroupMemberships()); 
		  ret.setViewName("welcome");
	    }else {
	    	ret.addObject("error", valid);
	    }

	  ret.addObject("user", user);
	  active = loginService.isLoggedIn();
	  ret.addObject("loggedIn", active);
	  return new ResponseEntity<>(ret, HttpStatus.ACCEPTED);
	}
  
    @RequestMapping("/logout")
    public String logout(Model model) {
	  
	  loginService.setLoggedIn(new User()); 
	  active = false;
	  model.addAttribute("loggedIn", active);
	  
	  return "home";
    }
}
