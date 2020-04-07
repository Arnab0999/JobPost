package login.post.registartion;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider implements Provider {
	static Connection con = null;
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(dbURL,username,password);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return con;
	}
}
