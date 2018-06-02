package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Item;
import com.revature.beans.User;
import com.revature.repository.UserRepository;

@Service(value="userService")
public class UserService {

	@Autowired
	UserRepository ur;
	
	public User login(User u) {
		User user = ur.loginUserInfo(u);
		return user;
	}
	
	public int addUser(User u) {
		int pk = ur.addUser(u);
		return pk;
	}
	
	public User checkUser(User u) {
		User user = ur.checkUserInfo(u);
		return user;
	}
	
	public boolean deleteUser(User u) {
		boolean x = ur.deleteUser(u);
		return x;
	}
	
	public List<User> getAllUsersByBan() {
		List<User> x = ur.getAllBannedUsers();
		return x;
	}
}
