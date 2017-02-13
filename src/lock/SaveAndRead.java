package lock;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SaveAndRead {

	public static void main(String[] args) {
		try {
			MyObject myObject=MyObject.getInstance();
			FileOutputStream fos=new FileOutputStream(new File("D:/java/myObjectFile.txt"));
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(myObject);
			oos.close();
			fos.close();
			System.out.println(myObject.hashCode());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FileInputStream fis;
		try {
			fis = new FileInputStream(new File("D:/java/myObjectFile.txt"));
			ObjectInputStream ois=new ObjectInputStream(fis);
			MyObject myObject=(MyObject) ois.readObject();
			ois.close();
			fis.close();
			System.out.println(myObject.hashCode());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
