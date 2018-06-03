package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Item;
import com.revature.repository.ItemRepository;

@Service(value="itemService")
public class ItemService {

	@Autowired
	ItemRepository ir;
	
	public int addItem(Item i) {
		int id = ir.addItem(i);
		return id;
	}
	
	public int getPopular(Item i) {
		int pk = ir.addItem(i);
		return pk;
	}
	
	public int getRecent(Item i) {
		int pk = ir.addItem(i);
		return pk;
	}
	
	public int getByCategory(Item i) {
		int pk = ir.addItem(i);
		return pk;
	}
	
	public Item getItemInfo(Item i) {
		Item item = ir.getItemInfo(i);
		return item;
	}
}
