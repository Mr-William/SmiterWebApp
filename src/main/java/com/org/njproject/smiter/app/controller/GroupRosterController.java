package com.org.njproject.smiter.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.org.njproject.smiter.api.service.GroupService;
import com.org.njproject.smiter.api.service.GroupUserService;
import com.org.njproject.smiter.app.model.GroupUser;

@RestController
public class GroupRosterController {
 
    @Autowired
    GroupUserService userService;
    @Autowired
    GroupService groupService;
    
    HttpHeaders responseHeaders = new HttpHeaders();
    
    private void setHeaders() {
    	responseHeaders.add("loggedIn", "true");
    }
    
    @RequestMapping(value = "/editusers", method = RequestMethod.GET)
    public ResponseEntity<List<GroupUser>> listAllUsers() {
    	
    	setHeaders();
        List<GroupUser> users = userService.findAllUsers();
        if(users.isEmpty()){
            return new ResponseEntity<List<GroupUser>>(responseHeaders, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<GroupUser>>(users, responseHeaders, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/editusers/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GroupUser> getUser(@PathVariable("id") long id) {
    	
    	setHeaders();
        GroupUser user = userService.findById(id);
        if (user == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<GroupUser>(responseHeaders, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<GroupUser>(user, responseHeaders, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/editusers/", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody GroupUser user,    UriComponentsBuilder ucBuilder) {

    	setHeaders();
        if (userService.isUserExist(user)) {
            System.out.println("A User with name " + user.getUsername() + " already exists");
            return new ResponseEntity<Void>(responseHeaders, HttpStatus.CONFLICT);
        }
 
        userService.saveUser(user);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
        headers.add("loggedIn", "true");
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
     
    @RequestMapping(value = "/editusers/{id}", method = RequestMethod.PUT)
    public ResponseEntity<GroupUser> updateUser(@PathVariable("id") long id, @RequestBody GroupUser user) {
         
    	setHeaders();
        GroupUser currentUser = userService.findById(id);
         
        if (currentUser==null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<GroupUser>(responseHeaders, HttpStatus.NOT_FOUND);
        }
 
        currentUser.setUsername(user.getUsername());
        currentUser.setEmail(user.getEmail());
         
        userService.updateUser(currentUser);
        return new ResponseEntity<GroupUser>(currentUser, responseHeaders, HttpStatus.OK);
    }
     
    @DeleteMapping(value = "/editusers/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable String id) {
 
        GroupUser user = userService.findById(Long.valueOf(id));
        if (user == null) {
            System.out.println(" User with id " + id + " not found");
            return new ResponseEntity<>(responseHeaders, HttpStatus.NOT_FOUND);
        }
 
        userService.deleteUserById(Long.valueOf(id));
        return new ResponseEntity<>(responseHeaders, HttpStatus.OK);
    }
 
}