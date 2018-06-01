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
        
		User u = new User(4, "testname", "testpassword", "testfirst", "testlast", "test@mail.com",
			0, 0, 800.00, "teststreet", "testcity", "teststate", "testzip");
		
		//int i = ui.addUser(u);
		
		//System.out.println(i);
		User up = new User(5, "4", "4", "4", "4", "4",
				0, 0, 800.00, "4", "4", "4", "4");
		ui.updateUserInfo(up);
		//User x = ui.getUserInfo(u);
		//System.out.println(x.toString());
		//System.out.println(u.getId());
		//ui.deleteUser(u);
	}
}
