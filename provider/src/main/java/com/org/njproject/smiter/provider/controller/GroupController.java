package com.org.njproject.smiter.provider.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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

import com.org.njproject.smiter.provider.api.service.GroupService;
import com.org.njproject.smiter.provider.app.model.Group;

@CrossOrigin(origins="http://localhost:8081")
@RestController
@RequestMapping("/api")
public class GroupController {
    
    @Autowired
    GroupService groupService;

    @GetMapping("/groups")
    public ResponseEntity<List<Group>> findAllGroups(){
        return new ResponseEntity<>(groupService.getAllGroups(), HttpStatus.OK);
    }

    @GetMapping(value="/groups/{id}")
    public ResponseEntity<Group> findGroupById(@PathVariable String id){
        Group ret = groupService.findGroupById(Long.valueOf(id));
        return new ResponseEntity<>(ret, HttpStatus.OK);
    }

    @PostMapping(value="/groups")
    public ResponseEntity<?> saveGroup(@RequestBody Group group){
        Group savedGroup = groupService.createGroup(group);
        return new ResponseEntity<>((Group) savedGroup, HttpStatus.CREATED);
    }

    @PutMapping(value="/groups/{id}")
    public ResponseEntity<?> updateGroup(@RequestBody Group group){
        Group updated = groupService.updateGroup(group);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping(value="/groups/{id}")
    public ResponseEntity<?> deleteGroup(@PathVariable String id){
        groupService.deleteGroup(groupService.findGroupById(Long.valueOf(id)));
        return new ResponseEntity<>(groupService.getAllGroups(), HttpStatus.OK);
    }
}
