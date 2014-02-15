package backend.brokers;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.tool.hbm2ddl.SchemaUpdate;
import backend.Account;
import backend.HibernateSessionFactory;

public class LoginBroker {
	private Session session;
	private Transaction tx;
	Account account = null;

	public LoginBroker() {
		SchemaUpdate su = new SchemaUpdate(HibernateSessionFactory.getCfg());
		su.execute(true, true);
	}

	public Account loadAccount(String pKey) {
		try {
			session = HibernateSessionFactory.currentSession();
			tx = session.beginTransaction();
			account = (Account) session.load(backend.Account.class, pKey);

			tx.commit();
			// session.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("---Account konnte nicht geladen werden---");
		}
		return account;
	}
}
