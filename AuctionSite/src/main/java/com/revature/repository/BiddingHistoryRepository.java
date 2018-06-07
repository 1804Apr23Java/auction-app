package com.revature.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.revature.beans.BiddingHistory;

@Repository(value = "biddingHistoryRepository")
@Transactional
@EnableTransactionManagement
public class BiddingHistoryRepository {

	@Autowired
	SessionFactory sessionFactory;

	public int addBiddingHistory(BiddingHistory bh) {
		Session s = sessionFactory.getCurrentSession();
		int result = (Integer) s.save(bh);
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<BiddingHistory> getAllBidsByitem(int itemId) {
		Session s = sessionFactory.getCurrentSession();
		Criteria cr = s.createCriteria(BiddingHistory.class);
		cr.add(Restrictions.eq("itemId", itemId));
		cr.addOrder(Order.desc("time")).list();
		List<BiddingHistory> results = cr.list();
		return results;
	}

	public boolean deleteHistory(BiddingHistory bh) {
		Session s = sessionFactory.getCurrentSession();
		try {
			BiddingHistory bid = (BiddingHistory) s.load(BiddingHistory.class, bh.getId());
			s.delete(bid);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
