package com.smiter.Provider.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smiter.Provider.api.service.UserService;
import com.smiter.Provider.app.model.User;

@CrossOrigin(origins="http://localhost:8081")
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired    
    UserService service;

    @GetMapping(value="/users")    
    public ResponseEntity<List<User>> findAllUsers(){
        return new ResponseEntity<>(service.findAllUsers(), HttpStatus.OK);
    }

    @GetMapping(value="/users/{id}")
    public ResponseEntity<?> findUserById(@PathVariable String id){
        User user = service.findUserById(Long.valueOf(id));
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping(value="/users")
    public ResponseEntity<?> saveUser(@RequestBody User user){
        User saved = service.saveUser(user);
        System.out.println("USER CREATED!!!!");
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping(value="/users/{id}")
    public ResponseEntity<?> updateUser(@RequestBody User user){
        User updated = service.updateUser(user);
        return new ResponseEntity<>(updated, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value="/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable String id){
        service.deleteUserById(Long.valueOf(id));
        return new ResponseEntity<>(service.findAllUsers(), HttpStatus.OK);
    }

}
