package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.beans.User;
import com.revature.service.UserService;

@Controller("userController")
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//@RequestMapping(method = RequestMethod.GET)
	@RequestMapping("/userinfo")
	@ResponseBody
	public ResponseEntity<User> getUserData(User u) {
		//u.setUsername("testname1");
		//u.setPassword("testpassword");
		return new ResponseEntity<>(userService.getUserInfo(u), HttpStatus.OK);
	}

}
