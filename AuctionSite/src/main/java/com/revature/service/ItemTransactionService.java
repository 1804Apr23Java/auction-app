package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.beans.Item;
import com.revature.beans.ItemTransaction;
import com.revature.beans.User;
import com.revature.repository.ItemTransactionRepository;

public class ItemTransactionService {

	@Autowired
	private ItemTransaction transaction;
	private ItemTransactionRepository transactionRepo;
	
	public int addItemTransaction(User u, Item i) {
		transaction.setSellerId(u);
		transaction.setItemId(i);
		int id = transactionRepo.createTransaction(transaction);
		return id;
	}
	
}
