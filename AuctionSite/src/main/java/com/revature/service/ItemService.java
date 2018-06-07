package com.revature.service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.BiddingHistory;
import com.revature.beans.Item;
import com.revature.beans.User;
import com.revature.repository.BiddingHistoryRepository;
import com.revature.repository.ItemRepository;
import com.revature.repository.UserRepository;

@Service(value = "itemService")
public class ItemService {

	@Autowired
	ItemRepository ir;

	@Autowired
	UserRepository ur;

	@Autowired
	BiddingHistoryRepository br;

	public int addItem(Item i, int timeLimit) {
		LocalDateTime a = LocalDateTime.now().plusDays(timeLimit);
		long millis = a.toInstant(ZoneOffset.ofTotalSeconds(0)).toEpochMilli();
		Date date = new Date(millis);
		i.setTimeLimit(date);
		int id = ir.addItem(i);
		return id;
	}

	public List<Item> getPopular() {
		List<Item> results = ir.getMostPopular();
		return results;
	}

	public List<Item> getRecent() {
		List<Item> results = ir.getMostRecent();
		return results;
	}

	public List<Item> getByCategory(Item i) {
		List<Item> results = ir.getAllItemsByCategory(i.getCategoryTag());
		return results;
	}

	public Item getItemInfo(Item i) {
		Item item = ir.getItemInfo(i);
		return item;
	}

	public List<Item> getItemsBySeller(int sellerId) {
		List<Item> results = ir.getAllItemsBySeller(sellerId);
		return results;
	}

	public boolean newBid(User u, Item i) {
		i.setCurrentBuyer(u.getId());
		boolean itemResult = ir.updateItem(i);
		if (itemResult == true) {
			BiddingHistory bh = new BiddingHistory();
			bh.setBuyerId(u.getId());
			bh.setBadePrice(i.getCurrentPrice());
			bh.setItemId(i.getId());
			LocalDateTime a = LocalDateTime.now();
			long millis = a.toInstant(ZoneOffset.ofTotalSeconds(0)).toEpochMilli();
			Date date = new Date(millis);
			bh.setTime(date);
			br.addBiddingHistory(bh);
			return true;
		} else {
			return false;
		}
	}

}
