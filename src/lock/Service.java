package lock;

import java.util.concurrent.locks.ReentrantLock;

public class Service {
private ReentrantLock lock=new ReentrantLock();
public void serviceMethod1() {
	try {
		lock.lock();
		System.out.println("serviceMethod1 getHoldCount=" + lock.getHoldCount());
		serviceMethod2();
		System.out.println("after lock..");
	} catch (Exception e) {
		// TODO: handle exception
	}finally {
		lock.unlock();
	}
	
}
public void serviceMethod2() {
	try {
		
		lock.lock();
		System.out.println("serviceMethod2 getHoldCount= " + lock.getHoldCount());
		System.out.println("after lock2..");
	} 
	finally {
		lock.unlock();
	}
}
public static void main(String[] args) {
	Service service=new Service();
	service.serviceMethod1();
}
}
