package com.revature.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.beans.Item;
import com.revature.beans.User;
import com.revature.service.ItemService;

@Controller("itemController")
@CrossOrigin(origins= {"http://localhost:4200"})
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	private ItemTransactionController transController;
	
	@RequestMapping("/add")
	@ResponseBody
	public String addingItem(HttpSession session, User u, Item i) {
		System.out.println("testing sessions");
		u.setId((Integer) session.getAttribute("userId"));
		System.out.println(session.getAttribute("userId"));
		i.setSellerId(u.getId());
		i.setId((Integer) itemService.addItem(i));
		System.out.println("creating transcontroller");
		//transController.newItemTransaction(u, i);
		return "forward:/transaction/new";
		//return new ModelAndView("forward:/transaction/new", "item", i);
	}

	@RequestMapping("/getPopular")
	@ResponseBody
	public ResponseEntity<Integer> getCurrentPopularItems(Item i) {
		return new ResponseEntity<>(itemService.getPopular(i), HttpStatus.OK);
	}
	
	@RequestMapping("/getRecent")
	@ResponseBody
	public ResponseEntity<Integer> getMostRecentItems(Item i) {
		return new ResponseEntity<>(itemService.getRecent(i), HttpStatus.OK);
	}
	
	@RequestMapping("/getByCategory")
	@ResponseBody
	public ResponseEntity<Integer> addingCurrentItemsByCategory(Item i) {
		return new ResponseEntity<>(itemService.getByCategory(i), HttpStatus.OK);
	}
	
	@RequestMapping("/itemInfo")
	@ResponseBody
	public ResponseEntity<Item> getItemInformation(Item i) {
		return new ResponseEntity<>(itemService.getItemInfo(i), HttpStatus.OK);
	}
	
}
