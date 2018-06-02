package com.revature.repository;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.revature.beans.User;
import com.revature.util.HibernateUtil;

@Repository(value="biddingHistoryRepository")
@Transactional
@EnableTransactionManagement
public class BiddingHistoryRepository {
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

	public User getUserInfo(User u) {
		User user = null;
		Session s = HibernateUtil.getSession();
		Query query = s.createQuery("FROM User where username = :username and password = :password");
		query.setString("username", "testname1");//u.getUsername());
    	query.setString("password", "testpassword");//u.getPassword());
    	user = (User) query.uniqueResult();	
    	System.out.println(" ");
    	System.out.println(user.toString());
		s.close();
		
		return user;
			
	}

	public boolean updateUserInfo(User u) {
		Session s = HibernateUtil.getSession();
		s.merge(u);
		s.close();
		return false;
	}

	public boolean deleteUser(User u) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		User user = (User) s.load(User.class, 4);
		System.out.println(user.toString());
		s.delete(user);
		tx.commit();
		s.close();
		return false;
	}
}
