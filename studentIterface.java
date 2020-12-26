package lamquenvoi_jdbc;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface studentIterface extends Remote {
	public List<Student> ShowListStudent() throws RemoteException;
	public void insert(Student std) throws RemoteException;
	public void delete(String id) throws RemoteException;
}
