package threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class TestCachedThreadPool
{

	public static void main(String[] args)
	{
		ExecutorService executorService = Executors.newCachedThreadPool();
//		ExecutorService executorService = Executors.newFixedThreadPool(5);
//		ExecutorService executorService = Executors.newSingleThreadExecutor();
//		ExecutorService executorService = Executors.newScheduledThreadPool(3);
		for(int i=0;i<10;i++)
		{
			executorService.execute(new TestRunnable());
			System.out.println("********a" + i + "*******");
		}
		executorService.shutdown();
	}
}
class TestRunnable implements Runnable
{

	@Override
	public void run()
	{
	
		System.out.println(Thread.currentThread().getName()+"线程被调用了.");
		// TODO Auto-generated method stub
		
	}
}
