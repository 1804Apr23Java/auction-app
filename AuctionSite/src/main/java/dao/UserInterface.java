package dao;

import beans.User;

public interface UserInterface {

	//Check all three during login and redirect according to the returned int value
	public boolean validateLogin(User u);
	
	public boolean validateManager();
	
	public boolean checkForBan();
	

	//Used to check own info or other user's info
	public User getUserInfo();
	
	//user can create a new account
	public int addUser(User u);
}
