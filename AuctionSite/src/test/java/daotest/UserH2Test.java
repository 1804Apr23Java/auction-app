package daotest;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.junit.Test;

import beans.User;
import dao.UserDao;
import dao.UserInterface;



@Transactional
public class UserH2Test {
	
	/*
	 //Use for any functionality regarding user
	public User getUserInfo(User u);
	
	//user can create a new account
	public int addUser(User u);

	//Use for any updates regarding user: banning, increase/decrease balance, change userinfo/password etc..
	public boolean updateUserInfo(User u);
	
	//Use for supers, but maybe want to archive?
	public boolean deleteUser(User u);
	
	 */

	private UserInterface ui = new UserDao();
	User user = new User(4, "testname", "testpassword", "testfirst", "testlast", "test@mail.com",
			0, 0, 800.00, "teststreet", "testcity", "teststate", "testzip");
	

	@Test
	public void testAddUser() {
		int i = ui.addUser(user);
		assertEquals(i, 1);
	}
	
	@Test
	public void testGetUserInfo() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testUpdateUserInfo() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testDeleteUser() {
		fail("Not yet implemented");
	}

}
