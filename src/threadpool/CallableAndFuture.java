package threadpool;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableAndFuture
{

	public static void main(String[] args)
	{
		Callable<Integer> callable = new Callable<Integer>() {

			@Override
			public Integer call() throws Exception
			{
				// TODO Auto-generated method stub
				return new Random().nextInt(100);
			}
		};
		FutureTask<Integer> future = new FutureTask<>(callable);
		new Thread(future).start();
		try
		{
			Thread.sleep(5000);
			System.out.println(future.get());
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ExecutionException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
