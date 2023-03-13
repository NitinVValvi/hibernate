package hibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
	
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session = sf.openSession();
		
		User u = new User();
		
		u.setName("Nitin");
		
		Transaction tx = session.beginTransaction();
		
		session.save(u);
		
		tx.commit();
	}
}
