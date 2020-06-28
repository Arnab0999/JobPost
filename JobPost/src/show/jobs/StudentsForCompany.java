package show.jobs;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.*;
import login.post.registartion.*;
import java.util.ArrayList;
import java.util.Base64;

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
				System.out.print("Nigga");
				mystate = con.prepareStatement("select * from JobPost.Student, JobPost.Jobs where STRCMP(JobPost.Student.Post, JobPost.Jobs.JobTitle)=0 AND JobPost.Jobs.UserID=?");
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
	public ArrayList<StudentData> getApps(String userid){
		ArrayList<StudentData> arr = new ArrayList<StudentData>();
		try {
			con = ConnectionProvider.getConnection();
			mystate = con.prepareStatement("select * from JobPost.Applications WHERE CompanyUserID=?");
			mystate.setString(1, userid);
			ResultSet rs = mystate.executeQuery();
			while(rs.next()) {
				StudentData sd = new StudentData();
				PreparedStatement ps = con.prepareStatement("select * from JobPost.Student where UserID=?");
				ps.setString(1, rs.getString("StudentUserID"));
				ResultSet stu = ps.executeQuery();
				if(stu.next()) {
					sd.setUserID(stu.getString("UserID"));
					sd.setFirstname(stu.getString("FirstName"));
					sd.setLastname(stu.getString("LastName"));
					sd.setPost(stu.getString("Post"));
					sd.setAge(stu.getString("Age"));
					sd.setRegion(stu.getString("Region"));
					sd.setEmail(stu.getString("Email"));
					sd.setSkills(stu.getString("Skills"));
				}
				sd.setDescription(rs.getString("StudentDesciption"));
				sd.setAppID(rs.getString("ID"));
				arr.add(sd);
			}
			con.close();
		}
		catch(Exception e) {
			System.out.print(e);
		}
		return arr;
	}
	public ArrayList<JobData> getMyJobs(String userid){
		ArrayList<JobData> arr = new ArrayList<JobData>();
		try {
			con = ConnectionProvider.getConnection();
			mystate = con.prepareStatement("select * from JobPost.Jobs WHERE UserID=?");
			mystate.setString(1, userid);
			ResultSet rs = mystate.executeQuery();
			while(rs.next()) {
				JobData jd = new JobData();
				jd.setID(Integer.parseInt(rs.getString("ID")));
				jd.setUserID(rs.getString("UserID"));
				Blob bl = rs.getBlob("Logo");
				ByteArrayOutputStream os = new ByteArrayOutputStream();
				InputStream is = bl.getBinaryStream();
				int bytesRead = -1;
				byte[] buffer = new byte[4096];
				while((bytesRead = is.read(buffer)) != -1) {
					os.write(buffer,0,bytesRead);
				}
				byte[] imageBytes = os.toByteArray();
				jd.setImageLogo(Base64.getEncoder().encodeToString(imageBytes));
				is.close();
				os.close();
				jd.setLogo(bl.getBinaryStream());
				jd.setEmail(rs.getString("Email"));
				jd.setCompanyname(rs.getString("CompanyName"));
				jd.setJobtitle(rs.getString("JobTitle"));
				jd.setLocation(rs.getString("Location"));
				jd.setRegion(rs.getString("Region"));
				jd.setDescription(rs.getString("Descryption"));
				jd.setWebsite(rs.getString("Website"));
				arr.add(jd);
			}
		}
		catch(Exception e) {
			System.out.print(e);
		}
		return arr;
	}
}
