package com.org.njproject.smiter.provider.app.daoimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.njproject.smiter.provider.api.dao.UserDAO;
import com.org.njproject.smiter.provider.app.model.Login;
import com.org.njproject.smiter.provider.app.model.User;
import com.org.njproject.smiter.provider.app.repo.UserRepo;

import jakarta.transaction.Transactional;

@Repository
public class UserDAOImpl implements UserDAO{

    @Autowired
    private UserRepo repo;
	
	private void initDao() {
		User admin = new User();
		admin.setCompany("Home");
		admin.setEmail("w.g@g.com");
		admin.setId((long) 0);
		admin.setName("William");
		admin.setPassword("asdf");
		admin.setUserName("will");
		admin.setUserType("Owner");
        repo.save(admin);
	}
    
    @Transactional
    public List<User> findAllUsers() {
        return repo.findAll();
    }

    @Transactional
    public User createUser(User user) {
        repo.save(user);
        return user;
    }
    
    @Transactional
    public User findUserByName(String name) {
        return repo.findByUserName(name);
    }

    @Transactional
    public User findUserById(Long userId) {
        Optional<User> user = repo.findById(userId);
        return user.get();
    }
    
    @Transactional
    public void removeUser(Long userId) {
        repo.deleteById(userId);
    }

    public String validLogin(Login login) {
        if(repo == null){
            initDao();
        }
        if(repo.findByUserName(login.getName()) != null){
            User user = findUserByUserName(login.getUserName());
            if(login.getPassword().equals(user.getPassword())){
                login.setName(login.getName());
                login.setLoggedIn(user);
                return "valid";
            }else{
                return "Incorrect Password";
            }
        }else{
            return "User does not exist!";
        }
    }

    @Transactional
    public User findUserByUserName(String userName) {
        return repo.findByUserName(userName);
    }

    @Transactional
    public void populateUsers() {
        initDao();
    }

    @Transactional
    public User updateUser(User user){
        User tmp = findUserById(user.getId());
        tmp.setId(user.getId());
        tmp.setName(user.getName());
        tmp.setUserName(user.getUserName());
        tmp.setCompany(user.getCompany());
        tmp.setEmail(user.getEmail());
        tmp.setUserType(user.getUserType());
        tmp.setPassword(user.getPassword());

        return user;
    }

    public void deleteUserById(Long id) {
        repo.deleteById(id);
    }    
}
