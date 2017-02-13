package lock;

import java.io.Serializable;

public class MyObject implements Serializable{

	private static class MyObjectHandler{
		private static final MyObject myObject=new MyObject();
		
	}
	private MyObject(){
	}
	public static MyObject getInstance(){
		return MyObjectHandler.myObject;
	}
	protected Object readResolve() {
		System.out.println("readResolve");
		return MyObjectHandler.myObject;
		
	}
}
