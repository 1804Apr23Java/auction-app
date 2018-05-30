package beans;

import java.io.Serializable;

import javax.persistence.*;

public class BiddingHistory implements Serializable {

	private static final long serialVersionUID = -8347365985841545839L;
	
	
	public BiddingHistory(int id, String itemId, String buyerId, String badePrice, String time) {
		super();
		this.id = id;
		this.itemId = itemId;
		this.buyerId = buyerId;
		this.badePrice = badePrice;
		this.time = time;
	}
	
	public BiddingHistory(String itemId, String buyerId, String badePrice, String time) {
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
	private String itemId;
	
	@Column(name = "BUYER_ID")
	private String buyerId;
	
	@Column(name = "BADE_PRICE")
	private String badePrice;
	
	@Column(name = "TIME")
	private String time;
}
