package com.client;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.config.HibernateUtil;
import com.model.Student;

public class TestMultiproperty {
	public static void main(String[] args) {
		
		// mulitple property
		SessionFactory sf = HibernateUtil.getSessionFactory();
		
		Session session = sf.openSession();
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
		
		CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
		
		Root<Student> sturoot = cq.from(Student.class);
		
		cq.multiselect(sturoot.get("sname"),sturoot.get("sid"));
		
		Query q = session.createQuery(cq);
		List<Object[]> list = q.getResultList();
		
		for (Object[] objects : list) {
			System.out.println("Student name: "+(String)objects[0]);
			System.out.println("Student id: "+(Integer)objects[1]);
		}
	}
}
