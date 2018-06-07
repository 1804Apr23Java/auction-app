package com.revature.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("homeController")
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/")
public class HomePageController {

	@GetMapping(value="/homepage")
	public String homePage() {
		return "forward:/views/test.html";
	}
	
	@GetMapping(value="/app")
	public String homePage2() {
		return "forward:/views/index.html";
	}
}
