package login.post.registartion;
import java.sql.*;

public class CustomerDAO {
	static Connection con;
	static PreparedStatement mystate;
	public Customer getCustomer(String userid,String passwd, String type) {
		Customer c = new Customer();
		c.setUserid(userid);
		c.setPassword(passwd);
		c.setType(type);
		try {
			con = ConnectionProvider.getConnection();
			if(type == "Student")
				mystate = con.prepareStatement("SELECT * from JobPost.Student WHERE UserID=? AND Password=?");
			else
				mystate = con.prepareStatement("SELECT * from JobPost.Company WHERE UserID=? AND Password=?");
			System.out.println(c.getUserid());
			mystate.setString(1, c.getUserid());
			mystate.setString(2, c.getPassword());
			
			ResultSet rs = mystate.executeQuery();
			if(!rs.next())
				return null;
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
			String t = cus.getType();
			if(t.charAt(0) == 'S') {
				mystate = con.prepareStatement("INSERT INTO JobPost.Student (UserID, Password) VALUES (?, ?)");
				System.out.println("Nigga");
			}
			else
				mystate = con.prepareStatement("INSERT INTO JobPost.Company (UserID, Password) VALUES (?, ?)");
			mystate.setString(1, cus.getUserid());
			mystate.setString(2, cus.getPassword());
			
			status = mystate.executeUpdate();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	public int setStudentDetails(Customer c) {
		int status = 0;
		try {
			con = ConnectionProvider.getConnection();
			mystate = con.prepareStatement("UPDATE JobPost.Student SET Email=?, FirstName=?, LastName=?, Region=?, Age=?, Post=?, Skills=? WHERE UserID=? AND Password=?");
			mystate.setString(1, StudentDetails.getEmail());
			mystate.setString(2, StudentDetails.getFirstname());
			mystate.setString(3, StudentDetails.getLastname());
			mystate.setString(4, StudentDetails.getRegion());
			mystate.setString(5, StudentDetails.getAge());
			mystate.setString(6, StudentDetails.getPost());
			mystate.setString(7, StudentDetails.getSkills());
			mystate.setString(8, c.getUserid());
			mystate.setString(9, c.getPassword());
			
			status = mystate.executeUpdate();
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
	public int setCompanyDetails(Customer c) {
		int status = 0;
		try {
			con = ConnectionProvider.getConnection();
			mystate = con.prepareStatement("UPDATE JobPost.Company SET Email=?, CompanyName=?, JobTitle=?, Location=?, Region=?, Descryprtion=?, Website=?, Logo=? WHERE UserID=? AND Password=?");
			mystate.setString(1, CompanyDetails.getEmail());
			mystate.setString(2, CompanyDetails.getCompanyname());
			mystate.setString(3, CompanyDetails.getJobtitle());
			mystate.setString(4, CompanyDetails.getLocation());
			mystate.setString(5, CompanyDetails.getRegion());
			mystate.setString(6, CompanyDetails.getDescryption());
			mystate.setString(7, CompanyDetails.getWebsite());
			if(CompanyDetails.getLogo() != null)
					mystate.setBlob(8, CompanyDetails.getLogo());
			mystate.setString(9, c.getUserid());
			mystate.setString(10, c.getPassword());
			
			status = mystate.executeUpdate();
			/*mystate = con.prepareStatement("INSERT INTO JobPost.Jobs (UserID, Email, CompanyName, JobTitle, Location, Region, Descryption, Website) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			mystate.setString(1, c.getUserid());
			mystate.setString(2, CompanyDetails.getEmail());
			mystate.setString(3, CompanyDetails.getCompanyname());
			mystate.setString(4, CompanyDetails.getJobtitle());
			mystate.setString(5, CompanyDetails.getLocation());
			mystate.setString(6, CompanyDetails.getRegion());
			mystate.setString(7, CompanyDetails.getDescryption());
			mystate.setString(8, CompanyDetails.getWebsite());
			status = mystate.executeUpdate();*/
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
	public void getStudentDetails(String userid) {
		try {
			con = ConnectionProvider.getConnection();
			mystate = con.prepareStatement("SELECT * from JobPost.Student WHERE UserID=?");
			mystate.setString(1, userid);
			ResultSet rr = mystate.executeQuery();
			while(rr.next()) {
				StudentDetails.setEmail(rr.getString("Email"));
				StudentDetails.setFirstname(rr.getString("FirstName"));
				StudentDetails.setLastname(rr.getString("LastName"));
				StudentDetails.setPost(rr.getString("Post"));
				StudentDetails.setAge(rr.getString("Age"));
				StudentDetails.setRegion(rr.getString("Region"));
				StudentDetails.setSkills(rr.getString("Skills"));
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
