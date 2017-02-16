package test;

import java.util.Vector;

public class SingletonTest
{

	private static SingletonTest instance = null;
	private Vector properties = null;
	
	public Vector getProperties()
	{
	
		return properties;
	}
	
	private SingletonTest()
	{
		// TODO Auto-generated constructor stub
	}
	
	private static synchronized void syncInit()
	{
		if (instance == null)
		{
			instance = new SingletonTest();
		}
	}
	
	public static SingletonTest getInstance()
	{
		if (instance == null)
		{
			syncInit();
		}
		return instance;
	}
	
	public void updateProperties()
	{
		SingletonTest shadow = new SingletonTest();
		properties = shadow.getProperties();
	}
	
	public static void main(String[] args) {
		Thread run1=new Thread(new runThread1());
		Thread run2=new Thread(new runThread1());
		run1.start();
		run2.start();
	}
}
class runThread1 implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
	
		System.out.println(SingletonTest.getInstance().hashCode());
	}
}