package com.revature.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("homeController")
@CrossOrigin(origins= {"http://localhost:4200"})
@RequestMapping("/")
public class HomePageController {

	@GetMapping(value="/homepage")
	public String homePage() {
		System.out.println("testing");
		return "index";
	}
	
	// to return bundled Angular app
	@GetMapping(value="/app")
	public String getApp() {
		return "forward:/views/index.html";

	}
	
}
