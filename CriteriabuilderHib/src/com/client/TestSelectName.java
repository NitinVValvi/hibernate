package com.client;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.config.HibernateUtil;
import com.model.Student;

public class TestSelectName {
	public static void main(String[] args) {
		
		//select ID,SNAME from student 
		SessionFactory sf = HibernateUtil.getSessionFactory();
		
		Session session = sf.openSession();
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
		
		CriteriaQuery<Student> cq = cb.createQuery(Student.class);
		
		Root<Student> sturoot = cq.from(Student.class);
		//cq.where(cb.equal(sturoot.get("sid"), 101),cb.equal(sturoot.get("sname"), "Nitin"));
		cq.where(cb.equal(sturoot.get("sid"),101));
		
		cq.where(cb.equal(sturoot.get("sname"), "Rahul"));
	
		List<Student> list = session.createQuery(cq).getResultList();
		
		list.forEach(l->System.out.println(l.toString()));
	}
}
