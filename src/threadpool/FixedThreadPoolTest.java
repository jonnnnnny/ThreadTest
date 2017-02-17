package threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolTest
{

	public static void main(String[] args)
	{
//		ExecutorService executorService = Executors.newFixedThreadPool(3);
//		ExecutorService executorService = Executors.newSingleThreadExecutor();
		ExecutorService executorService = Executors.newScheduledThreadPool(3);
		for(int i=1;i<6;i++)
		{
			final int taskId = i;
			executorService.execute(new Runnable() {
				
				@Override
				public void run()
				{
					// TODO Auto-generated method stub
					for(int i=1;i<6;i++)
					{
						try
						{
							Thread.sleep(20);
						}
						catch (InterruptedException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("第"+ taskId + "次任务的第" + i + "次执行");
					}
					
				}
			});
		}
		executorService.shutdown();
	}
}
