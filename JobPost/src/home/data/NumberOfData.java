package home.data;
import login.post.registartion.*;
import java.sql.*;

public class NumberOfData {
	static Connection con;
	static PreparedStatement mystate;
	static String data;
	public String getStudentNumber() {
		try {
			int count = 0;
			con = ConnectionProvider.getConnection();
			mystate = con.prepareStatement("SELECT * from JobPost.Student");
			ResultSet rs = mystate.executeQuery();
			while(rs.next()) {
				count++;
			}
			data = Integer.toString(count);
			System.out.print(data);
		}
		catch(Exception e) {
			System.out.print(e);
		}
		return data;
	}
	public String getCompanyNumber() {
		try {
			int count = 0;
			con = ConnectionProvider.getConnection();
			mystate = con.prepareStatement("SELECT * from JobPost.Company");
			ResultSet rs = mystate.executeQuery();
			while(rs.next()) {
				++count;
			}
			data = Integer.toString(count);
			System.out.print(data);
		}
		catch(Exception e) {
			System.out.print(e);
		}
		return data;
	}
	public String getApplications() {
		try {
			int count = 0;
			con = ConnectionProvider.getConnection();
			mystate = con.prepareStatement("SELECT * from JobPost.Applications");
			ResultSet rs = mystate.executeQuery();
			while(rs.next()) {
				if(rs.getString("Status")=="No")
					count++;
			}
			data = Integer.toString(count);
		}
		catch(Exception e) {
			System.out.print(e);
		}
		return data;
	}
	public String getJobs() {
		try {
			int count = 0;
			con = ConnectionProvider.getConnection();
			mystate = con.prepareStatement("SELECT * from JobPost.Jobs");
			ResultSet rs = mystate.executeQuery();
			while(rs.next()) {
					count++;
			}
			data = Integer.toString(count);
			System.out.print(data);
		}
		catch(Exception e) {
			System.out.print(e);
		}
		return data;
	}
	public String getAppsFilled() {
		try {
			int count = 0;
			con = ConnectionProvider.getConnection();
			mystate = con.prepareStatement("select * from JobPost.Applications WHERE Status=?");
			mystate.setString(1, "Accept");
			ResultSet rs = mystate.executeQuery();
			while(rs.next()) {
				count++;
			}
			data = Integer.toString(count);
		}
		catch(Exception e) {
			System.out.print(e);
		}
		return data;
	}
}
