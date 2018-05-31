package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import beans.User;
import util.HibernateUtil;

public class UserDao implements UserInterface {

	public int addUser(User u) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction(); //spooky
		int result = (Integer) s.save(u);
		tx.commit();
		s.close();
		return result;
	}

	public int validateLogin() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int validateManager() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int checkForBan() {
		// TODO Auto-generated method stub
		return 0;
	}

	public User getUserInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	public int addUser() {
		// TODO Auto-generated method stub
		return 0;
	}
}
