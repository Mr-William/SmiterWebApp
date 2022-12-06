package com.org.njproject.smiter.app.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.org.njproject.smiter.api.service.GroupUserService;
import com.org.njproject.smiter.app.model.GroupUser;

@Service
public class GroupUserServiceImpl implements GroupUserService{
	
	private static final AtomicLong id = new AtomicLong();
	
	private static List<GroupUser> users;
	
	static{
		users = new ArrayList<>();
	}

	public List<GroupUser> findAllUsers() {
		return users;
	}
	
	public GroupUser findById(long id) {
		for(GroupUser user : users){
			if(user.getId() == id){
				return user;
			}
		}
		return null;
	}
	
	public GroupUser findByName(String name) {
		for(GroupUser user : users){
			if(user.getUsername().equalsIgnoreCase(name)){
				return user;
			}
		}
		return null;
	}
	
	public void saveUser(GroupUser user) { 
		user.setId(id.incrementAndGet());
		users.add(user);
	}

	public void updateUser(GroupUser user) {
		int index = users.indexOf(user);
		users.set(index, user);
	}

	public void deleteUserById(long id) {
		
		for (Iterator<GroupUser> iterator = users.iterator(); iterator.hasNext(); ) {
			GroupUser user = iterator.next();
		    if (user.getId() == id) {
		        iterator.remove();
		    }
		}
	}

	public boolean isUserExist(GroupUser user) {
		return findByName(user.getUsername())!=null;
	}
	
	public void deleteAllUsers(){
		users.clear();
	}

}
