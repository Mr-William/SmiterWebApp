package com.org.njproject.smiter.api.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="userGroup") 
@Table(name="usergroup")
public class GroupUser{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="NAME", nullable=false, unique=true)
	private String name;
	
	@Column(name="EMAIL", nullable=false)
	private String email;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DOB")
	private Date dob;
	
	public GroupUser() {}
	
	public GroupUser(Long id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	public Date getDob() {
		return dob;
	}
	
	public void setDob(Date date) {
		this.dob = date;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return name;
	}

	public void setUsername(String username) {
		this.name = username;
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
		return "User [id=" + id + ", username=" + name + ", email=" + email + "]";
	}
	

	
}
