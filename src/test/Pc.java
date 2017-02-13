package test;

import java.util.Stack;

import test.PublicClass.PrivateClass;

public class Pc {

	public static void main(String[] args) {
		PublicClass publicClass=new PublicClass();
		publicClass.setUsername("hello");
		publicClass.setPassword("world");
		PrivateClass privateClass=publicClass.new PrivateClass();
		privateClass.setAddress("111");
		privateClass.setAge("18");
		System.out.println(publicClass.toString());
		System.out.println(privateClass.toString());
		Stack<Integer> stack=new Stack<>();
		int min=Integer.MIN_VALUE;
	}
}
