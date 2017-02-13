package threadTest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class YieldTest {
	public static void main(String[] args) {
		Thread t=new Thread(new Thread1());
		t.start();
		Queue<Integer> q=new LinkedList<>();
		q.isEmpty();
		
	}

}
class Thread1 implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
	
		long beginTime=System.currentTimeMillis();
		int count=0;
		for(int i=0;i<1000000;i++){
		Thread.yield();
			count=count+(i+1);
		}
		long endTime=System.currentTimeMillis();
		System.out.println("Time: "+ (endTime-beginTime)+" count= "+count);
	}
}
