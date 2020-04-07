package login.post.registartion;
import java.sql.*;

public class CustomerDAO {
	static Connection con;
	static PreparedStatement mystate;
	public Customer getCustomer(String userid,String passwd) {
		Customer c = new Customer();
		c.setUserid(userid);
		c.setPassword(passwd);
		try {
			con = ConnectionProvider.getConnection();
			mystate = con.prepareStatement("SELECT * from JobPost.Student WHERE UserID=? AND Password=?");
			System.out.println(c.getUserid());
			mystate.setString(1, c.getUserid());
			mystate.setString(2, c.getPassword());
			
			ResultSet rs = mystate.executeQuery();
			while(rs.next()) {
				c.setFirstname(rs.getString("FirstName"));
				c.setLastname(rs.getString("LastName"));
				c.setAge(rs.getString("Age"));
				c.setCollege(rs.getString("College"));
				c.setInterest1(rs.getString("Interest1"));
				c.setInterest2(rs.getString("Interest2"));
				c.setInterest3(rs.getString("Interest3"));
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return c;
	}
	public int setCustomer(Customer cus) {
		int status = 0;
		try {
			con = ConnectionProvider.getConnection();
			mystate = con.prepareStatement("INSERT INTO JobPost.Student (UserID, Password, FirstName, LastName, Age, College, Interest1, Interest2, Interest3) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
			mystate.setString(1, cus.getUserid());
			mystate.setString(2, cus.getPassword());
			mystate.setString(3, cus.getFirstname());
			mystate.setString(4, cus.getLastname());
			mystate.setString(5, cus.getAge());
			mystate.setString(6, cus.getCollege());
			mystate.setString(7, cus.getInterest1());
			mystate.setString(8, cus.getInterest2());
			mystate.setString(9, cus.getInterest3());
			
			status = mystate.executeUpdate();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
