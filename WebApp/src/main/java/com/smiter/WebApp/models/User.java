package com.smiter.WebApp.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class User {

    private List<String> groupMemberships = new ArrayList<>();
    
    Long id;
    String username;
    String name;
    String email;
    String password;
    String company;
    String usertype;
	Date dob;

    public void joinGroup(String groupName){
        groupMemberships.add(groupName);
    }
    public Object getGroupMemberships() {
        return groupMemberships;
    }
}
