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

	
	// result returns pk of new item.
	public int addItem(Item i) {
		Session s = sessionFactory.getCurrentSession();
		int result = (Integer) s.save(i);
		return result;
	}

	public Item getItemInfo(Item i) {
		Session s = sessionFactory.getCurrentSession();
		Item item = null;
		item = (Item) s.get(Item.class, i.getId());
		return item;
	}
	
	public List<Item> getAllItemsBySeller(int sellerId) {
		Session s = sessionFactory.getCurrentSession();
		Criteria cr = s.createCriteria(Item.class);
		cr.add(Restrictions.eq("sellerId", sellerId)).list();
		List<Item> results = cr.list();
		return results;
	}

	public boolean updateItem(Item i) {
		Session s = sessionFactory.getCurrentSession();
		try {
			s.merge(i);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean deleteItem(Item i) {
		Session s = sessionFactory.getCurrentSession();
		try {
			s.delete(i);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
