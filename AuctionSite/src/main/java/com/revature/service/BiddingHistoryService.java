package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.BiddingHistory;
import com.revature.beans.Item;
import com.revature.beans.User;
import com.revature.repository.BiddingHistoryRepository;

@Service(value = "biddingHistoryService")
public class BiddingHistoryService {

	@Autowired
	private BiddingHistoryRepository br;

	public int bidOnItem(Item i, User u, double price) {
		BiddingHistory bid = new BiddingHistory();
		bid.setBadePrice(price);
		bid.setBuyerId(u.getId());
		bid.setItemId(i.getId());
		int pk = br.addBiddingHistory(bid);
		return pk;
	}
	
	public List<BiddingHistory> getBids(Item i) {
		List<BiddingHistory> results = br.getAllBidsByitem(i.getId());
		return results;
	}
	
	public boolean deleteBid(BiddingHistory bh) {
		boolean result = br.deleteHistory(bh);
		return result;
	}
}
