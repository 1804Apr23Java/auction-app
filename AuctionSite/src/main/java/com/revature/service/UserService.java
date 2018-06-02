package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.User;
import com.revature.dao.UserRepository;

@Service(value="userService")
public class UserService {

	@Autowired
	UserRepository ur;
	
	public User getUserInfo(User u) {
		User user = ur.getUserInfo(u);
		return user;
	}
}
