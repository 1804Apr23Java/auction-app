package beans;

import java.io.Serializable;
import java.security.Timestamp;

import javax.persistence.*;

public class BiddingHistory implements Serializable {

	private static final long serialVersionUID = -8347365985841545839L;
	
	
	public BiddingHistory(int id, int itemId, int buyerId, double badePrice, Timestamp time) {
		super();
		this.id = id;
		this.itemId = itemId;
		this.buyerId = buyerId;
		this.badePrice = badePrice;
		this.time = time;
	}
	
	public BiddingHistory(int itemId, int buyerId, double badePrice, Timestamp time) {
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
	
	@Column(name = "ITEM_ID")
	private int itemId;
	
	@Column(name = "BUYER_ID")
	private int buyerId;
	
	@Column(name = "BADE_PRICE")
	private double badePrice;
	
	@Column(name = "TIME")
	private Timestamp time;


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

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}
	
	
}
