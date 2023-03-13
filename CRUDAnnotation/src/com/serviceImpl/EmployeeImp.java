package com.serviceImpl;

import java.util.Scanner;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.model.Employee;
import com.service.EmployeeData;

public class EmployeeImp implements EmployeeData {
	Scanner sc = new Scanner(System.in);
	Employee e = new Employee();
	@Override
	public void insert() {
	System.out.println("Enter employee data to insert ");
		
		
		
			
			Configuration cfg = new Configuration();
			cfg.configure("com/configuration/hibernate.cfg.xml");
			SessionFactory sf = cfg.buildSessionFactory();
			
			Session session = sf.openSession();	
		
		
		System.out.print("Enter employee id: ");
		e.setEmp_id(sc.nextInt());
		System.out.print("Enter employee name: ");
		e.setEmp_name(sc.next());
		System.out.print("Enter employee designation: ");
		e.setEmp_designation(sc.next());
		System.out.print("Enter employee salary: ");
		e.setSalary(sc.nextDouble());
		Transaction tx = session.beginTransaction(); 
		session.save(e);
		tx.commit();
		session.close();
			
		
		
		
		
	}

	@Override
	public void update() {
		System.out.println("Enter data to update");
		Configuration cfg = new Configuration();
		cfg.configure("com/configuration/hibernate.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
	
		Session session = sf.openSession();
		System.out.print("Enter employee id: ");
		e.setEmp_id(sc.nextInt());
		Employee e1 = session.get(Employee.class, e.getEmp_id());
		
		System.out.println("Enter employee name: ");
		e1.setEmp_name(sc.next());
		//System.out.println("Enter employee designation: ");
		//e.setEmp_designation(sc.next());
		//System.out.println("Enter employee salary: ");
		//e.setSalary(sc.nextDouble());
		
		Transaction tx = session.beginTransaction();
		session.update(e1);
		tx.commit();
		session.close();
	}

	@Override
	public void delete() {
		Configuration cfg = new Configuration();
		cfg.configure("com/configuration/hibernate.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session = sf.openSession();
		System.out.println("Enter id to delete data: ");
		e.setEmp_id(sc.nextInt());
		Transaction tx = session.beginTransaction();
		session.delete(e);
		tx.commit();
		
		
	}

	@Override
	public void select() {
		System.out.println("Retrive Data");
		Configuration cfg = new Configuration();
		cfg.configure("com/configuration/hibernate.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Employee em = session.get(Employee.class, 101);
		System.out.println(em.getEmp_id());
		System.out.println(em.getEmp_name());
		System.out.println(em.getEmp_designation());
		System.out.println(em.getSalary());
		
		Transaction tx = session.beginTransaction();
		session.save(em);
		tx.commit();
		
		
	}

}
