package backend;

import javax.persistence.*;

@Entity
@Table(name ="person")
public class Person {

	private int id;
	private String firstName;
	private String lastName;
	private String street;
	private int houseNumber;
	private String tel;
	private String email;
	private String mobile;
	private Account account;

	public Person() {

	}

	public Person(String firstName, String lastName, String street,
			int houseNumber, String tel, String email, String mobile) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.street = street;
		this.houseNumber = houseNumber;
		this.tel = tel;
		this.email = email;
		this.mobile = mobile;
		//this.account = account;
	}
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="firstname")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	@Column(name="lastname")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name="street")
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	
	@Column(name="housenumber")
	public int getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}
	
	@Column(name="tel")
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	@Column(name="email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="mobile")
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
	@OneToOne(mappedBy = "person",cascade = CascadeType.ALL)
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName
				+ ", street=" + street + ", houseNumber=" + houseNumber
				+ ", tel=" + tel + ", email=" + email + ", mobile=" + mobile
				+ "]";
	}

}
