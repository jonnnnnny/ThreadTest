package threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest
{

	public static void main(String[] args)
	{

		ThreadPoolExecutor executor = 
				new ThreadPoolExecutor(5, 20, 200, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));
		for(int i=0;i<15;i++)
		{
			MyTask myTask = new MyTask(i);
			executor.execute(myTask);
			System.out.println("�̳߳����߳���Ŀ��"+ executor.getPoolSize()+ ","
					+ "���еȴ�ִ�е�������Ŀ��" + executor.getQueue().size()
					+ ",��ִ�е�������Ŀ��"+ executor.getCompletedTaskCount());
		}
		executor.shutdown();
	}
}
class MyTask implements Runnable
{
	private int taskNum;
	
	public MyTask(int num)
	{
		this.taskNum=num;
	}
	@Override
	public void run()
	{
		// TODO Auto-generated method stub
	
		System.out.println("execute task" + taskNum);
		try
		{
			Thread.currentThread().sleep(4000);
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("task "+ taskNum + " executed");
	}
}