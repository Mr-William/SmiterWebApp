package com.smiter.WebApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.smiter.WebApp.models.Login;
import com.smiter.WebApp.models.User;

@Controller
public class MainController {

    @GetMapping("/")
    public ModelAndView getIndexPage(){
        return new ModelAndView("index");
    }

    @GetMapping("/login")
    public ModelAndView getLoginPage(){
        return new ModelAndView("login", "login", new Login());
    }

    @GetMapping("/registration")
    public ModelAndView getRegistrationPage(){
        return new ModelAndView("registration", "user", new User());
    }
}