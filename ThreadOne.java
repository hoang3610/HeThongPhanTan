package Thread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ThreadOne implements Runnable {
	File file;
	FileInputStream fileInputStream = null;
	FileOutputStream fileOutputStream = null;
	DataInputStream dataInputStream = null;
	DataOutputStream dataOutputStream = null;
	public ThreadOne(File file) {
		this.file = file;
	}
	
	@Override
	public void run() {
		if(Thread.currentThread().getName().equals("Thread-0")) {
			try {
				fileInputStream = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dataInputStream = new DataInputStream(fileInputStream);
			try {
				fileOutputStream = new FileOutputStream("D:\\OnlyforEclipse_JAVA\\fileTxt\\testFile-copy.txt");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			dataOutputStream= new DataOutputStream(fileOutputStream);
			try {
				String str = dataInputStream.readLine();
				
				//ghi du lieu vao file copy
			dataOutputStream.writeUTF(str);
			System.out.println(Thread.currentThread().getName() + "- TenFile: " + "D:\\\\OnlyforEclipse_JAVA\\\\fileTxt\\\\testFile-copy.txt");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				
			}
		}
		
		else if (Thread.currentThread().getName().equals("Thread-1"))
		{
			try {
				fileInputStream = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dataInputStream = new DataInputStream(fileInputStream);
			try {
				fileOutputStream = new FileOutputStream("D:\\OnlyforEclipse_JAVA\\fileTxt\\testFile-copy_2.txt");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			dataOutputStream= new DataOutputStream(fileOutputStream);
			try {
				String str = dataInputStream.readLine();
				
				//ghi du lieu vao file copy
			dataOutputStream.writeUTF(str);
			System.out.println(Thread.currentThread().getName() + "- TenFile: " + "D:\\\\OnlyforEclipse_JAVA\\\\fileTxt\\\\testFile-copy_2.txt");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				
			}
		}
		
	}
	
	
	
	

}
