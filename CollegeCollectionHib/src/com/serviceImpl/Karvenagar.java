package com.serviceImpl;

import java.util.Random;
import java.util.Scanner;


import org.hibernate.Session;

import com.config.HibernateUtil;
import com.model.Batch;
import com.model.Course;
import com.model.Faculty;
import com.model.Student;
import com.service.CJC;

public class Karvenagar implements CJC {
	Scanner sc = new Scanner(System.in);
	
	Course course = new Course();
	Faculty faculty = new Faculty();
	Batch batch = new Batch();
	Student student = new Student();
	@Override
	public void addcourse() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("Enter the course id");
		int cid = sc.nextInt();
		course.setCid(cid);
		System.out.println("Enter the course name: ");
		course.setCname(sc.next());
		session.save(course);
		session.beginTransaction().commit();
		session.close();
	}

	@Override
	public void viewcourse() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println(course.getCid());
		System.out.println(course.getCname());
			session.beginTransaction().commit();
		}
	

	@Override
	public void addfaculty() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		course =session.get(Course.class, 101);
		System.out.println("enter no. of faculty to add");
		int n = sc.nextInt();
		for (int i = 1; i <=n; i++) {
			//Faculty f = new Faculty();
			System.out.println("enter faculty id");
			faculty.setFid(sc.nextInt());
			System.out.println("Enter faculty name: ");
			faculty.setFname(sc.next());
			
			faculty.setCourse(course);
			course.getFaculty().add(faculty);
			session.save(faculty);
		}
		session.beginTransaction().commit();
		
	}

	@Override
	public void viewfaculty() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("enter faculty id to retrieve");
		int fid = sc.nextInt();
		if(fid==faculty.getFid())
		{
		faculty = session.get(Faculty.class, faculty.getFid());
		for (Faculty faculty : course.getFaculty()) {
			System.out.println(faculty.getFid());
			System.out.println(faculty.getFname());
			System.out.println(faculty.getCourse().getCid());
			System.out.println(faculty.getCourse().getCname());
		}
		}
		
	}

	@Override
	public void addbatch() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		faculty = session.get(Faculty.class, faculty.getFid());
		System.out.println("enter faculty id: ");
		int fid = sc.nextInt();
		if(fid == faculty.getFid())
		{
			//System.out.println("Enter the batch id");
			//batch.setBid(sc.nextInt());
			System.out.println("Enter batch name");
			batch.setBname(sc.next());
			batch.getFaculty().add(faculty);
			session.save(faculty);
			session.save(batch);
		}
		session.beginTransaction().commit();
		
	}

	@Override
	public void viewbatch() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		batch = session.get(Batch.class, batch.getBid());
		System.out.println(batch.getBid());
		System.out.println(batch.getBname());
		for (Faculty faculty : batch.getFaculty()) {
			System.out.println(faculty.getFid());
			System.out.println(faculty.getFname());
			System.out.println(faculty.getCourse().getCid());
			System.out.println(faculty.getCourse().getCname());
		}
		
	}

	@Override
	public void addstudent() {
		
		
	}

	@Override
	public void viewstudent() {
		
		
	}

}
