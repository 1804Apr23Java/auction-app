package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.beans.Item;
import com.revature.beans.User;
import com.revature.service.ItemService;
import com.revature.service.ItemTransactionService;

@Controller("itemController")
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService itemService;

	@Autowired
	private ItemTransactionService transService;

	@RequestMapping("/add/{itemName}/{description}/{currentPrice}/{categoryTag}/{image}/{timeLeft}")
	@ResponseBody
	public String addingItem(HttpSession session, User u, Item i, @PathVariable("timeLeft") int timeLeft) {
		try {
			u.setId((Integer) session.getAttribute("userId"));
			i.setSellerId(u.getId());
			i.setId((Integer) itemService.addItem(i, timeLeft));
			transService.addItemTransaction(u, i);
			return "Added new item";
		} catch (NullPointerException e) {
			return "Uh oh: Probably no user logged in. Contact Zach for more info";
		}

	}

	@RequestMapping("/getPopular")
	@ResponseBody
	public ResponseEntity<List<Item>> getCurrentPopularItems(Item i) {
		return new ResponseEntity<>(itemService.getPopular(i), HttpStatus.OK);
	}

	@RequestMapping("/getRecent")
	@ResponseBody
	public ResponseEntity<List<Item>> getMostRecentItems(Item i) {
		return new ResponseEntity<>(itemService.getRecent(i), HttpStatus.OK);
	}

	@RequestMapping("/getByCategory/{categoryTag}")
	@ResponseBody
	public ResponseEntity<List<Item>> addingCurrentItemsByCategory(Item i) {
		return new ResponseEntity<>(itemService.getByCategory(i), HttpStatus.OK);
	}

	@RequestMapping("/getBySeller/{id}") // Id of seller
	@ResponseBody
	public ResponseEntity<List<Item>> getItemsBySeller(User u) {
		return new ResponseEntity<>(itemService.getItemsBySeller(u.getId()), HttpStatus.OK);
	}

	@RequestMapping("/itemInfo/{id}") // Id of item
	@ResponseBody
	public ResponseEntity<Item> getItemInformation(Item i) {
		return new ResponseEntity<>(itemService.getItemInfo(i), HttpStatus.OK);
	}

	@RequestMapping("/bid/{id}") //Buyer id
	@ResponseBody
	public ResponseEntity<Boolean> bidItem(HttpSession session, Item i) {
		try {
			User u = new User();
			u.setId((Integer) session.getAttribute("userId"));
			i.setCurrentPrice(99); // Used for testing db. Remove when done
			i.setId(94); // Used for testing db. Remove when done
			return new ResponseEntity<>(itemService.newBid(u, i), HttpStatus.OK);
		} catch (NullPointerException e) {
			return new ResponseEntity<>(false, HttpStatus.OK);
		}
	}

}
