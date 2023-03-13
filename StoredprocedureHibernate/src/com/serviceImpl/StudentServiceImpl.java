package com.serviceImpl;

import java.util.List;
import java.util.Scanner;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import com.config.HibernateUtil;
import com.model.Student;
import com.service.StudentService;

public class StudentServiceImpl implements StudentService {
Scanner sc = new Scanner(System.in);
Student s = new Student();
	@Override
	public void insert() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		System.out.println("number of student data to enter");
		int n = sc.nextInt();
		for (int i = 1; i <=n; i++) {
			
			StoredProcedureQuery query = session.createStoredProcedureCall("insertdata");
			
			query.registerStoredProcedureParameter("rn", Integer.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("nm",String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("addr",String.class, ParameterMode.IN);

			//Student s1 = new Student();
			System.out.println("Enter student id: ");
			query.setParameter("rn", sc.nextInt());
			System.out.println("Enter the student name:");
			query.setParameter("nm", sc.next());
			System.out.println("Enter the student address:");
			query.setParameter("addr", sc.next());

			Transaction tx= session.beginTransaction();
			query.executeUpdate();
			//int insert = query.executeUpdate();
			tx.commit();
		}
		
	}

	@Override
	public void update() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		StoredProcedureQuery query = session.createStoredProcedureCall("updatedata");
		query.registerStoredProcedureParameter("rn",Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("nm", String.class, ParameterMode.IN);
	//	query.registerStoredProcedureParameter("addr", String.class, ParameterMode.IN);
	
		System.out.print("Enter ID: ");
			query.setParameter("rn", sc.nextInt());
			System.out.println("Select choice you want to update\n"+"1.Update Name\n"+"2.Update address\n");
			int input = sc.nextInt();
			if(input == 1)
			{
				System.out.print("Enter Name: " );
				query.setParameter("nm", sc.next());
			}else if(input == 2)
			{
				System.out.println("Enter Address");
				query.setParameter("addr", sc.next());

			}
			query.executeUpdate();
			tx.commit();
		
	}

	@Override
	public void delete() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

	System.out.println("Enter id to delete data from: ");
	StoredProcedureQuery query = session.createStoredProcedureCall("selectdata");

		query.setParameter("rn", sc.nextInt());
		query.executeUpdate();
		System.out.println("data deleted successfully");
		
		tx.commit();
	}

	@Override
	public void select() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		StoredProcedureQuery query = session.createStoredProcedureCall("selectdata",Student.class);
		query.registerStoredProcedureParameter("rn",Integer.class, ParameterMode.IN);
	//	query.registerStoredProcedureParameter("nm",String.class, ParameterMode.IN);
	//	query.registerStoredProcedureParameter("addr",String.class, ParameterMode.IN);
		

		System.out.println("Enter the Id to retrieve");
		query.setParameter("rn", sc.nextInt());
		Student stu = (Student)query.getSingleResult();
		
		System.out.println(stu.toString());
	
		tx.commit();
		
//		List<Student> list = query.getResultList();
//		for(Student s :list)
//		{
//			System.out.println(s.getId());
//			System.out.println(s.getName());
//		}
		
		
	}

}
