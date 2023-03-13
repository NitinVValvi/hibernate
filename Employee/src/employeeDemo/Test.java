package employeeDemo;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Configuration cfg = new Configuration();
		
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session= sf.openSession();
		
		Employee e = new Employee();
		System.out.println("Enter emp id" );
		e.setEmp_id(sc.nextInt());
		
		System.out.println("Enter name: ");
		e.setName(sc.next());
		
		System.out.println("Enter email: ");
		e.setEmail(sc.next());
		
		System.out.println("Enter address: ");
		e.setAddress(sc.next());
		
		System.out.println("Enter password: ");
		e.setPass(sc.next());
		
		Transaction tx = session.beginTransaction();
		
		session.save(e);
		
		tx.commit();
		System.out.println("Data updated successfully");
		session.close();
		sc.close();
	}
}
