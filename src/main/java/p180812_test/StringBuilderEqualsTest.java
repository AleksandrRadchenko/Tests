package p180812_test;

import java.util.Set;
import java.util.TreeSet;

public class StringBuilderEqualsTest
{
	public static void main(String[] args) throws InterruptedException
	{
//		stringEqualsTest();
//		runMe();
//		threadTest();
		treeSetTest();
	}
	
	static void stringEqualsTest() {
		String s = "Hello";
		StringBuilder builder1 = new StringBuilder("Hello");
		StringBuilder builder2 = new StringBuilder("Hello");
//		System.out.println(s == builder1);
		System.out.println(builder1 == builder2);
	}
	
	static void runMe() {
		System.out.println("Abc:");
		http://www.ya.ru
		return;
	}
	
	static void threadTest() throws InterruptedException {
		Thread thread = new Thread(() -> System.out.print("Thread end."));
		
		synchronized (thread)
		{
			thread.start();
			thread.wait();
		}
		
		System.out.print("Main end.");
	}
	
	static void treeSetTest() {
		Set<Number> set = new TreeSet<Number>();
		set.add(1);
		set.add(1L);
		set.add(1.0);
		System.out.println(set.size());
	}
}
