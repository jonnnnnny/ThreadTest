package threadTest;

import java.util.concurrent.atomic.AtomicInteger;

public class AddCountTest extends Thread{
	private AtomicInteger count=new AtomicInteger(0);
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<10000;i++){
			System.out.println(count.incrementAndGet());
		}
	}

}
