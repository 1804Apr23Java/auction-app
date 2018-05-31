package main;

import beans.User;
import dao.UserDao;
import dao.UserInterface;

import java.util.List;

import org.hibernate.Session;

import util.HibernateUtil;

public class Driver {

	public static void main(String[] args) {
		
		UserInterface ui = new UserDao();
        
		User u = new User("testname5", "testpassword5", "testfirst5", "testlast5", "test5@mail.com",
			0, 0, 800.00, "teststreet5", "testcity5", "teststate5", "testzip5");
		
		ui.addUser(u);
	}
}
