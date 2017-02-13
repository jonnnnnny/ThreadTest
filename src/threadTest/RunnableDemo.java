package threadTest;

public class RunnableDemo {
public static void main(String[] args) {
	myThread m=new myThread();
//	Thread m1=new Thread(m);
//	Thread m2=new Thread(m);
//	Thread m3=new Thread(m);
//	m1.start();
//	m2.start();
//	m3.start();
	new Thread(m).start();
	new Thread(m).start();
	new Thread(m).start();
}
}
class myThread implements Runnable{
	private int ticket = 10;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			
			if(ticket>0){
				System.out.println(Thread.currentThread().getName()+ "ticket= "+ ticket--);
			}
		}
	}
}
