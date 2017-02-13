package threadTest;

public class Servicesync {

	public static void main(String[] args) {
		service service=new service();
		Thread3 thread1=new Thread3(service);
		Thread2 thread2=new Thread2(service);
		Thread t1=new Thread(thread1);
		Thread t2=new Thread(thread2);
		t1.setName("a");
		t2.setName("b");
		t1.start();
		t2.start();
		System.out.println();
	}
}
class service{
	private String name;
	private String password;
	public void setNamePassoword(String name, String password) {
			try {
				 String anyString=new String();
				synchronized (anyString) {
					System.out.println("ThreadName: "+Thread.currentThread().getName()+" time:" + System.currentTimeMillis());
					this.name=name;
				Thread.sleep(2000);
				this.password=password;
				System.out.println("ThreadName: "+Thread.currentThread().getName()+" time:" + System.currentTimeMillis());
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
}
class Thread3 implements Runnable{
	private service service;
	public Thread3(service service) {
		// TODO Auto-generated constructor stub
		this.service=service;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		service.setNamePassoword("a", "aa");
		
	}
}
class Thread2 implements Runnable{
	private service service;
	public Thread2(service service) {
		// TODO Auto-generated constructor stub
		this.service=service;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		service.setNamePassoword("b", "bb");
		
	}
}