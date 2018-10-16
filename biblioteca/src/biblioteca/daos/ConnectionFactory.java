package biblioteca.daos;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class ConnectionFactory {
	
	private static Connection con = null;
	private static final String banco = "biblioteca";
	private static final String user = "root";
	private static final String password = "lab02";
	
	public static Connection getConnection() {
		if (con == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = (Connection) DriverManager.getConnection
						("jdbc:mysql://localhost/" + banco, user, password);
			} catch (SQLException | ClassNotFoundException e){
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return con;
	}
}
