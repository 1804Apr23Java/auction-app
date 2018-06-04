package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
//import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
//import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.User;

@Repository(value = "userRepository")
@Transactional
@EnableTransactionManagement
public class UserRepository {

	@Autowired
	SessionFactory sessionFactory;

	// result returns pk of new user.
	public int addUser(User u) {
		Session s = sessionFactory.getCurrentSession();
		int result = (Integer) s.save(u);
		return result;
	}

	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		Session s = sessionFactory.getCurrentSession();
		users = s.createQuery("from User").list();
		return users;
	}

	public User loginUserInfo(User u) {
		User user = null;
		Session s = sessionFactory.getCurrentSession();
		Query query = s.createQuery("FROM User where username = :username and password = :password");
		query.setString("username", u.getUsername());
		query.setString("password", u.getPassword());
		user = (User) query.uniqueResult();
		return user;

	}

	public User checkUserInfo(User u) {
		User user = null;
		Session s = sessionFactory.getCurrentSession();
		Query query = s.createQuery("FROM User where username = :username");
		query.setString("username", u.getUsername());
		user = (User) query.uniqueResult();
		return user;

	}

	public List<User> getAllBannedUsers() {
		Session s = sessionFactory.getCurrentSession();
		Criteria cr = s.createCriteria(User.class);
		cr.add(Restrictions.eq("bannedCheck", 1)).list();
		List<User> results = cr.list();
		return results;
	}

	public boolean updateUserInfo(User u) {
		Session s = sessionFactory.getCurrentSession();
		try {
			s.merge(u);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean deleteUser(User u) {
		Session s = sessionFactory.getCurrentSession();
		try {
			s.delete(u);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
