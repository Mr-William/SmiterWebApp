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

import com.smiter.Provider.api.service.GroupUserService;
import com.smiter.Provider.app.model.GroupUser;

@CrossOrigin(origins="http://localhost:8081")
@RestController
@RequestMapping("/api")
public class GroupRosterController {
    
    @Autowired
    GroupUserService service;

    @GetMapping("/groupusers")
    public ResponseEntity<List<GroupUser>> findAllGroups(){
        return new ResponseEntity<>(service.listGroupUsers(), HttpStatus.OK);
    }

    @GetMapping(value="/groupusers/{id}")
    public ResponseEntity<GroupUser> findGroupUserById(@PathVariable String id){
        GroupUser ret = service.findGroupUserById(Long.valueOf(id));
        return new ResponseEntity<>(ret, HttpStatus.OK);
    }

    @PostMapping(value="/groupusers")
    public ResponseEntity<?> saveGroupUser(@RequestBody GroupUser user){
        GroupUser saved = service.saveGroupUser(user);
        return new ResponseEntity<>((GroupUser) saved, HttpStatus.CREATED);
    }

    @PutMapping(value="/groupusers/{id}")
    public ResponseEntity<?> updateGroupUser(@RequestBody GroupUser user){
        GroupUser updated = service.updateGroupUser(user);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping(value="/groupusers/{id}")
    public ResponseEntity<?> deleteGroupUser(@PathVariable String id){
        service.deleteGroupUser(Long.valueOf(id));
        return new ResponseEntity<>(service.listGroupUsers(), HttpStatus.OK);
    }
}
