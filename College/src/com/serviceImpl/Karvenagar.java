package com.serviceImpl;

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
		
		System.out.println("Enter course id:");
		int cid = sc.nextInt();
		course.setCid(cid);
		
		System.out.println("Enter course name: ");
		String cname = sc.next();
		course.setCname(cname);
		
		session.save(course);
		session.beginTransaction().commit();
		
	}
	@Override
	public void viewcourse() {
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
	public void addfaculty() {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		System.out.println("Enter the fid: ");
		int fid = sc.nextInt();
		faculty.setFid(fid);
		
		System.out.println("Enter the faculty name: ");
		String fname = sc.next();
		faculty.setFname(fname);
		System.out.println("Enter course id: ");
		int cid = sc.nextInt();
		
		if(cid == course.getCid())
		{
		faculty.setCourse(course);
		
		session.save(faculty);
		session.save(course);
		session.beginTransaction().commit();
		session.close();
		}
		}
	@Override
	public void viewfaculty() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("Enter fid to retrieve: ");
		int fid = sc.nextInt();
		faculty.setFid(fid);
		faculty = session.get(Faculty.class, faculty.getFid());
		System.out.println("faculty id:"+faculty.getFid());
		System.out.println("faculty name: "+faculty.getFname());
		System.out.println("course id: "+faculty.getCourse().getCid());
		System.out.println("course name: "+faculty.getCourse().getCname());
		session.beginTransaction().commit();
		session.close();
	}


	@Override
	public void addbatch() {
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
		batch.setFaculty(faculty);
		session.save(batch);
		session.update(faculty);
		session.beginTransaction().commit();
		session.close();
		}
	}
	@Override
	public void viewbatch() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("Enter batch id to retrieve");
		int bid = sc.nextInt();
		batch.setBid(bid);
		batch = session.get(Batch.class, batch.getBid());
		System.out.println("Batch id: "+batch.getBid());
		System.out.println("Batch id: "+batch.getBname());
		System.out.println("faculty id: "+batch.getFaculty().getFid());
		System.out.println("faculty name: "+batch.getFaculty().getFname());
		System.out.println("course id : "+batch.getFaculty().getCourse().getCid());
		System.out.println("course name: "+batch.getFaculty().getCourse().getCname());
		session.beginTransaction().commit();
		session.close();
	}
	@Override
	public void addstudent() {
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
		student.setBatch(batch);
		session.save(student);
		session.beginTransaction().commit();
		session.close();
		}
	}
	@Override
	public void display() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("Enter student id to retrieve: ");
		int sid = sc.nextInt();
		student.setSid(sid);
		student = session.get(Student.class, student.getSid());
		System.out.println("Student id: "+student.getSid());
		System.out.println("student name:"+student.getSname());
		System.out.println("Batch id:"+student.getBatch().getBid());
		System.out.println("batch name: "+student.getBatch().getBname());
		System.out.println("Faculty id: "+student.getBatch().getFaculty().getFid());
		System.out.println("Faculty name: "+student.getBatch().getFaculty().getFname());
		System.out.println("course id: "+student.getBatch().getFaculty().getCourse().getCid());
		System.out.println("course name: "+student.getBatch().getFaculty().getCourse().getCname());
		session.beginTransaction().commit();
		session.close();
	}

}
