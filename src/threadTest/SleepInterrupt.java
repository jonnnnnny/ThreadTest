package threadTest;

import java.util.Arrays;
import java.util.Stack;

public class SleepInterrupt implements Runnable{
@Override
public void run() {
// TODO Auto-generated method stub
	System.out.println("in Run()-about to sleepfor 20 seconds");
	try {
		Thread.sleep(20000);
		System.out.println("in Run()- woke up ");
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("in run() - interrupt while sleeping");
		return;
	}
	System.out.println("in run() - leaving normally");
}
public static void main(String[] args) {
	String string="in run() - leaving normally";
	String[] s=string.split(" ");
	System.out.println(Arrays.toString(s));
	
}
	
}
