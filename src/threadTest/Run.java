package threadTest;

public class Run {

	public static void main(String[] args) {
		HasSelfPrivateNum hasSelfPrivateNum=new HasSelfPrivateNum();
		Thread a=new Thread(new T1(hasSelfPrivateNum));
		Thread b=new Thread(new T2(hasSelfPrivateNum));
		a.start();
		b.start();
		
	}
}
class HasSelfPrivateNum{
	private int num=0;
	synchronized public void addI(String name) {
		if (name.equals("a")) {
			num=100;
			System.out.println("a set over");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			num=200;
			System.out.println("b set over");
		}
		System.out.println(name+" num="+num);
	}
}
class T1 implements Runnable{
	public HasSelfPrivateNum hasSelfPrivateNum;
	public T1(HasSelfPrivateNum hasSelfPrivateNum){
		this.hasSelfPrivateNum=hasSelfPrivateNum;
	}
	public void run() {
		hasSelfPrivateNum.addI("a");
	}
}
class T2 implements Runnable{
	public HasSelfPrivateNum hasSelfPrivateNum;
	public T2(HasSelfPrivateNum hasSelfPrivateNum){
		this.hasSelfPrivateNum=hasSelfPrivateNum;
	}
	public void run() {
		hasSelfPrivateNum.addI("b");
	}
	
}
