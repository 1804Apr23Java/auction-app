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
import com.revature.beans.User;
import com.revature.service.UserService;

@Controller("userController")
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/login/{username}/{password}")
	@ResponseBody
	public ResponseEntity<User> loginUserAccount(HttpSession session, User u) throws Exception {
		User user = userService.login(u);
		if (user != null) {
			session.setAttribute("userId", user.getId());
		} else {
			throw new Exception("Invalid username or password");
		}
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@RequestMapping("/logout")
	@ResponseBody
	public ResponseEntity<String> logout(HttpSession session) {
		session.invalidate();
		return new ResponseEntity<>("Successfully logged out", HttpStatus.OK);
	}

	@RequestMapping("/{username}")
	//@RequestMapping("/checkuser")
	@ResponseBody
	public ResponseEntity<User> checkUserAccount(User u) {
		u.setUsername("test"); // used for testing, remove once username param is passed
		return new ResponseEntity<>(userService.checkUser(u), HttpStatus.OK);
	}

	@RequestMapping("/adduser")
	@ResponseBody
	public ResponseEntity<Integer> createNewAccount(User u) {
		// used for testing, remove once connection is established
		// User p = new User("test", "pass", "first", "last", "mail", 0, 0, 0, "street",
		// "city", "state", "zip");
		User p = new User("test2", "pass2", "first2", "last2", "mail2", 0, 0, 0, "street2", "city2", "state2", "zip2");
		return new ResponseEntity<>(userService.addUser(p), HttpStatus.OK);
	}

	@RequestMapping("/delete")
	@ResponseBody
	public ResponseEntity<Boolean> deleteAccount(User u) {
		u.setId(105); // used for testing, remove once userId is passed
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
