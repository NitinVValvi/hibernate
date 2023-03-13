package com.client;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.config.HibernateUtil;
import com.model.Student;

public class TestUpdate {
public static void main(String[] args) {
		
		//update student set sname = "Jayesh" where sid = 104
		SessionFactory sf = HibernateUtil.getSessionFactory();
		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		
		CriteriaUpdate<Student> cu = cb.createCriteriaUpdate(Student.class);
		
		Root<Student> sturoot = cu.from(Student.class);
		
		cu.set(sturoot.get("sname"),"Jayesh");
		
		cu.where(cb.equal(sturoot.get("sid"),104));
		
		Query q= session.createQuery(cu);
		q.executeUpdate();
		tx.commit();
		System.out.println("Data updated successfully");
}
}
