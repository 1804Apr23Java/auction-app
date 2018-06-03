package com.revature.beans;

import java.io.Serializable;
import java.security.Timestamp;

import javax.persistence.*;

@Entity
@Table(name="BIDDING_HISTORY")
public class BiddingHistory implements Serializable {

	private static final long serialVersionUID = -8347365985841545839L;
	
	
	public BiddingHistory(int id, Item itemId, User buyerId, double badePrice, Timestamp time) {
		super();
		this.id = id;
		this.itemId = itemId;
		this.buyerId = buyerId;
		this.badePrice = badePrice;
		this.time = time;
	}
	
	public BiddingHistory(Item itemId, User buyerId, double badePrice, Timestamp time) {
		super();
		this.itemId = itemId;
		this.buyerId = buyerId;
		this.badePrice = badePrice;
		this.time = time;
	}
	
	public BiddingHistory() {
		super();
	}
	

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "biddingSequence")
	@SequenceGenerator(allocationSize = 1, name = "biddingSequence", sequenceName = "SQ_BIDDING_PK")
	@Column(name = "BIDDING_ID")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "ITEM_ID", nullable=false)
	private Item itemId;
	
	@ManyToOne
	@JoinColumn(name = "BUYER_ID", nullable=false)
	private User buyerId;
	
	@Column(name = "BADE_PRICE", nullable=false)
	private double badePrice;
	
	@Column(name = "TIME", nullable=false)
	private Timestamp time;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Item getItemId() {
		return itemId;
	}

	public void setItemId(Item itemId) {
		this.itemId = itemId;
	}

	public User getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(User buyerId) {
		this.buyerId = buyerId;
	}

	public double getBadePrice() {
		return badePrice;
	}

	public void setBadePrice(double badePrice) {
		this.badePrice = badePrice;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}
	
	
}
