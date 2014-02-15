package backend;

import java.util.Random;
import javax.persistence.*;

@Entity
@Table(name = "account")
public class Account implements Comparable<Account> {

	public static Random rnd = new Random();
	private String username;
	private long password;
//	private long salt;
	private Person person;

	public Account() {

	}

	public Account(String username, String password, Person person) {
		super();
		this.username = username;
		this.setPassword(password);
		this.person = person;
	}

	@Id
	@Column(name = "username")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password")
	public long getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = this.generatePassword(password);
	}
	
	public void setPassword(long password) {
		this.password = password;
	}

	public long generatePassword(String password) {
		long hash = (long) password.hashCode();
		return hash;
	}

//	@Column(name = "salt")
//	public long getSalt() {
//		return salt;
//	}
//
//	public void setSalt(long salt) {
//		this.salt = rnd.nextLong();
//		if (this.salt < 0) {
//			this.salt = this.salt * (-1);
//		}
//	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_person")
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String toString() {
		return "Account [username=" + username + ", password=" + password
				+ ", person=" + person.getId() + "]";
	}

	public int compareTo(Account o) {
		return this.username.compareTo(o.username);
	}

}
