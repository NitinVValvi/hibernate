package com.client;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.config.HibernateUtil;
import com.model.Department;
import com.model.Employee;

public class Test {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		String hql = "from Department d join fetch d.employees";
		
		Query<Department> q = session.createQuery(hql);
		
		List<Department> dlist = q.getResultList();
		for (Department department : dlist) {
			System.out.println(department.getDid());
			for (Employee e : department.getEmployees()) {
				System.out.println(e.getEmpid());
				System.out.println(e.getEmpname());
			}
		}
		session.beginTransaction().commit();
	
	}
}
