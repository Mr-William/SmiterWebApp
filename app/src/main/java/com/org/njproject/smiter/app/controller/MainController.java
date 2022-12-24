package com.org.njproject.smiter.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.org.njproject.smiter.app.models.Login;
import com.org.njproject.smiter.app.models.User;

@RestController
public class MainController {
    
    @GetMapping("/")
    public ModelAndView getIndexPage(){
        return new ModelAndView("index", "user", new User());
    }

    @GetMapping("/login")
    public ModelAndView getLoginPage(){
        return new ModelAndView("login", "login", new Login());
    }

    @GetMapping("/register")
    public ModelAndView getRegistrationPage(){
        return new ModelAndView("registration", "user", new User());
    }
}
