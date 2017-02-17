package threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo
{

	public static void main(String[] args)
	{
		ExecutorService executorService = Executors.newCachedThreadPool();
		List<Future<String> > resultList = new ArrayList<>();
		for(int i=0;i<10;i++)
		{
			Future<String> future = executorService.submit(new TaskWithresult(i));
			resultList.add(future);
		}
		
		for (Future<String> future : resultList)
		{
			try
			{
					while(!future.isDone());
					
					System.out.println(future.get());
			}
			catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally
			{
				executorService.shutdown();
			}
		}
		
	}
}
class TaskWithresult implements Callable<String>
{

	private int id;
	
	public TaskWithresult(int id)
	{
		this.id= id;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String call() throws Exception
	{
		System.out.println("call() method " + Thread.currentThread().getName());
		// TODO Auto-generated method stub
		return "call()方法被自动调用，返回结果：" + id +"  " +Thread.currentThread().getName();
	}
}
