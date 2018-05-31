package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import beans.BiddingHistory;
import util.HibernateUtil;

public class BiddingHistoryDao implements BiddingHistoryInterface {
	public List<BiddingHistory> getBiddingHistory() {
		List<BiddingHistory> history = new ArrayList<BiddingHistory>();
		Session s = HibernateUtil.getSession();
		history = s.createQuery("from BIDDING_HISTORY where ITEM_ID = ?").list();
		s.close();
		return history;
	}
}
