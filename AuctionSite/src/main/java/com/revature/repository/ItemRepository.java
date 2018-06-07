package com.revature.repository;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
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

	public List<Item> getMostPopular() {
		Session s = sessionFactory.getCurrentSession();
		List<Item> itemIds  = null; // s.createQuery("Select id, COUNT(BiddingHistoryId) from Item JOIN BiddingHistory ON id = itemId GROUP BY id ORDER BY Count(BiddingHistoryId) desc").setMaxResults(7).list();
		/*List<Item> items;
		for (Item i : itemIds) {
		}*/
		return itemIds;
	}
	
	@SuppressWarnings("unchecked")
	public List<Item> getMostRecent() {
		Session s = sessionFactory.getCurrentSession();
		List<Item> items  = s.createQuery("From Item order by id desc").setMaxResults(7).list();
		return items;
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
