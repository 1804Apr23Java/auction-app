package com.revature.repository;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.revature.beans.Item;
import com.revature.beans.ItemTransaction;
import com.revature.util.HibernateUtil;

@Repository(value="transactionRepository")
@Transactional
@EnableTransactionManagement
public class ItemTransactionRepository {

	@Autowired
	SessionFactory sessionFactory;
	public int createTransaction(ItemTransaction t) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		//result returns pk of new item. 
		int result = (Integer) s.save(t);
		tx.commit();
		s.close();
		return result;
	}
	
	public ItemTransaction getTransactionInfo(ItemTransaction t) {
		ItemTransaction transaction = null;
		Session s = HibernateUtil.getSession();
		transaction = (ItemTransaction) s.get(Transaction.class, t.getId());
		s.close();

		return transaction;
	}
	
	public boolean deleteTransaction(Item i) {
		Session s = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.delete(i);
			tx.commit();
			return true;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			s.close();
		}
		return false;
	}
}
