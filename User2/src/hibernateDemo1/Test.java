package hibernateDemo1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Test {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
	
		cfg.configure().addAnnotatedClass(User.class);
		
		ServiceRegistry sreg = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		SessionFactory sf = cfg.buildSessionFactory(sreg);
		
		Session session = sf.openSession();
		
		User u = new User();
		u.setUid(4);
		u.setName("Shreyas");
		
		Transaction tx = session.beginTransaction();
		
		session.save(u);
		
		tx.commit();
		session.close();
	}
}
