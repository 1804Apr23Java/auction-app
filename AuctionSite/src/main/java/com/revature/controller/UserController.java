package com.revature.controller;

import java.util.List;

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
	@RequestMapping("/login")
	@ResponseBody
	public ResponseEntity<User> loginUserAccount(User u) {
		u.setUsername("testname1");
		u.setPassword("testpassword");
		return new ResponseEntity<>(userService.login(u), HttpStatus.OK);
	}
	
	@RequestMapping("/checkuser")
	@ResponseBody
	public ResponseEntity<User> checkUserAccount(User u) {
		u.setUsername("test");
		return new ResponseEntity<>(userService.checkUser(u), HttpStatus.OK);
	}
	
	@RequestMapping("/adduser")
	@ResponseBody
	public ResponseEntity<Integer> createNewAccount(User u) {
		u = new User("controller", "test", "testfirst", "testlast", "test@mail.com",
				0, 0, 800.00, "teststreet", "testcity", "teststate", "testzip");
		return new ResponseEntity<>(userService.addUser(u), HttpStatus.OK);
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public ResponseEntity<Boolean> deleteAccount(User u) {
		u.setId(21);
		return new ResponseEntity<>(userService.deleteUser(u), HttpStatus.OK);
	}
	
	@RequestMapping("/banned")
	@ResponseBody
	public ResponseEntity<List<User>> notBannedAccount() {
		return new ResponseEntity<>(userService.getAllUsersByBan(), HttpStatus.OK);
	}

}
