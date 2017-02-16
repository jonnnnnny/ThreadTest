package test;
class Info
{
	private String name = "name";
	private String content = "content";
	private boolean flag = true;
	public synchronized void set(String name, String content)
	{
		while(!flag)
		{
			
				try
				{
					super.wait();
				}
				catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		this.setName(name);
		try
		{
			Thread.sleep(3000);
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setContent(content);
		flag = false;
		super.notify();
	}
	public synchronized void get()
	{
		while(flag)
		{
			try
			{
				super.wait();
			}
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try
		{
			Thread.sleep(300);
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(this.getName() + "-->" + this.getContent());
		flag = true;
		super.notify();
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getContent()
	{
		return content;
	}
	public void setContent(String content)
	{
		this.content = content;
	}
	
}

class Producer implements Runnable
{

	private Info info = null;
	public Producer(Info info)
	{
		this.info = info;
	}
	@Override
	public void run()
	{
		// TODO Auto-generated method stub
	
		boolean flag = true;
		for (int i = 0; i < 10; i++)
		{
			if (flag)
			{
				this.info.set("name--1", "content--1");
				flag = false;
			}else {
				this.info.set("name--2", "content--2");
				flag = true;
			}
		}
	}
}
class Consumer implements Runnable
{

	private Info info  = null;
	public Consumer(Info info)
	{
		this.info=info;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++)
		{
			this.info.get();
		}
	}
}
public class ThreadProvidor
{

	public static void main(String[] args)
	{
		Info info = new Info();
		Producer pro = new Producer(info);
		Consumer con = new Consumer(info);
		new Thread(pro).start();
		try
		{
			Thread.sleep(500);
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(con).start();
	}
}
