package search;
import show.jobs.JobData;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.*;
import login.post.registartion.ConnectionProvider;
import java.util.ArrayList;
import java.util.Base64;
public class findJobs {
	Connection con;
	PreparedStatement mystate;
	ArrayList<JobData> getSearchedJobs(String keyword, String location) {
		ArrayList<JobData> jd = new ArrayList<JobData>();
		keyword = '%'+keyword+'%';
		if(location.equals("Anywhere"))
			location = "%";
		try {
			con = ConnectionProvider.getConnection();
			mystate = con.prepareStatement("select * from JobPost.Jobs where JobTitle LIKE ? OR CompanyName LIKE ? AND Region LIKE ?");
			mystate.setString(1, keyword);
			mystate.setString(2, keyword);
			mystate.setString(3, location);
			ResultSet rs = mystate.executeQuery();
			while(rs.next()) {
				JobData j = new JobData();
				j.setID(Integer.parseInt(rs.getString("ID")));
				j.setUserID(rs.getString("UserID"));
				Blob bl = rs.getBlob("Logo");
				ByteArrayOutputStream os = new ByteArrayOutputStream();
				InputStream is = bl.getBinaryStream();
				int bytesRead = -1;
				byte[] buffer = new byte[4096];
				while((bytesRead = is.read(buffer)) != -1) {
					os.write(buffer,0,bytesRead);
				}
				byte[] imageBytes = os.toByteArray();
				j.setImageLogo(Base64.getEncoder().encodeToString(imageBytes));
				is.close();
				os.close();
				j.setLogo(bl.getBinaryStream());
				j.setEmail(rs.getString("Email"));
				j.setCompanyname(rs.getString("CompanyName"));
				j.setJobtitle(rs.getString("JobTitle"));
				j.setLocation(rs.getString("Location"));
				j.setRegion(rs.getString("Region"));
				j.setDescription(rs.getString("Descryption"));
				j.setWebsite(rs.getString("Website"));
				j.setSalary(rs.getString("Sallary"));
				jd.add(j);
			}
		}
		catch(Exception e) {
			System.out.print(e);
		}
		return jd;
	}
}
