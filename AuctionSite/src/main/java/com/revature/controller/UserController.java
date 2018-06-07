package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.revature.beans.User;
import com.revature.service.UserService;

@Controller("userController")
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
			session.setAttribute("admin", user.getAdminValue());
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

	@RequestMapping("/checkuser/{username}")
	@ResponseBody
	public ResponseEntity<User> checkUserAccount(User u) {
		return new ResponseEntity<>(userService.checkUser(u), HttpStatus.OK);
	}

	@RequestMapping("/adduser/{username}/{password}/{firstName}/{lastName}/{email}/{street}/{city}/{state}/{zipcode}")
	@ResponseBody
	public ResponseEntity<Integer> createNewAccount(User u) {
		return new ResponseEntity<>(userService.addUser(u), HttpStatus.OK);
	}

	@RequestMapping("/delete")
	@ResponseBody
	public ResponseEntity<Boolean> deleteAccount(HttpSession session, User u) {
		try {
			u.setId((Integer) session.getAttribute("userId"));
			return new ResponseEntity<>(userService.deleteUser(u), HttpStatus.OK);
		} catch (NullPointerException e) {
			return new ResponseEntity<>(false, HttpStatus.OK);
		}
	}

	@RequestMapping("/banned")
	@ResponseBody
	public ResponseEntity<List<User>> getBannedAccounts(HttpSession session) {
		try {
			User u = new User();
			u.setId((Integer) session.getAttribute("admin"));
			if (u.getId() == 1) {
				return new ResponseEntity<>(userService.getAllUsersByBan(), HttpStatus.OK);
			} else {
				return null;
			}
		} catch (NullPointerException e) {
			return null;
		}
	}

	@RequestMapping("/all")
	@ResponseBody
	public ResponseEntity<List<User>> getAllProfiles() {
		return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
	}

}
