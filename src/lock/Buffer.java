package lock;

import java.util.concurrent.locks.ReentrantLock;

public class Buffer
{

	private Object lock;
	private ReentrantLock lock2 = new ReentrantLock();
	public Buffer()
	{
	
		lock=this;
		// TODO Auto-generated constructor stub
	}
	public void write()
	{
//		synchronized (lock)
		lock2.lock();
		try{
		
			long startTime = System.currentTimeMillis();
			System.out.println("begin write data.");
			for(;;)
			{
				if (System.currentTimeMillis()-startTime > Integer.MAX_VALUE)
				{
					break;
				}
			}
			System.out.println("end.");
		}finally
		{
			lock2.unlock();
		}
	}
	public void read() throws InterruptedException
	{
//		synchronized (lock)
		lock2.lockInterruptibly();
		try{
		
			System.out.println("read data.");
		}finally{
			
			lock2.unlock();
		}
	}
	public static void main(String[] args)
	{
		Buffer buffer = new Buffer();
		final Writer writer = new Writer(buffer);
		final Reader reader = new Reader(buffer);
		
		writer.start();
		reader.start();
		new Thread(new Runnable() {
			
			@Override
			public void run()
			{
				// TODO Auto-generated method stub
				long start = System.currentTimeMillis();
				for(;;)
				{
					if (System.currentTimeMillis() - start >5000)
					{
						System.out.println("try interrupt();");
						reader.interrupt();
						break;
					}
				}
			}
		}).start();
	}
}
class Writer extends Thread
{

	private Buffer buffer;
	public Writer(Buffer buffer)
	{
		this.buffer = buffer;
	}
	
	@Override
	public void run()
	{
		buffer.write();
		
	}
}

class Reader extends Thread
{

	private Buffer buffer;
	
	public Reader(Buffer buffer){
		this.buffer = buffer;
	}
	
	@Override
	public void run()
	{
		// TODO Auto-generated method stub
	try
	{
		buffer.read();
		
	}
	catch (Exception e)
	{
		System.out.println("not read");
		// TODO: handle exception
	}
	System.out.println("read end.");
		
	}
}
