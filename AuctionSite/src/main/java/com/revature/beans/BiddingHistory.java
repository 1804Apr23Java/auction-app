package com.revature.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="BIDDING_HISTORY")
public class BiddingHistory implements Serializable {

	private static final long serialVersionUID = -8347365985841545839L;
	
	
	public BiddingHistory(int id, int itemId, int buyerId, double badePrice, Date time) {
		super();
		this.id = id;
		this.itemId = itemId;
		this.buyerId = buyerId;
		this.badePrice = badePrice;
		this.time = time;
	}
	
	public BiddingHistory(int itemId, int buyerId, double badePrice, Date time) {
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
	
	@Column(name = "ITEM_ID", nullable=false)
	private int itemId;

	@Column(name = "BUYER_ID", nullable=false)
	private int buyerId;
	
	@Column(name = "BADE_PRICE", nullable=false)
	private double badePrice;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TIME", updatable=false)
	private Date time;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}

	public double getBadePrice() {
		return badePrice;
	}

	public void setBadePrice(double badePrice) {
		this.badePrice = badePrice;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "BiddingHistory [id=" + id + ", itemId=" + itemId + ", buyerId=" + buyerId + ", badePrice=" + badePrice
				+ ", time=" + time + "]";
	}
	
	
}
