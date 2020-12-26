package lamquenvoi_jdbc;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Server {
	public static void main(String[] args) {
		System.out.println("server dang chay");
		try {
			LocateRegistry.createRegistry(8888);
			ManageStd manageStuList = new ManageStd();
			UnicastRemoteObject.exportObject(manageStuList, 8888);
			Naming.bind("rmi://localhost:8888/MyProject", manageStuList);
		} catch (Exception e) {
			System.out.println("loi"+ e.getMessage());
		}
	}

}
