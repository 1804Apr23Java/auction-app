package dao;

import beans.User;

public interface UserInterface {

	//Use for any functionality regarding user
	public User getUserInfo(User u);
	
	//user can create a new account
	public int addUser(User u);

	//Use for any updates regarding user: banning, increase/decrease balance, change userinfo/password etc..
	public boolean updateUserInfo(User u);
	
	//Use for supers, but maybe want to archive?
	public boolean deleteUser(User u);
	
	
}
