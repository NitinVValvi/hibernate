package com.client;

import java.util.Scanner;

import com.service.CJC;
import com.serviceImpl.Karvenagar;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CJC cjc = new Karvenagar();
		while(true)
		{
			System.out.print("Enter Choice:\n"+"1.Add Course: \n"+"2.view course"+"3.Add Faculty:\n"+"4.view faculty\n"
		+"5.Add Batch\n"+"6.view batch\n"+"7.Add Student\n"+"8.Display Student\n");
			int no = sc.nextInt();
			if(no!=9)
			switch(no)
				{
					case 1 : cjc.addcourse();
					break;
					
					case 2: cjc.viewcourse();
					break;
					
					case 3 : cjc.addfaculty();
					break;
					
					case 4 : cjc.viewfaculty();
					break;
					
					case 5 : cjc.addbatch();
					break;
					
					case 6 : cjc.viewbatch();
					break;
					
					case 7 : cjc.addstudent();
					break;
					case 8 : cjc.display();
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