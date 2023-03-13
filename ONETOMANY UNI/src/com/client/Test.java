package com.client;



import org.hibernate.Session;

import com.config.HibernateUtil;
import com.model.Department;
import com.model.Employee;

public class Test {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		
		
		  Employee e1 = new Employee(); 
		  e1.setEmpid(2); 
		  e1.setEmpname("Pratik");
		  
		  Employee e2= new Employee(); 
		  e2.setEmpid(3);
		  e2.setEmpname("Rahul");
		  Department d = new Department(); 
		  d.setDid(11); d.setDname("Computer");
		  
		  
		  d.getEmployees().add(e1);
		  d.getEmployees().add(e2);
	
		session.save(d);
		session.beginTransaction().commit();
		 
			d = session.get(Department.class, d.getDid());
			System.out.println(d.getDid());
			System.out.println(d.getDname());
		for (Employee e : d.getEmployees()) {
			System.out.println(e.getEmpid());
			System.out.println(e.getEmpname());
			
		}
	}
}
