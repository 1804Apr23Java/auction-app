package com.revature.beans;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="TRANSACTION")
public class ItemTransaction implements Serializable {

	private static final long serialVersionUID = -3515915628132960776L;
	
	
	
	public ItemTransaction(int id, Item itemId, User sellerId, User buyerId, int sellerRating,
			String sellerReview) {
		super();
		this.id = id;
		this.itemId = itemId;
		this.sellerId = sellerId;
		this.buyerId = buyerId;
		this.sellerRating = sellerRating;
		this.sellerReview = sellerReview;
	}
	
	public ItemTransaction(Item itemId, User sellerId, User buyerId, int sellerRating,
			String sellerReview) {
		super();
		this.itemId = itemId;
		this.sellerId = sellerId;
		this.buyerId = buyerId;
		this.sellerRating = sellerRating;
		this.sellerReview = sellerReview;
	}
	
	public ItemTransaction() {
		super();

	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transactionSequence")
	@SequenceGenerator(allocationSize = 1, name = "transactionSequence", sequenceName = "SQ_TRANSACTION_PK")
	@Column(name = "TRANSACTION_ID")
	private int id;

	@ManyToOne
	@JoinColumn(name = "ITEM_ID", nullable=false)
	private Item itemId;
	
	@ManyToOne
	@JoinColumn(name = "SELLER_ID", nullable=false)
	private User sellerId;
	
	@ManyToOne
	@JoinColumn(name = "BUYER_ID")
	private User buyerId;
	
	@Column(name = "SELLER_RATING")
	private int sellerRating;
	
	@Column(name = "SELLER_REVIEW")
	private String sellerReview;



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

	public User getSellerId() {
		return sellerId;
	}

	public void setSellerId(User sellerId) {
		this.sellerId = sellerId;
	}

	public User getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(User buyerId) {
		this.buyerId = buyerId;
	}

	public int getSellerRating() {
		return sellerRating;
	}

	public void setSellerRating(int sellerRating) {
		this.sellerRating = sellerRating;
	}

	public String getSellerReview() {
		return sellerReview;
	}

	public void setSellerReview(String sellerReview) {
		this.sellerReview = sellerReview;
	}
	
	
}
