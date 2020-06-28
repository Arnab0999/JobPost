package search;
import show.jobs.StudentData;
import java.sql.*;
import login.post.registartion.ConnectionProvider;
import java.util.ArrayList;

public class findStudents {
	Connection con;
	PreparedStatement mystate;
	ArrayList<StudentData> getSearchedStuds(String keyword, String location) {
		ArrayList<StudentData> arr = new ArrayList<StudentData>();
		if(location.equals("Anywhere"))
			location = "%";
		keyword = '%'+keyword+'%';
		try {
			con = ConnectionProvider.getConnection();
			mystate = con.prepareStatement("select * from JobPost.Student where Post LIKE ? OR Skills LIKE ? AND Region LIKE ?");
			mystate.setString(1, keyword);
			mystate.setString(2, keyword);
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
			System.out.print(e);
		}
		return arr;
	}
}

