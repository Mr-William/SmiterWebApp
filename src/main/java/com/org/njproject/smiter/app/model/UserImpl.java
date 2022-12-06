package com.org.njproject.smiter.app.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.org.njproject.smiter.api.model.User;

@Component
public class UserImpl implements User{
	
	Long id = (long) 0;
	String name;
	String email;
	String userName;
	String password;
	String company;
	String userType;
	List<String> groupMembership = new ArrayList<>();
	
	public UserImpl() {}
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String getUserName() {
		return userName;
	}

	@Override
	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getCompany() {
		return company;
	}

	@Override
	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String getUserType() {
		return userType;
	}

	@Override
	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public List<String> memberOfGroups() {
		return groupMembership;
	}
	
	@Override
	public void joinGroup(String groupName) {
		groupMembership.add(groupName);
	}

}
