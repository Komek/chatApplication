package backend;

import javax.persistence.*;

@Entity
@Table(name ="person")
public class Person {

	private String firstname;
	private String lastname;
	private String street;
	private int housenumber;
	private String tel;
	private String email;
	private String mobile;
	//private Account account;

	public Person() {

	}

	public Person(String firstName, String lastName,String email) {
		super();
		this.firstname = firstName;
		this.lastname = lastName;
		this.email = email;
		//this.account = account;
	}
	
	@Id
	@Column(name="email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	@Column(name="firstname")
	public String getFirstName() {
		return firstname;
	}

	public void setFirstName(String firstName) {
		this.firstname = firstName;
	}
	
	
	@Column(name="lastname")
	public String getLastName() {
		return lastname;
	}

	public void setLastName(String lastName) {
		this.lastname = lastName;
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
		return housenumber;
	}

	public void setHouseNumber(int houseNumber) {
		this.housenumber = houseNumber;
	}
	
	@Column(name="tel")
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	
	@Column(name="mobile")
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
//	@OneToOne(mappedBy = "person",cascade = CascadeType.ALL)
//	public Account getAccount() {
//		return account;
//	}
//
//	public void setAccount(Account account) {
//		this.account = account;
//	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstname + ", lastName=" + lastname
				+ ", street=" + street + ", houseNumber=" + housenumber
				+ ", tel=" + tel + ", email=" + email + ", mobile=" + mobile
				+ "]";
	}

}
