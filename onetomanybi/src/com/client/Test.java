package com.client;

import org.hibernate.Session;

import com.config.HibernateUtil;
import com.model.Department;
import com.model.Employee;

public class Test {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Department d = new Department();
		d.setDid(11);
		d.setDname("Computer");
		
		Employee e1 = new Employee();
		e1.setEmp_id(1);
		e1.setEmpname("Nitin");
		e1.setD(d);
		
		Employee e2 = new Employee();
		e2.setEmp_id(2);
		e2.setEmpname("Rahul");
		e2.setD(d);
		
		d.getE().add(e1);
		d.getE().add(e2);
		
		session.save(d);
		
		session.beginTransaction().commit();
		
		d = session.load(Department.class, d.getDid());
		System.out.println(d.getDid());
		System.out.println(d.getDname());
		
		for (Employee e : d.getE()) {
			System.out.println(e.getD().getDid());
			System.out.println(e.getEmp_id());
			System.out.println(e.getEmpname());
		}
	}
}
