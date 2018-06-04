package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Item;
import com.revature.repository.ItemRepository;
import com.revature.repository.UserRepository;

@Service(value="itemService")
public class ItemService {

	@Autowired
	ItemRepository ir;
	
	@Autowired
	UserRepository ur;
	
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
	
}
