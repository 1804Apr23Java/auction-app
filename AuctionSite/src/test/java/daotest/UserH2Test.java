package daotest;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.Test;

import com.revature.beans.User;
import com.revature.repository.UserRepository;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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

	private UserRepository ui = new UserRepository();
	User user = new User("testname", "testpassword", "testfirst", "testlast", "test@mail.com",
			0, 0, 800.00, "teststreet", "testcity", "teststate", "testzip");

	@Test
	public void testAddUserPK() {
		int i = ui.addUser(user);
		assertEquals(i, 1);
	}

	@Test
	public void testGetUserInfo() {
		User u = ui.loginUserInfo(user);
		user.setId(1);
		assertEquals(user.toString(), u.toString());
	}
	
	@Test
	public void testUpdateUserInfo() {
		user.setBalance(1600);
		ui.updateUserInfo(user);
		User u = ui.loginUserInfo(user);
		assertTrue(u.getBalance() == 1600);
	}

	@Test
	public void testDeleteUser() {
		assertTrue(ui.deleteUser(user));
	}

}
