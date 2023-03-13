package com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
//import java.util.function.Consumer;

//class ConsImpl implements Consumer<Integer>
//{
//	public void accept(Integer i) 
//	{
//		System.out.println(i);
//	}
//	
//}
public class DemoForEach {
	public static void main(String[] args) {
	//	Consumer<T>
		
		List<Integer> values = new ArrayList<Integer>();
		values.add(4);
		values.add(5);
		values.add(7);
		values.add(8);
		values.add(9);
		/*
		 * for (int i = 0; i < values.size(); i++) { System.out.println(values.get(i));
		 * 
		 * } for (int integer : values) { System.out.println(integer); }
		 */
	//	values.forEach(i -> System.out.println(i));//lambda //takes object of consumer
		//Consumer<Integer> c = i->System.out.println(i);
			
		
	//	values.forEach(i->System.out.println(i));//consumer interface
	
	//Stream demo even list using filter and stream method
//		Stream<Integer> s = values.stream().filter(i -> i%2 == 0);
//		s.forEach(x -> System.out.println(x));
		
		//stream single line
		System.out.println("filter the object to even/odd");
		values.stream().filter(i -> i%2 ==0).forEach(x -> System.out.println(x));
	
		//stream map()
		System.out.println("mapped objects ");
		Stream<Integer> s = values.stream().map(i -> i*i);
		s.forEach(x -> System.out.println(x));
	
	//stream mapped object single line code
		System.out.println("stream mapped object single line code");
		values.stream().map(i -> i*i).forEach(x -> System.out.println(x));
	}
}
