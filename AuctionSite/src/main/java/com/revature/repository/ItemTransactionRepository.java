package com.revature.repository;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
		Session s = sessionFactory.getCurrentSession();
		System.out.println(t.toString());
		//result returns pk of new item. 
		int result = (Integer) s.save(t);
		return result;
	}
	
	public ItemTransaction getTransactionInfoViaPk(ItemTransaction t) {
		ItemTransaction transaction = null;
		Session s = sessionFactory.getCurrentSession();
		transaction = (ItemTransaction) s.get(ItemTransaction.class, t.getId());

		return transaction;
	}
	
	public ItemTransaction getTransactionInfoViaItem(Item i) {
		ItemTransaction transaction = null;
		Session s = sessionFactory.getCurrentSession();
		Criteria cr = s.createCriteria(ItemTransaction.class).add(Restrictions.eq("item.id", i.getId()));	

		return transaction;
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
