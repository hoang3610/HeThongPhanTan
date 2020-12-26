package lamquenvoi_jdbc;

import java.awt.Menu;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		menu();
	}

	public static void menu() throws MalformedURLException, RemoteException, NotBoundException {
		Scanner sc = new Scanner(System.in);
		int chon;
		studentIterface manage = (studentIterface) Naming.lookup("rmi://localhost:8888/MyProject");

		do {
			System.out.println("1. xem thong tin sinh vien");
			System.out.println("2. Them sinh vien");
			System.out.println("3. Xóa sinh vien");
			System.out.println("4. Sửa thông tin sinh vien");
			System.out.println("5. Thoát chương trình");
			System.out.println("===============================");
			System.out.println("chon so tu [1-4]");
			chon = sc.nextInt();
			switch (chon) {
			case 1:
				System.out.println("                     Xem thong tin sinh vien                   ");

				List<Student> list = manage.ShowListStudent();
				System.out.println(list.size());
				for (Student student : list) {
					System.out.println("Ten: " + student.name + "id: " + student.id + "age: " + student.age);
				}
				break;
			case 2:
				sc.nextLine();
				System.out.println("                     Them thong tin sinh vien                   ");
				System.out.println("nhap vao id:");
				String id = sc.nextLine();
				System.out.println("nhap vao ten:");
				String name = sc.nextLine();
				System.out.println("nhap vao tuoi:");
				String age = sc.nextLine();
				Student std = new Student(id, name, age);
				manage.insert(std);
			case 3:
				sc.nextLine();
				System.out.println("                    Xóa sinh vien                               ");
				System.out.println("nhap vao id can xoa:");
				String idDelete = sc.nextLine();
				for (Student student : manage.ShowListStudent()) {
					if (student.getId().contains(idDelete)) {
						manage.delete(idDelete);
						System.out.println("da xoa");
					}
				}
				break;
			default:
				break;
			}
		} while (chon != 5);
	}
}
