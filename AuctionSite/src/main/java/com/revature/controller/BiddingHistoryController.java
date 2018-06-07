package com.revature.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.beans.BiddingHistory;
import com.revature.beans.Item;
import com.revature.service.BiddingHistoryService;

@Controller("biddingHistoryController")
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("/bh")
public class BiddingHistoryController {

	@Autowired
	private BiddingHistoryService biddingHistoryService;

	@RequestMapping("/history/{item_id}")
	@ResponseBody
	public ResponseEntity<List<BiddingHistory>> getItemBiddingHistory(@PathVariable("item_id") int itemId) {
		System.out.println(itemId);
		Item i = new Item();
		i.setId(itemId);
		System.out.println(biddingHistoryService.getBids(i));
		return new ResponseEntity<>(biddingHistoryService.getBids(i), HttpStatus.OK);
	}

}
