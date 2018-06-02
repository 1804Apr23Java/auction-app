package com.revature.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
//import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
//import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Item;
import com.revature.beans.User;
import com.revature.util.HibernateUtil;

@Repository(value="userRepository")
@Transactional
@EnableTransactionManagement
public class UserRepository {

	@Autowired
	SessionFactory sessionFactory;
	
	public int addUser(User u) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		//result returns pk of new user. 
		int result = (Integer) s.save(u);
		tx.commit();
		s.close();
		return result;
	}

	public User loginUserInfo(User u) {
		User user = null;
		Session s = HibernateUtil.getSession();
		Query query = s.createQuery("FROM User where username = :username and password = :password");
		query.setString("username", u.getUsername());
    	query.setString("password", u.getPassword());
    	user = (User) query.uniqueResult();
		s.close();
		return user;
			
	}
	
	public User checkUserInfo(User u) {
		User user = null;
		Session s = HibernateUtil.getSession();
		Query query = s.createQuery("FROM User where username = :username");
		query.setString("username", u.getUsername());
    	user = (User) query.uniqueResult();
		s.close();
		return user;
			
	}
	
	public List<User> getAllBannedUsers() {
		Session s = HibernateUtil.getSession();
		Criteria cr = s.createCriteria(User.class);
		cr.add(Restrictions.eq("bannedCheck", 1)).list();
		List<User> results = cr.list();
		return results;
	}
	

	public boolean updateUserInfo(User u) {
		Session s = HibernateUtil.getSession();
		Transaction tx = null;
		try {
				tx = s.beginTransaction();
				s.merge(u);
				tx.commit();
				return true;
	      } catch (Exception e) { 
	           if (tx != null) {
	             tx.rollback();
	           }
	      }  finally { 
	           s.close();
	      }
		return false;
	}

	public boolean deleteUser(User u) {
		Session s = HibernateUtil.getSession();
		Transaction tx = null;
		try {
				tx = s.beginTransaction();
				s.delete(u);
				tx.commit();
				return true;
	      } catch (Exception e) { 
	           if (tx != null) {
	             tx.rollback();
	           }
	      }  finally { 
	           s.close();
	      }
		return false;
	}

}
