package com.org.njproject.smiter.app.model;

public class GroupUser{

	private long id;
	
	private String username;
	
	private String email;
	
	public GroupUser(){
		id=0;
	}
	
	public GroupUser(long id, String username, String email){
		this.id = id;
		this.username = username;
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof GroupUser))
			return false;
		GroupUser other = (GroupUser) obj;
		if (id != ((GroupUser) other).getId())
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + "]";
	}
	

	
}