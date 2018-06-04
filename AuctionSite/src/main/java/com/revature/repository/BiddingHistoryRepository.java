package com.revature.repository;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.revature.beans.BiddingHistory;
import com.revature.beans.User;
import com.revature.util.HibernateUtil;

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

	public boolean updateHistoryInfo(BiddingHistory bh) {
		Session s = sessionFactory.getCurrentSession();
		try {
			s.delete(bh);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean deleteHistory(BiddingHistory bh) {
		Session s = sessionFactory.getCurrentSession();
		try {
			s.delete(bh);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
