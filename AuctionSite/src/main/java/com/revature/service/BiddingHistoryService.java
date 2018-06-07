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

@Service(value = "biddingHistoryService")
public class BiddingHistoryService {

	@Autowired
	private BiddingHistoryRepository br;

	public int bidOnItem(Item i, User u, double price) {
		BiddingHistory bid = new BiddingHistory();
		bid.setBadePrice(price);
		bid.setBuyerId(u.getId());
		bid.setItemId(i.getId());
		LocalDateTime a = LocalDateTime.now();
		long millis = a.toInstant(ZoneOffset.ofTotalSeconds(0)).toEpochMilli();
		Date date = new Date(millis);
		bid.setTime(date);
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
