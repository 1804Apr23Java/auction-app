package com.revature.repository;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.revature.beans.ItemTransaction;

@Repository(value = "transactionRepository")
@Transactional
@EnableTransactionManagement
public class ItemTransactionRepository {

	@Autowired
	SessionFactory sessionFactory;

	public int createTransaction(ItemTransaction t) {
		Session s = sessionFactory.getCurrentSession();
		System.out.println(t.toString());
		// result returns pk of new item.
		int result = (Integer) s.save(t);
		return result;
	}

	public ItemTransaction getTransactionInfo(ItemTransaction t) {
		ItemTransaction transaction = null;
		Session s = sessionFactory.getCurrentSession();
		transaction = (ItemTransaction) s.get(Transaction.class, t.getId());

		return transaction;
	}

	public boolean giveReview(ItemTransaction t) {
		Session s = sessionFactory.getCurrentSession();
		try {
			Query query = s.createQuery("FROM ItemTransaction where itemId = :itemId");
			query.setInteger("itemId", t.getItemId());
			ItemTransaction transaction = (ItemTransaction) query.uniqueResult();
			System.out.println(t.getSellerId());
			System.out.println(t.getSellerRating());
			System.out.println(t.getSellerReview());
			transaction.setSellerRating(t.getSellerRating());
			transaction.setSellerReview(t.getSellerReview());
			s.update(transaction);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean deleteTransaction(ItemTransaction t) {
		Session s = sessionFactory.getCurrentSession();
		try {
			s.delete(t);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
