package com.revature.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
@Table(name="USERS")
public class User implements Serializable {

	private static final long serialVersionUID = -6686626961005563005L;

	
	public User(int id, String username, String password, String firstName, String lastName, String email,
			int adminValue, int bannedCheck, double balance, String street, String city, String state, String zipcode) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.adminValue = adminValue;
		this.bannedCheck = bannedCheck;
		this.balance = balance;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}
	
	public User(String username, String password, String firstName, String lastName, String email,
			int adminValue, int bannedCheck, double balance, String street, String city, String state, String zipcode) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.adminValue = adminValue;
		this.bannedCheck = bannedCheck;
		this.balance = balance;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}

	public User() {
		super();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="userSequence")
	@SequenceGenerator(allocationSize=1,name="userSequence",sequenceName="SQ_USER_PK")
	@Column(name="USER_ID", nullable=false)
	private int id;
	
	@Column(name="USERNAME", nullable=false, unique=true)
	private String username;
	
	@Column(name="PASSWORD", nullable=false)
	private String password;

	@Column(name="FIRST_NAME", nullable=false)
	private String firstName;
	
	@Column(name="LAST_NAME", nullable=false)
	private String lastName;
	
	@Column(name="EMAIL", nullable=false, unique=true)
	private String email;
	
	@Column(name="ADMIN_VALUE", nullable=false)
	private int adminValue = 0;
	
	@Column(name="BANNED_CHECK", nullable=false)
	private int bannedCheck = 0;
	
	@Column(name="BALANCE", nullable=false)
	private double balance = 0.00;
	
	@Column(name="STREET", nullable=false)
	private String street;
	
	@Column(name="CITY", nullable=false)
	private String city;
	
	@Column(name="STATE", nullable=false)
	private String state;
	
	@Column(name="ZIP_CODE", nullable=false)
	private String zipcode;
	
	//private List<Item> userItems;
/*
	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="USERS")
	public List<Item> getItems() {
		return userItems;
	}
	
	public void setItems(List<Item> userItems) {
		this.userItems = userItems;
	}
*/
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAdminValue() {
		return adminValue;
	}

	public void setAdminValue(int adminValue) {
		this.adminValue = adminValue;
	}

	public int getBannedCheck() {
		return bannedCheck;
	}

	public void setBannedCheck(int bannedCheck) {
		this.bannedCheck = bannedCheck;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", adminValue=" + adminValue + ", bannedCheck="
				+ bannedCheck + ", balance=" + balance + ", street=" + street + ", city=" + city + ", state=" + state
				+ ", zipcode=" + zipcode + "]";
	}


}
