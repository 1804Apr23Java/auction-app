package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Item;
import com.revature.beans.ItemTransaction;
import com.revature.beans.User;
import com.revature.repository.ItemTransactionRepository;
import com.revature.repository.UserRepository;
import com.revature.repository.ItemRepository;


@Service(value="itemTransactionService")
public class ItemTransactionService {

	@Autowired
	private ItemTransactionRepository transaction;
	
	@Autowired
	private UserRepository ip;

	
	public int addItemTransaction(User u, Item i) {
		//User p = ip.userInfoViaKey(u);
		ItemTransaction transactionBean = new ItemTransaction();
		transactionBean.setSellerId(u);
		transactionBean.setItemId(i);
		System.out.println(transactionBean.toString());
		int id = transaction.createTransaction(transactionBean);
		return id;
	}
	
}
