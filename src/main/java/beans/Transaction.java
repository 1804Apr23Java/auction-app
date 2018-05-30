package beans;

import java.io.Serializable;

import javax.persistence.*;

public class Transaction implements Serializable {

	private static final long serialVersionUID = -3515915628132960776L;
	
	
	
	public Transaction(int id, String itemId, String sellerId, String buyerId, String sellerRating,
			String sellerReview) {
		super();
		this.id = id;
		this.itemId = itemId;
		this.sellerId = sellerId;
		this.buyerId = buyerId;
		this.sellerRating = sellerRating;
		this.sellerReview = sellerReview;
	}
	
	public Transaction(String itemId, String sellerId, String buyerId, String sellerRating,
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
	private String itemId;
	
	@Column(name = "SELLER_ID")
	private String sellerId;
	
	@Column(name = "BUYER_ID")
	private String buyerId;
	
	@Column(name = "SELLER_RATING")
	private String sellerRating;
	
	@Column(name = "SELLER_REVIEW")
	private String sellerReview;



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	public String getSellerRating() {
		return sellerRating;
	}

	public void setSellerRating(String sellerRating) {
		this.sellerRating = sellerRating;
	}

	public String getSellerReview() {
		return sellerReview;
	}

	public void setSellerReview(String sellerReview) {
		this.sellerReview = sellerReview;
	}
	
	
}
