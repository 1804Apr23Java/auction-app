package com.revature.beans;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="ITEM")
public class Item implements Serializable {

	private static final long serialVersionUID = 8936579050460853453L;


	
	public Item(int id, String itemName, Date timeLimit, String categoryTag, String description, String image,
			double currentPrice, int sellerId, int currentBuyer) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.timeLimit = timeLimit;
		this.categoryTag = categoryTag;
		this.description = description;
		this.image = image;
		this.currentPrice = currentPrice;
		this.sellerId = sellerId;
		this.buyerId = currentBuyer;
	}
	
	public Item(String itemName, Date timeLimit, String categoryTag, String description, String image,
			double currentPrice, int sellerId, int currentBuyer) {
		super();
		this.itemName = itemName;
		this.timeLimit = timeLimit;
		this.categoryTag = categoryTag;
		this.description = description;
		this.image = image;
		this.currentPrice = currentPrice;
		this.sellerId = sellerId;
		this.buyerId = currentBuyer;
	}

	public Item() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemSequence")
	@SequenceGenerator(allocationSize = 1, name = "itemSequence", sequenceName = "SQ_ITEM_PK")
	@Column(name = "ITEM_ID")
	private int id;

	@Column(name = "ITEM_NAME", nullable=false)
	private String itemName;

	//@CreationTimestamp
	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TIME_LIMIT", updatable=false)
	private Date timeLimit;

	@Column(name = "CATEGORY_TAG", nullable=false)
	private String categoryTag;


	
	@Column(name = "ITEM_DESCRIPTION", nullable=false)
	private String description;
	
	@Column(name = "IMAGE", nullable=false)
	private String image;

	@Column(name = "CURRENT_PRICE", nullable=false)
	private double currentPrice = 0.00;

	@Column(name = "SELLER_ID", nullable=false)
	private int sellerId;
	
	@Column(name = "CURRENT_BUYER")
	private int buyerId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Date getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(Date timeLimit) {
		this.timeLimit = timeLimit;
	}

	public String getCategoryTag() {
		return categoryTag;
	}

	public void setCategoryTag(String categoryTag) {
		this.categoryTag = categoryTag;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}

	public int getCurrentBuyer() {
		return buyerId;
	}

	public void setCurrentBuyer(int buyerId) {
		this.buyerId = buyerId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", itemName=" + itemName + ", timeLimit=" + timeLimit + ", categoryTag=" + categoryTag
				+ ", description=" + description + ", image=" + image + ", currentPrice=" + currentPrice + ", sellerId="
				+ sellerId + ", buyerId=" + buyerId + "]";
	}

}
