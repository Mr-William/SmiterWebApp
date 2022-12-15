package com.org.njproject.smiter.app.dao;

import java.util.List;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.org.njproject.smiter.api.dao.GroupUserDAO;
import com.org.njproject.smiter.api.model.GroupUser;

@Repository("groupUserDao")
public class GroupUserDaoImpl implements GroupUserDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
			return sessionFactory.getCurrentSession();
		}
	
	public void persist(Object entity) {
			getSession().persist(entity);
	}
	public void delete(Object entity) {
		getSession().delete(entity);
	}

	@Override
	public List<GroupUser> listGroupUsers() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery <GroupUser> cq = cb.createQuery(GroupUser.class);
		Root<GroupUser> root = cq.from(GroupUser.class);
		cq.select(root);
		Query query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void saveGroupUser(GroupUser user) {
		persist(user);
	}

	@Override
	public GroupUser findGroupUserById(Long id) {
		GroupUser user = getSession().get(GroupUser.class, id);
		return user;
	}

	@Override
	public void deleteGroupUser(Long id) {
		GroupUser user = getSession().byId(GroupUser.class).load(id);
		getSession().delete(user);
	}
	
	@Override
	public void updateGroupUser(GroupUser user) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.update(user);
		
	}

	@Override
	public GroupUser getGroupUser(Long id) {
		Session currentSession = sessionFactory.getCurrentSession();
		GroupUser user = currentSession.get(GroupUser.class, id);
		return user;
	}

	@Override
	public Boolean findUserByName(String username) {
		List<GroupUser> users = listGroupUsers();
		for(GroupUser tmp : users) {
			if(tmp.getUsername().equals(username)) {
				return true;
			}
		}
		return false;
	}

}
