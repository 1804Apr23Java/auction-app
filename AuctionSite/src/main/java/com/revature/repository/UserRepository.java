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

	//New user can create an account, result returns pk of new user.
	public int addUser(User u) {
		Session s = sessionFactory.getCurrentSession();
		int result = (Integer) s.save(u);
		return result;
	}

	//For Superusers, get all users
	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		Session s = sessionFactory.getCurrentSession();
		users = s.createQuery("from User").list();
		return users;
	}

	//Used to login and get own user information
	public User loginUserInfo(User u) {
		User user = null;
		Session s = sessionFactory.getCurrentSession();
		Query query = s.createQuery("FROM User where username = :username and password = :password");
		query.setString("username", u.getUsername());
		query.setString("password", u.getPassword());
		user = (User) query.uniqueResult();
		return user;

	}
	
	//Used to get user information via primary key
	public User userInfoViaKey(User u) {
		System.out.println(u.getId());
		Session s = sessionFactory.getCurrentSession();
		Query query = s.createQuery("FROM User where id = :id");
		query.setInteger("id", u.getId());
		User user = (User) query.uniqueResult();
		return user;

	}

	//Used to check a user's info that's not their own
	public User checkUserInfo(User u) {
		User user = null;
		Session s = sessionFactory.getCurrentSession();
		Query query = s.createQuery("FROM User where username = :username");
		query.setString("username", u.getUsername());
		user = (User) query.uniqueResult();
		return user;

	}

	//For Superusers, get all banned accounds
	public List<User> getAllBannedUsers() {
		Session s = sessionFactory.getCurrentSession();
		Criteria cr = s.createCriteria(User.class);
		cr.add(Restrictions.eq("bannedCheck", 1)).list();
		List<User> results = cr.list();
		return results;
	}

	//For users to update their own user information
	public boolean updateUserInfo(User u) {
		Session s = sessionFactory.getCurrentSession();
		try {
			s.merge(u);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	//For Superusers (and possibly users), can delete (maybe one's own)accounts
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
