package lamquenvoi_jdbc;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class server {

	public static void main(String[] args) {
		FileOutputStream fileOutputStream = null;

	    Scanner sc = new Scanner(System.in);
	    DataInputStream dataInputStream = null;
	    DataOutputStream dataOutputStream = null;
	    Socket s= null;

	    try {
	        System.out.println("sever starting..................");
	        ServerSocket serverSocket = new ServerSocket(6666);
	        s= serverSocket.accept();

	        dataInputStream = new DataInputStream(s.getInputStream());
	        dataOutputStream = new DataOutputStream(s.getOutputStream());
	        // TODO Auto-generated method stub
	        List<Student> listStudenTest = new ArrayList<>();
	        List<Student> listStudenTest1 = new ArrayList<>(5);
//	        System.out.println(listStudenTest);
	        listStudenTest1 = connectJDBC.findAll();
	        List<Student> listStuden = new ArrayList<>();
	        listStuden = connectJDBC.findAll();
//	        for (Student student : listStuden) {
//	        	System.out.println(student.name + "abcd" +  "      " + student.age);
//	        	
//	        }
//	        System.out.println("size " + liStudents.size());
////		liStudents.contains("")
////		Student st = new Student("2", "hoang", "18");
//	        String a = "hoang";
//		for (Student student : connectJDBC.findbyName(a)) {
//			
//			System.out.println(student.toString());
//		}
	        System.out.println(connectJDBC.findbyName("nam"));
//	        System.out.println(listStudenTest1.get(1));
//	        for (Student student : listStudenTest1) {
//	        	
//	        	System.out.println(student.name + "abcd" +  "      " + student.age);
//	        	
//	        }
	        
	        
	        if(connectJDBC.findbyName("hoang").size()==listStudenTest.size())
	        {
	        	System.out.println("khong co sinh vien do");
	        	for (int i = 0; i < 5; i++) {
					System.out.println(listStudenTest1.get(i).name);
				}
	        }
	        else
	        {
	        	for (Student student : connectJDBC.findbyName("hoang")) {
		        	System.out.println(student.name + "abcd" +  "      " + student.age);
//		        	
		        }
	        }
	        /* chat socket */
	        while(true)
	        {
	            String str = dataInputStream.readUTF();
	            if(str.equals("q"))
	            {
	                break;
	            }
	            System.out.println("client noi: " + str);
	       /* truyen du lieu */
	            String str2 = sc.nextLine();
	            dataOutputStream.writeUTF(str2);
	            dataOutputStream.flush();
	        }
	        /* Đóng kết nối */
	        dataInputStream.close();
	        dataOutputStream.close();
//	        s.close();
	        
	    } catch (Exception e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }finally {
	        if(fileOutputStream != null)
	        {
	            try {
	                fileOutputStream.close();
	            } catch (Exception e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }
	        if(s != null)
	        {
	            try {
	                s.close();
	            } catch (Exception e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }
	    }
	}

}
