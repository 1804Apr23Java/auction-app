package main;

import beans.User;
import dao.UserDao;
import dao.UserInterface;
/*
import java.util.List;

import org.hibernate.Session;

import util.HibernateUtil;
*/
public class Driver {

	public static void main(String[] args) {
		
		UserInterface ui = new UserDao();
        
		User u = new User(11, "testname6", "testpassword6", "testfirst6", "testlast6", "test6@mail.com",
			0, 0, 800.00, "teststreet6", "testcity6", "teststate6", "testzip6");
		
		int i = ui.addUser(u);
		
		System.out.println(i);
		
		Boolean x = ui.validateLogin(u);
		System.out.println(x);
	}
}
