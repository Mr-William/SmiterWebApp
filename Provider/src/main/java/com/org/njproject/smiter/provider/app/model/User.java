package com.org.njproject.smiter.provider.app.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Component
@Entity(name="USERTABLE")
@Table(name="USERTABLE")
@Getter @Setter
public class User {

    private List<String> groupMemberships = new ArrayList<>();
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    Long id;

    @Column(name="user_name")
    String userName;

    @Column(name="name")
    String name;

    @Column(name="email")
    String email;

    @Column(name="password")
    String password;

    @Column(name="company")
    String company;

    @Column(name="user_type")
    String userType;

    public void joinGroup(String groupName){
        groupMemberships.add(groupName);
    }
    public Object getGroupMemberships() {
        return groupMemberships;
    }
}
