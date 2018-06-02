package com.revature.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.revature.beans.Item;
import com.revature.beans.User;
import com.revature.util.HibernateUtil;

@Repository(value = "itemRepository")
@Transactional
@EnableTransactionManagement
public class ItemRepository {

	@Autowired
	SessionFactory sessionFactory;

	public int addItem(Item i) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		// result returns pk of new item.
		int result = (Integer) s.save(i);
		tx.commit();
		s.close();
		return result;
	}

	public Item getItemInfo(Item i) {
		Item item = null;
		Session s = HibernateUtil.getSession();
		item = (Item) s.get(Item.class, i.getId());
		s.close();

		return item;
	}
	
	public List<Item> getAllItemsBySeller(int sellerId) {
		Session s = HibernateUtil.getSession();
		Criteria cr = s.createCriteria(Item.class);
		cr.add(Restrictions.eq("sellerId", sellerId)).list();
		List<Item> results = cr.list();
		return results;
	}

	public boolean updateItem(Item i) {
		Session s = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.merge(i);
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

	public boolean deleteUser(Item i) {
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
