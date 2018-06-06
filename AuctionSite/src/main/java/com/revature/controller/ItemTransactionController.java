package com.revature.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.beans.ItemTransaction;

import com.revature.service.ItemTransactionService;

@Controller("itemTransactionController")
@RequestMapping("/transaction")
public class ItemTransactionController {

	@Autowired
	private ItemTransactionService transService;

	// adding transaction automatically done by itemController

	// updating transaction buy handled automatically, not by user

	// buyer add seller's rating and review
	@RequestMapping("/review")
	@ResponseBody
	public ResponseEntity<String> reviewItemTransaction(HttpSession session, ItemTransaction t) {
		// t should have ratings and reviews for seller as parameters
		t.setItemId(94); // used for testing, remove once param is passed
		t.setSellerRating(4); // used for testing, remove once param is passed
		t.setSellerReview("This man is a con artist!"); // used for testing, remove once param is passed
		t.setBuyerId((Integer) session.getAttribute("userId"));
		transService.giveReview(t);

		return new ResponseEntity<>("Transaction Review updated", HttpStatus.OK);

	}
}
