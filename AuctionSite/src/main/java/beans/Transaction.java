package beans;

import java.io.Serializable;

import javax.persistence.*;

public class Transaction implements Serializable {

	private static final long serialVersionUID = -3515915628132960776L;
	
	
	
	public Transaction(int id, int itemId, int sellerId, int buyerId, int sellerRating,
			String sellerReview) {
		super();
		this.id = id;
		this.itemId = itemId;
		this.sellerId = sellerId;
		this.buyerId = buyerId;
		this.sellerRating = sellerRating;
		this.sellerReview = sellerReview;
	}
	
	public Transaction(int itemId, int sellerId, int buyerId, int sellerRating,
			String sellerReview) {
		super();
		this.itemId = itemId;
		this.sellerId = sellerId;
		this.buyerId = buyerId;
		this.sellerRating = sellerRating;
		this.sellerReview = sellerReview;
	}
	
	public Transaction() {
		super();

	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transactionSequence")
	@SequenceGenerator(allocationSize = 1, name = "transactionSequence", sequenceName = "SQ_TRANSACTION_PK")
	@Column(name = "TRANSACTION_ID")
	private int id;

	@Column(name = "ITEM_ID")
	private int itemId;
	
	@Column(name = "SELLER_ID")
	private int sellerId;
	
	@Column(name = "BUYER_ID")
	private int buyerId;
	
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

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public int getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(int buyerId) {
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
