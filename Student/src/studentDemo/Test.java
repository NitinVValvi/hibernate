package studentDemo;

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
		
		Session session = sf.openSession();
		
		Student stu = new Student();
		
		
		  System.out.print("Enter student rollno :"); stu.setRollno(sc.nextInt());
		  
		  System.out.println("Enter student name: "); stu.setName(sc.next());
		  
		  System.out.println("Enter subject: "); stu.setSub(sc.next());
		 
		
		
		
		Transaction tx = session.beginTransaction();
		
		session.save(stu);
		tx.commit();
		System.out.println("Data saved successfully!!!");
		sc.close();
		session.close();
	}
}
