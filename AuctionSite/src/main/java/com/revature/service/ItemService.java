package com.revature.service;

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

	public int addItem(Item i) {
		int id = ir.addItem(i);
		return id;
	}

	public List<Item> getPopular(Item i) {
		List<Item> results = null;
		return results;
	}

	public List<Item> getRecent(Item i) {
		List<Item> results = null;
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

	public boolean newBid(User u, double price, Item i) {
		i.setCurrentBuyer(u.getId());
		i.setCurrentPrice(price);
		boolean itemResult = ir.updateItem(i);
		if (itemResult == true) {
			BiddingHistory bh = new BiddingHistory();
			bh.setBuyerId(u.getId());
			bh.setBadePrice(price);
			bh.setItemId(i.getId());
			br.addBiddingHistory(bh);
			return true;
		} else {
			return false;
		}
	}

}
