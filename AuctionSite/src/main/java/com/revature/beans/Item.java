package com.revature.beans;


import java.io.Serializable;
import java.security.Timestamp;

import javax.persistence.*;

@Entity
@Table(name="ITEM")
public class Item implements Serializable {

	private static final long serialVersionUID = 8936579050460853453L;


	
	public Item(int id, String itemName, Timestamp timeLimit, String categoryTag, String description, String image,
			double currentPrice, String sellerId, User currentBuyer) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.timeLimit = timeLimit;
		this.categoryTag = categoryTag;
		this.description = description;
		this.image = image;
		this.currentPrice = currentPrice;
		this.sellerId = sellerId;
		this.currentBuyer = currentBuyer;
	}
	
	public Item(String itemName, Timestamp timeLimit, String categoryTag, String description, String image,
			double currentPrice, String sellerId, User currentBuyer) {
		super();
		this.itemName = itemName;
		this.timeLimit = timeLimit;
		this.categoryTag = categoryTag;
		this.description = description;
		this.image = image;
		this.currentPrice = currentPrice;
		this.sellerId = sellerId;
		this.currentBuyer = currentBuyer;
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

	@Column(name = "TIME_LIMIT", nullable=false)
	private Timestamp timeLimit;

	@Column(name = "CATEGORY_TAG", nullable=false)
	private String categoryTag;


	
	@Column(name = "ITEM_DESCRIPTION", nullable=false)
	private String description;
	
	@Column(name = "IMAGE", nullable=false)
	private String image;

	@Column(name = "CURRENT_PRICE", nullable=false)
	private double currentPrice = 0.00;

	@Column(name = "SELLER_ID", nullable=false)
	private String sellerId;
	
	@ManyToOne
	@JoinColumn(name = "CURRENT_BUYER")
	private User currentBuyer;

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

	public Timestamp getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(Timestamp timeLimit) {
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

	public User getCurrentBuyer() {
		return currentBuyer;
	}

	public void setCurrentBuyer(User currentBuyer) {
		this.currentBuyer = currentBuyer;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", itemName=" + itemName + ", timeLimit=" + timeLimit + ", categoryTag=" + categoryTag
				+ ", description=" + description + ", image=" + image + ", currentPrice=" + currentPrice + ", sellerId="
				+ sellerId + ", currentBuyer=" + currentBuyer + "]";
	}

}
