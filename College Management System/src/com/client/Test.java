package com.client;

import java.util.Scanner;

import com.service.Cjc;
import com.serviceImpl.Karvenagar;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Cjc cjc = new Karvenagar();
		while(true)
		{
			System.out.print("Enter Choice:\n"+"1.Add Course: \n"+"2.Display Course:\n"+"3.Add Faculty:\n"+"4.Display Faculty\n"+
		"5.Add Batch\n"+"6.Display Batch\n"+"7.Add Student\n"+"8.Display Student\n");
			int no = sc.nextInt();
			if(no!=9)
			switch(no)
				{
					case 1 : cjc.addCourse();
					break;
					case 2 : cjc.viewCourse();
					break;
					case 3 : cjc.addFaculty();
					break;
					case 4 : cjc.viewFaculty();
					break;
					case 5 : cjc.addBatch();
					break;
					case 6 : cjc.viewBatch();
					break;
					case 7 : cjc.addStudent();
					break;
					case 8 : cjc.viewStudent();
					break;
				}
				else
				{
					System.out.println("Exit");
					sc.close();
					return;
				}
		}
	}
}
