package beans;

import java.io.InputStream;
import java.io.Serializable;

import javax.persistence.*;

public class Item implements Serializable {

	private static final long serialVersionUID = 8936579050460853453L;


	public Item(int id, String itemName, String timeLimit, String categoryTag, String description, InputStream image,
			String currentPrice, String currentBuyer) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.timeLimit = timeLimit;
		this.categoryTag = categoryTag;
		this.description = description;
		this.image = image;
		this.currentPrice = currentPrice;
		this.currentBuyer = currentBuyer;
	}

	public Item(String itemName, String timeLimit, String categoryTag, String description, InputStream image,
			String currentPrice, String currentBuyer) {
		super();
		this.itemName = itemName;
		this.timeLimit = timeLimit;
		this.categoryTag = categoryTag;
		this.description = description;
		this.image = image;
		this.currentPrice = currentPrice;
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

	@Column(name = "ITEM_NAME")
	private String itemName;

	@Column(name = "TIME_LIMIT")
	private String timeLimit;

	@Column(name = "CATEGORY_TAG")
	private String categoryTag;

	@Column(name = "ITEM_DESCRIPTION")
	private String description;
	
	@Column(name = "IMAGE")
	private InputStream image;

	@Column(name = "CURRENT_PRICE")
	private String currentPrice;

	@Column(name = "CURRENT_BUYER")
	private String currentBuyer;

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

	public String getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(String timeLimit) {
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

	public String getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(String currentPrice) {
		this.currentPrice = currentPrice;
	}

	public String getCurrentBuyer() {
		return currentBuyer;
	}

	public void setCurrentBuyer(String currentBuyer) {
		this.currentBuyer = currentBuyer;
	}

}
