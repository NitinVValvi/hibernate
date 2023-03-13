package com.serviceImpl;

import java.util.Scanner;

import org.hibernate.Session;

import com.service.Cjc;
import com.config.HibernateUtil;
import com.model.Batch;
import com.model.Course;
import com.model.Faculty;
import com.model.Student;

public class Karvenagar implements Cjc{
	
	Course course = new Course();
	Faculty faculty = new Faculty();
	Batch batch = new Batch();
	Student student = new Student();
	int count = 0;
	int count1 = 0;
	int count2 = 0;
	int count3 = 0;
	@SuppressWarnings("resource")
	public void addCourse()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Scanner sc = new Scanner(System.in);
		 System.out.println("Enter the course id: ");
		 int cid = sc.nextInt();
		 course.setCid(cid);
		 
		 System.out.println("Enter the course name: ");
		 String cname = sc.next();
		 course.setCname(cname);
		 
		 course.getClist().add(course);
		 session.save(course);
		 session.beginTransaction().commit();
		 
	}
	public void viewCourse()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();

	}
	@Override
	public void addFaculty() {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
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
				faculty.setCourse(course);
				faculty.getFlist().add(faculty);
				session.save(faculty);
			}
			
			
		}
		
	
	@Override
	public void viewFaculty() {
	
	}
	@Override
	public void addBatch() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the Batch id: ");
		int bid = sc.nextInt();
		batch.setBid(bid);
		
		System.out.println("Enter the Batch name: ");
		String bname = sc.next();
		batch.setBname(bname);
		
		System.out.println("Enter the faculty id: ");
		int fid = sc.nextInt();
		
			if(fid == faculty.getFid() )
			{
				batch.setFaculty(faculty);
				batch.getBlist().add(batch);
				
			}
			
			
		}
		
	
	@Override
	public void viewBatch() {
	
	}
	@Override
	public void addStudent() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("Enter the student id: ");
		int sid = sc.nextInt();
		student.setSid(sid);
		
		System.out.println("Enter the student name: ");
		String sname = sc.next();
		student.setSname(sname);
		
		System.out.println("Enter the batch id: ");
		int bid = sc.nextInt();
		
			
			if(bid == batch.getBid())
			{
				student.setBatch(batch);
				student.getSlist().add(student);
				session.save(student);
				session.beginTransaction().commit();
			}
			
		}
	
	@Override
	public void viewStudent() {
		
	}
}
