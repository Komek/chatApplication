package backend;


import org.hibernate.*;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;


public class HibernateSessionFactory {
	private static String CONFIG_FILE_LOCATION = "/hibernate.cfg.xml";
	private static final ThreadLocal threadLocal = new ThreadLocal();
	private static final AnnotationConfiguration cfg = new AnnotationConfiguration();
	private static SessionFactory sessionFactory;

	public static Session currentSession() throws HibernateException {
		Session session = (Session) threadLocal.get();

		if (session == null || !session.isConnected()) {
			if (sessionFactory == null) {
				try {
					cfg.configure(CONFIG_FILE_LOCATION);
					sessionFactory = cfg.buildSessionFactory();
				} catch (Exception e) {
					System.err
							.println("%%%% Error Creating SessionFactory %%%%");
					e.printStackTrace();
				}
			}
			session = sessionFactory.openSession();
			threadLocal.set(session);
		}

		return session;
	}

	public static void closeSession() throws HibernateException {
		Session session = (Session) threadLocal.get();
		threadLocal.set(null);

		if (session != null) {
			session.close();
		}
	}

	private HibernateSessionFactory() {
	}

	public static Configuration getCfg() {
		currentSession();
		return cfg;
	}
}