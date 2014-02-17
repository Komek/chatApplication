package backend;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.tool.hbm2ddl.SchemaUpdate;



public class Main {

	public static void main(String[] args) {

		SchemaUpdate su = new SchemaUpdate(HibernateSessionFactory.getCfg());
		su.execute(true, true);

		createAndSaveTest();

	}

	public static void createAndSaveTest() {

		try {

			Session session = HibernateSessionFactory.currentSession();
			Transaction tx = session.beginTransaction();

			Person p1 = new Person("Max", "Mustermann","max.mustermann@abc.de");
			Account a1 = new Account("max", "test", p1);
		
			
			Person p2 = new Person("Udo", "Mix","udo.mix@abc.de");
			Account a2= new Account("udo", "tutu", p2);
		
			
			Person p3 = new Person("Jürgen", "Mayer","juergen.mayer@abc.de");
			Account a3= new Account("juergen", "tata", p3);
			
			session.saveOrUpdate(p3);
			session.saveOrUpdate(a3);
			session.saveOrUpdate(p2);
			session.saveOrUpdate(a2);
			session.saveOrUpdate(p1);
			session.saveOrUpdate(a1);
			
			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void getDatabase() {
		try {
			Session session = HibernateSessionFactory.currentSession();
			Transaction tx = session.beginTransaction();

			Account a1 =(Account) session.load(backend.Account.class, "max");
			Account a2=(Account) session.load(backend.Account.class, "udo");
			Account a3=(Account) session.load(backend.Account.class, "juergen");
			
			System.out.println(a1.toString());
			
			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
