package beans;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="USER")
public class User implements Serializable {

	private static final long serialVersionUID = -6686626961005563005L;


	
	public User(int id, String username, String password, String firstName, String lastName, String email,
			int adminValue, int bannedCheck, int balance, int street, int city, int state, int zipcode) {
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
			int adminValue, int bannedCheck, int balance, int street, int city, int state, int zipcode) {
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
	@Column(name="USER_ID")
	private int id;
	
	@Column(name="USERNAME")
	private String username;
	
	@Column(name="PASSWORD")
	private String password;

	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="ADMIN_VALUE")
	private int adminValue;
	
	@Column(name="BANNED_CHECK")
	private int bannedCheck;
	
	@Column(name="BALANCE")
	private int balance;
	
	@Column(name="STREET")
	private int street;
	
	@Column(name="CITY")
	private int city;
	
	@Column(name="STATE")
	private int state;
	
	@Column(name="ZIP_CODE")
	private int zipcode;

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

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getStreet() {
		return street;
	}

	public void setStreet(int street) {
		this.street = street;
	}

	public int getCity() {
		return city;
	}

	public void setCity(int city) {
		this.city = city;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	
	
}
