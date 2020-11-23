package lamquenvoi_jdbc;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.net.Socket;
import java.util.Scanner;
public class client {
public static void main(String[] args) {
	 try {
         System.out.println("client startingggg......");
         Socket s = new Socket("localhost",6666);
         DataOutputStream dataOutputStream = new DataOutputStream(s.getOutputStream());
         DataInputStream dataInputStream = new DataInputStream(s.getInputStream());
         //ghi du lieu
         Scanner sc = new Scanner(System.in);
         try {
        	 /* chat socket */
             while(true)
             {
                 String str = sc.nextLine();
                 dataOutputStream.writeUTF(str);
                 dataOutputStream.flush();
                 if(str.equals("q"))
                 {
                     break;
                 }
                 String str2 = dataInputStream.readUTF();
                 System.out.println("server noi: " + str2);
             }
         } catch (Exception e) {
             System.out.println("loi");
         }finally{
             
         } 
         dataInputStream.close();
         dataOutputStream.close();
         s.close();
     } catch (Exception e) {
         System.out.println("khong ket noi duoc");
     }
}
}
