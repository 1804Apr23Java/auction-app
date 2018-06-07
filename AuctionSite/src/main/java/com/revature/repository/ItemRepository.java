package com.revature.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.revature.beans.Item;

@Repository(value = "itemRepository")
@Transactional
@EnableTransactionManagement
public class ItemRepository {

	@Autowired
	SessionFactory sessionFactory;

	// result returns pk of new item.
	public int addItem(Item i, int timeLimit) {
		Session s = sessionFactory.getCurrentSession();
		int result = (Integer) s.save(i);
		System.out.println("executing query");
		s.createSQLQuery("CALL BID_TIME(:time, :itemId)")
		.setParameter("time", timeLimit).setParameter("itemId", i.getId()).executeUpdate();
		System.out.println("executed query");
		return result;
	}

	public Item getItemInfo(Item i) {
		Session s = sessionFactory.getCurrentSession();
		Item item = null;
		item = (Item) s.get(Item.class, i.getId());
		return item;
	}

	@SuppressWarnings("unchecked")
	public List<Item> getAllItemsBySeller(int sellerId) {
		Session s = sessionFactory.getCurrentSession();
		Criteria cr = s.createCriteria(Item.class);
		cr.add(Restrictions.eq("sellerId", sellerId)).list();
		List<Item> results = cr.list();
		return results;
	}

	@SuppressWarnings("unchecked")
	public List<Item> getAllItemsByCategory(String category) {
		Session s = sessionFactory.getCurrentSession();
		Criteria cr = s.createCriteria(Item.class);
		cr.add(Restrictions.eq("categoryTag", category)).list();
		List<Item> results = cr.list();
		return results;
	}

	public boolean updateItem(Item i) {
		Session s = sessionFactory.getCurrentSession();
		try {
			Item item = (Item) s.load(Item.class, i.getId());
			item.setCurrentBuyer(i.getCurrentBuyer());
			item.setCurrentPrice(i.getCurrentPrice());
			s.update(item);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean deleteItem(Item i) {
		Session s = sessionFactory.getCurrentSession();
		try {
			Item item = (Item) s.load(Item.class, i.getId());
			s.delete(item);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
