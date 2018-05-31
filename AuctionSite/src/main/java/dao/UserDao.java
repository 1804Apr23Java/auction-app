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

	public boolean validateLogin(User u) {
		Session s = HibernateUtil.getSession();
		//Transaction tx = s.beginTransaction();
		Query query = s.createQuery("FROM User where username = :username and password = :password");
		query.setString("username", u.getUsername());
    	query.setString("password", u.getPassword());
    	User user = (User) query.uniqueResult();
							
		s.close();
		
		if (user != null) {
			System.out.println(user.getId());
			System.out.println(user.toString());
			return true;
		}
		else 
			return false;
			
	}

	public boolean validateManager() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean checkForBan() {
		// TODO Auto-generated method stub
		return false;
	}

	public User getUserInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
