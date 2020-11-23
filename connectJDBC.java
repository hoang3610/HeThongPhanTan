package lamquenvoi_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class connectJDBC {
	public static List<Student> findAll() {
		String url = "jdbc:sqlserver://LAPTOP-0k646lsv\\SQLEXPRESS2012;databasename=sinhvien;";
		String username = "sa";
		String password = "hoang123";
		Statement statement = null;
		Connection connection = null;
		List<Student> liStudents = new ArrayList<>();
        
        try {
            //lay tat ca danh sach sinh vien 
        	connection = DriverManager.getConnection(url, username, password);
        	System.out.println("ket noi thanh cong");
        	
//            //query
            String sql = "select * from sinhvien";
            statement = connection.createStatement();
//            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {                
            	Student student = new Student(resultSet.getString("id"), resultSet.getString("name"), resultSet.getString("age"));
				liStudents.add(student);
            }
        } catch (SQLException ex) {
            System.out.println("loi khong ket noi duoc den database");
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                	System.out.println("loi");
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                	System.out.println("loi");
                }
            }
        }
        //ket thuc.
        
        return liStudents;
    }
	
	public static List<Student> findbyName(String name) {
		String url = "jdbc:sqlserver://LAPTOP-0K646LSV\\SQLEXPRESS2012;databasename=sinhvien;";
		String username = "sa";
		String password = "hoang123";
		PreparedStatement preparedStatement = null;
		Connection connect = null;
		List<Student> liStudents = new ArrayList<>();
		try {
			connect = DriverManager.getConnection(url, username, password);
			System.out.println("start connect");
			String sql = "SELECT * FROM SINHVIEN where name like ?";
			preparedStatement = connect.prepareCall(sql);
			preparedStatement.setString(1, "%"+name+"%");
			ResultSet rs = preparedStatement.executeQuery();
//			if(rs.next()==false)
//			{
//				System.out.println("khong co data");
//			}
			while (rs.next()) {
					Student student = new Student(rs.getString("id"), rs.getString("name"), rs.getString("age"));
					liStudents.add(student);
				
			}
			
		} catch (SQLException e) {	
			// TODO Auto-generated catch block
			System.out.println("error");
			e.printStackTrace();
		}finally {
			try {
				if(connect != null)
				{
					connect.close();
				}
				if(preparedStatement != null)
				{
					preparedStatement.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        //ket thuc.
        
        return liStudents;
    }
	
//	public static List<Student> findbyName(String name) {
//		String url = "jdbc:sqlserver://LAPTOP-0K646LSV\\SQLEXPRESS2012;databasename=sinhvien;";
//		String username = "sa";
//		String password = "hoang123";
//		PreparedStatement preparedStatement = null;
//		Connection connect = null;
//		List<Student> liStudents = new ArrayList<>();
//		try {
//			connect = DriverManager.getConnection(url, username, password);
//			System.out.println("start connect");
//			String sql = "SELECT * FROM SINHVIEN where name like ?";
//			preparedStatement = connect.prepareCall(sql);
//			preparedStatement.setString(1, "%"+"hoang"+"%");
//			ResultSet rs = preparedStatement.executeQuery();
////			if(rs.next()==false)
////			{
////				System.out.println("khong co data");
////			}
//			while (rs.next()) {
//					Student student = new Student(rs.getString("id"), rs.getString("name"), rs.getString("age"));
//					liStudents.add(student);
//				
//			}
//			
//		} catch (SQLException e) {	
//			// TODO Auto-generated catch block
//			System.out.println("error");
//			e.printStackTrace();
//		}finally {
//			try {
//				if(connect != null)
//				{
//					connect.close();
//				}
//				if(preparedStatement != null)
//				{
//					preparedStatement.close();
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		System.out.println("size " + liStudents.size());
////		liStudents.contains("")
////		Student st = new Student("2", "hoang", "18");
//		for (Student student : liStudents) {
//			String a = "hoang";
//			if (student.getName()!= null && student.getName().contains(a)) {
//				System.out.println(student.name);
//			}
//			else {
//				System.out.println("khong thay sinh vien do");
//			}
//		}
//	}
}
