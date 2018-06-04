package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.revature.beans.Item;
import com.revature.beans.User;
import com.revature.service.ItemService;
import com.revature.service.UserService;

@Controller("userController")
@CrossOrigin(origins= {"http://localhost:4200"})
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	@ResponseBody
	public ResponseEntity<User> loginUserAccount(HttpSession session, User u) throws Exception {
		//u.setUsername("testname1");
		//u.setPassword("testpassword");
		System.out.println(u.toString());
		System.out.println("              ");
		User user = userService.login(u);
		if (user !=null) {
			//HttpSession session = ..getSession(false);
			session.setAttribute("userId", user.getId());
		}
		else {
			throw new Exception("Invalid username or passwords");
		}
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@RequestMapping("/logout")
	@ResponseBody
	public ResponseEntity<String> logout(HttpSession session) {
		session.invalidate();
		return new ResponseEntity<>("Successfully logged out", HttpStatus.OK);
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
	
	@RequestMapping("/all")
	@ResponseBody
	public ResponseEntity<List<User>> getAllProfiles() {
		return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
	}

}
