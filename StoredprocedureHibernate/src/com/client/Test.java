package com.client;

import java.util.Scanner;

import com.service.StudentService;
import com.serviceImpl.StudentServiceImpl;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentService stus = new StudentServiceImpl();
		while(true)
		{
			System.out.print("Enter choice \n"+"1.to save data" +"\n2.to update data"+"\n3.to delete data"+"\n4.to select data");
			int n = sc.nextInt();
			if(n!=5)
			switch(n)
			{
			case 1: stus.insert();
			break;
			case 2: stus.update();
			break;
			case 3: stus.delete();
			break;
			case 4: stus.select();
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
