package com.org.njproject.smiter.api.model;

import java.util.List;

public interface User {
	
	Long getId();
	void setId(Long id);
	String getName();
	void setName(String name);
	String getEmail();
	void setEmail(String email);
	String getUserName();
	void setUserName(String userName);
	String getPassword();
	void setPassword(String password);
	String getCompany();
	void setCompany(String company);
	String getUserType();
	void setUserType(String userType);
	List<String> memberOfGroups();
	void joinGroup(String groupName);
}
