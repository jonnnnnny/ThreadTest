package threadpool;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SchedulePoolTest
{

	public static void main(String[] args)
	{
		ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
		executorService.schedule(new Runnable() {
			
			@Override
			public void run()
			{
				// TODO Auto-generated method stub
				System.out.println("boom!");
			}
		}, 5,TimeUnit.SECONDS );
		executorService.scheduleAtFixedRate(new Runnable() {
			
			@Override
			public void run()
			{
				// TODO Auto-generated method stub
				System.out.println("haha");
			}
		}, 5, 2, TimeUnit.SECONDS);
	}
}
