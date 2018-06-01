package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import beans.User;
import util.HibernateUtil;

public class UserDao implements UserInterface {

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
		query.setString("username", u.getUsername());
    	query.setString("password", u.getPassword());
    	user = (User) query.uniqueResult();				
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
