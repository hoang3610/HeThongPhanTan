package lamquenvoi_jdbc;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ManageStd implements studentIterface {
	@Override
	public List<Student> ShowListStudent() throws RemoteException {
		// TODO Auto-generated method stub

		String url = "jdbc:sqlserver://LAPTOP-0k646lsv\\SQLEXPRESS2012;databasename=sinhvien;";
		String username = "sa";
		String password = "hoang123";
		Statement statement = null;
		Connection connection = null;
		List<Student> liStudents = new ArrayList<>();

		try {
			try {
				// lay tat ca danh sach sinh vien
				connection = DriverManager.getConnection(url, username, password);
				System.out.println("ket noi thanh cong");

//	            //query
				String sql = "select * from sinhvien";
				statement = connection.createStatement();
//	            
				ResultSet resultSet = statement.executeQuery(sql);

				while (resultSet.next()) {
					Student student = new Student(resultSet.getString("id"), resultSet.getString("name"),
							resultSet.getString("age"));
					liStudents.add(student);
				}
			} catch (SQLException ex) {
				System.out.println("loi khong ket noi duoc den database");
			}
		} catch (Exception e) {
			System.out.println("loi " + e.getMessage());
		}

		// ket thuc.

		return liStudents;
	}

	@Override
	public void insert(Student std) throws RemoteException {
		Connection connection = null;
		PreparedStatement statement = null;
		String url = "jdbc:sqlserver://LAPTOP-0K646LSV\\SQLEXPRESS2012;databasename=sinhvien;";
		String username = "sa";
		String password = "hoang123";
		try {
			// lay tat ca danh sach sinh vien
			connection = DriverManager.getConnection(url, username, password);

			// query
			String sql = "insert into Sinhvien(id,name,age) values(?, ?, ?)";
			statement = connection.prepareCall(sql);

			statement.setString(1, std.getId());
			statement.setString(2, std.getName());
			statement.setString(3, std.getAge());

			statement.execute();
		} catch (SQLException ex) {
			System.out.println("error " + ex.getMessage());
		}
		// ket thuc.
	}

	@Override
	public void delete(String id) throws RemoteException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
		String url = "jdbc:sqlserver://LAPTOP-0K646LSV\\SQLEXPRESS2012;databasename=sinhvien;";
		String username = "sa";
		String password = "hoang123";
		try {
			// lay tat ca danh sach sinh vien
			connection = DriverManager.getConnection(url, username, password);
			// query
			String sql = "delete from sinhvien where id = ?";
			statement = connection.prepareCall(sql);

			statement.setString(1, id);

			statement.execute();
		} catch (SQLException ex) {
			System.out.println("error" + ex.getMessage());
		}
	}

}
