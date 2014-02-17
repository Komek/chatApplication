package backend.brokers;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.tool.hbm2ddl.SchemaUpdate;
import backend.Person;
import backend.HibernateSessionFactory;

public class PersonBroker {

	private Session session;
	private Transaction tx;
	Person person = null;

	public PersonBroker() {
		SchemaUpdate su = new SchemaUpdate(HibernateSessionFactory.getCfg());
		su.execute(true, true);
	}

	public boolean createPerson(String firstname, String lastname, String email) {
		boolean ret=false;
		try {
			person = new Person(firstname, lastname, email);
			session = HibernateSessionFactory.currentSession();
			tx = session.beginTransaction();
			session.save(person);
			tx.commit();
			// session.close(); TODO LAZY AUSSCHALTEN!
			ret = true;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("---Account konnte nicht angelegt werden---");
		}
		return ret;
	}
	
	public Person getPerson(String email){
		Person person=null;
		try {
			session = HibernateSessionFactory.currentSession();
			tx = session.beginTransaction();
			person=(Person) session.load(backend.Person.class, email);
			tx.commit();
			// session.close(); TODO LAZY AUSSCHALTEN!
			

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("---Person konnte nicht angelegt werden---");
		}
		
		return person;
		
	}

}
