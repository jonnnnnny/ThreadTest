package test;

import java.util.HashMap;
import java.util.Map;

public class Singleton {

	private static Singleton instance;
	private Singleton() {
		// TODO Auto-generated constructor stub
	}
	public static  Singleton getInstance() {
		if (instance==null) {
			instance=new Singleton();
		}
		return instance;
	}
	public Object readResolve() {
		return instance;
	}
	public static void main(String[] args) {
		Thread run1=new Thread(new runThread());
		Thread run2=new Thread(new runThread());
		run1.start();
		run2.start();
		
	}
}
class runThread implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
	
		System.out.println(Singleton.getInstance().hashCode());
	}
}
