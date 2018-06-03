package com.revature.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.beans.Item;
import com.revature.beans.ItemTransaction;
import com.revature.beans.User;

@Controller("itemTransactionController")
@RequestMapping("/transaction")
public class ItemTransactionController {

	@RequestMapping("/new")
	@ResponseBody
	public ResponseEntity<String> newItemTransaction(User u, Item i) {
		System.out.println("newItemTransaction started");
		ItemTransaction t = new ItemTransaction();
		System.out.println("newItemTransaction itemTransaction");
		System.out.println("testing u");
		System.out.println(u.toString());
		System.out.println("done");
		System.out.println("testing i");
		System.out.println(i.toString());
		System.out.println("done");
		System.out.println("Setting sellerId to trans");
		t.setSellerId(u);
		System.out.println("Setting itemId to trans");
		t.setItemId(i);
		

		return new ResponseEntity<>("New item and transaction created", HttpStatus.OK);

	}
}
