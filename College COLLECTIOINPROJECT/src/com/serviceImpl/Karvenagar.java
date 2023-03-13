package com.serviceImpl;

import java.util.Scanner;

import org.hibernate.Session;

import com.config.HibernateUtil;
import com.model.Batch;
import com.model.Course;
import com.model.Faculty;
import com.model.Student;
import com.service.Cjc;

public class Karvenagar implements Cjc {
	Scanner sc = new Scanner(System.in);
	
	Course course = new Course();
	Faculty faculty =new Faculty();
	Batch batch = new Batch();
	Student student = new Student();
 	@Override
	public void addCourse() {
	Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("Enter course id:");
		int cid = sc.nextInt();
		course.setCid(cid);
		
		System.out.println("Enter course name: ");
		String cname = sc.next();
		course.setCname(cname);
		
		session.save(course);
		session.beginTransaction().commit();
		session.close();
	}

	@Override
	public void viewCourse() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		System.out.println("Enter course id to retrieve data: ");
		int cid = sc.nextInt();
		course.setCid(cid);
		course = session.get(Course.class, course.getCid());
		session.update(course);
		System.out.println("course id: "+course.getCid());
		System.out.println("course name: "+course.getCname());
		session.beginTransaction().commit();
		session.close();
		
	}

	@Override
	public void addFaculty() {
	
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		System.out.println("Enter the faculty id: ");
		int fid = sc.nextInt();
		faculty.setFid(fid);
		
		System.out.println("Enter the faculty name: ");
		String fname = sc.next();
		faculty.setFname(fname);
		
		System.out.println("Enter the course id: ");
		int cid = sc.nextInt();
			if(cid == course.getCid() )
			{
				
				
				faculty.getCourse().add(course);
				session.save(faculty);
				session.beginTransaction().commit();
				session.close();
			}
			
			
		}
	

	@Override
	public void viewFaculty() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("Enter fid to retrieve: ");
		int fid = sc.nextInt();
		faculty.setFid(fid);
		faculty = session.get(Faculty.class, faculty.getFid());
		
		System.out.println(faculty.toString());
		
		for (Course course : faculty.getCourse()) {
			System.out.println("course id="+course.getCid());
			System.out.println("course name="+course.getCname());
		}
	
		session.beginTransaction().commit();
		session.close();
		
	}

	@Override
	public void addBatch() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("Enter batch id:");
		int bid = sc.nextInt();
		batch.setBid(bid);
		
		System.out.println("Enter batch name: ");
		String bname = sc.next();
		batch.setBname(bname);
		
		System.out.println("Enter faculty id: ");
		int fid = sc.nextInt();
		if(fid==faculty.getFid())
		{
		batch.getFaculty().add(faculty);
		session.save(batch);
		//session.update(faculty);
		session.beginTransaction().commit();
		session.close();
		}
		
	}

	@Override
	public void viewBatch() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("Enter batch id to retrieve");
		int bid = sc.nextInt();
		batch.setBid(bid);
		batch = session.get(Batch.class, batch.getBid());
		System.out.println(batch.toString());
	
		for (Faculty faculty : batch.getFaculty()) {
			System.out.println(faculty.getFid());
			System.out.println(faculty.getFname());
			System.out.println(faculty.getCourse().toString());
		}
		session.beginTransaction().commit();
		session.close();
	}

	@Override
	public void addStudent() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("Enter student id: ");
		int sid = sc.nextInt();
		student.setSid(sid);
		System.out.println("Enter student name: ");
		String sname = sc.next();
		student.setSname(sname);
		
		System.out.println("Enter batch id: ");
		int bid = sc.nextInt();
		
		if(bid == batch.getBid())
		{
		student.getBatch().add(batch);
		
		session.save(student);
		session.beginTransaction().commit();
		session.close();
		}
		
	}

	@Override
	public void viewStudent() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("Enter student id to retrieve: ");
		int sid = sc.nextInt();
		student.setSid(sid);
		student = session.get(Student.class, student.getSid());
		System.out.println(student.toString());
		
		for (Batch batch : student.getBatch()) {
			System.out.println(batch.getBid());
			System.out.println(batch.getBname());
			System.out.println(batch.getFaculty().toString());
		}
		session.beginTransaction().commit();
		session.close();
	}

}
