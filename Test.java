package Thread;

import java.io.File;

public class Test {
public static void main(String[] args) {
	File file = new File("D:\\OnlyforEclipse_JAVA\\fileTxt\\testFile.txt");
	File file2 = new File("D:\\OnlyforEclipse_JAVA\\fileTxt\\testFile2.txt");
	System.out.println(file.getName());
	ThreadOne threadOne = new ThreadOne(file);
	Thread t = new Thread(threadOne);
	ThreadOne threadTwo = new ThreadOne(file2);
	Thread t2 = new Thread(threadTwo);
	
	System.out.println("Ten thread: " + t.getName() + " - tenFile: " + file.getName());
	System.out.println("Ten thread: " + t2.getName() + " - tenFile: " + file2.getName());
	
	//sau khi copy
	
	t.start();
	try {
		t.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	t2.start();
//	System.out.println(t2.getName());
	
	
}
}
