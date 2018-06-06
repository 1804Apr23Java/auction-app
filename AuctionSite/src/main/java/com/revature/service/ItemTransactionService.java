package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Item;
import com.revature.beans.ItemTransaction;
import com.revature.beans.User;
import com.revature.repository.ItemTransactionRepository;

@Service(value = "itemTransactionService")
public class ItemTransactionService {

	@Autowired
	private ItemTransactionRepository transaction;

	public int addItemTransaction(User u, Item i) {
		// User p = ip.userInfoViaKey(u);
		ItemTransaction transactionBean = new ItemTransaction();
		transactionBean.setSellerId(u.getId());
		transactionBean.setItemId(i.getId());
		System.out.println(transactionBean.toString());
		int id = transaction.createTransaction(transactionBean);
		return id;
	}

	public boolean giveReview(ItemTransaction t) {
		boolean result = transaction.giveReview(t);
		return result;

	}

}
