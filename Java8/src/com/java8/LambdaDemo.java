package com.java8;

interface A
{
	void show();
}
//class B implements A
//{
//
//	@Override
//	public void show() {
//		System.out.println("Nitin");
//		
//	}
//
//}
public class LambdaDemo {
	public static void main(String[] args) 
	{
		A obj ;
//		obj = new B();
//		obj.show();
		//  whenever  implementation 
		//we need 3 things method name method parameters and implementation
//		obj = new A() //Anonymous Inner class
//				{
//				public void show()
//					{
//						System.out.println("NITIN");
//					}
//				};
//			obj.show();
		
		obj = () ->System.out.println("Nitin");
		
		obj.show();
		
	}
}
