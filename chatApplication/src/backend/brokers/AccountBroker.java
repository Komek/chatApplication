package backend.brokers;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.tool.hbm2ddl.SchemaUpdate;

import backend.Account;
import backend.HibernateSessionFactory;
import backend.Person;

public class AccountBroker {
	private Session session;
	private Transaction tx;
	private Account account = null;

	public AccountBroker() {
		SchemaUpdate su = new SchemaUpdate(HibernateSessionFactory.getCfg());
		su.execute(true, true);
	}

	public Account loadAccount(String pKey) {
		try {
			session = HibernateSessionFactory.currentSession();
			tx = session.beginTransaction();
			account = (Account) session.load(backend.Account.class, pKey);

			tx.commit();
			//session.close(); //TODO LAZY AUSSCHALTEN!

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("---Account konnte nicht geladen werden---");
		}
		return account;
	}
	
	public boolean createAccount(String username, String password, Person person){
		boolean ret = false;
		try {
			account = new Account(username, password, person);
			session = HibernateSessionFactory.currentSession();
			tx = session.beginTransaction();
			session.save(account);

			tx.commit();
			ret= true;
			// session.close(); TODO LAZY AUSSCHALTEN!

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("---Account konnte nicht angelegt werden---");
		}
		return ret;
	}
}
