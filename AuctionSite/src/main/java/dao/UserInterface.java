package dao;

import beans.User;

public interface UserInterface {

	//Check all three during login and redirect according to the returned int value
	public int validateLogin();
	
	public int validateManager();
	
	public int checkForBan();
	

	public User getUserInfo();
	

	public int addUser(User u);
}
