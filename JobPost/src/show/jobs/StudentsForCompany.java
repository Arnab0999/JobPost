package show.jobs;
import java.sql.*;
import login.post.registartion.*;
import java.util.ArrayList;

public class StudentsForCompany {
	Connection con;
	PreparedStatement mystate;
	public ArrayList<StudentData> getData(String userid) {
		ArrayList<StudentData> arr = new ArrayList<StudentData>();
		try {
			con = ConnectionProvider.getConnection();
			PreparedStatement test = con.prepareStatement("select * from JobPost.Company where UserID=?");
			test.setString(1, userid);
			ResultSet ts = test.executeQuery();
			String testPost = null;
			while(ts.next())
				testPost = ts.getString("JobTitle");
			if(testPost != null) {
				mystate = con.prepareStatement("select * from JobPost.Student, JobPost.Company where STRCMP(JobPost.Student.Post, JobPost.Company.JobTitle)=0 AND JobPost.Company.UserID=?");
				mystate.setString(1, userid);
			}
			else {
				mystate = con.prepareStatement("select * from JobPost.Student");
			}
			ResultSet rs = mystate.executeQuery();
			while(rs.next()) {
				StudentData jd = new StudentData();
				jd.setEmail(rs.getString("Email"));
				jd.setFirstname(rs.getString("FirstName"));
				jd.setLastname(rs.getString("LastName"));
				jd.setPost(rs.getString("Post"));
				jd.setRegion(rs.getString("Region"));
				jd.setAge(rs.getString("Age"));
				jd.setSkills(rs.getString("Skills"));
				arr.add(jd);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return arr;
	}
}
