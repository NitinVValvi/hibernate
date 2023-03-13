package com.serviceImpl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.config.HibernateUtil;
import com.model.Student;
import com.service.StudentService;

public class StudentSeriviceImpl implements StudentService {
	Scanner sc = new Scanner(System.in);
	Student s = new Student();
	@Override
	public void save() {
	
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("number of student data to enter");
		int n = sc.nextInt();
		for (int i = 0; i <=n; i++) {
			Student s1 = new Student();
			System.out.println("Enter student id: ");
			s1.setSid(sc.nextInt());
			System.out.println("Enter the student name:");
			s1.setSname(sc.next());
			System.out.println("Enter the student address: ");
			s1.setAddr(sc.next());
			session.save(s1);
			session.beginTransaction().commit();
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
			Query<Student> query = session.createNamedQuery("Update");
		//	Query<Student> query1 = session.createNamedQuery("Update1");

			System.out.print("Enter ID: ");
			query.setParameter(2, sc.nextInt());
			System.out.println("Select choice you want to update\n"+"1.Update Name\n"+"2.Update address\n");
			int input = sc.nextInt();
			if(input == 1)
			{
				System.out.print("Enter Name: " );
				query.setParameter(1, sc.next());
			}else if(input == 2)
			{
				System.out.println("Enter Address");
				query.setParameter(1, sc.next());

			}
			query.executeUpdate();
			//query1.executeUpdate();
			int count = query.executeUpdate();
			//int count1 = query1.executeUpdate();
	        System.out.println(count + " Record(s) Updated.");
	      

			tx.commit();
		
		
	}

	@Override
	public void delete() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		s = (Student) session.getNamedQuery("Delete").setParameter(0, 105);
		System.out.println("data deleted successfully");
	}

	@SuppressWarnings("unchecked")
	@Override
	public void select() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		List<Student> l = session.getNamedQuery("findAll").getResultList();
		l.forEach(i-> System.out.println(i.toString()));
		
	}

}
