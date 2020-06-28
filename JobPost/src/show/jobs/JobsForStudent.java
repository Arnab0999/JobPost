package show.jobs;
import login.post.registartion.*;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;

public class JobsForStudent {
		Connection con;
		PreparedStatement mystate, comp;
		public ArrayList<JobData> getData(String userid) {
			ArrayList<JobData> arr = new ArrayList<JobData>();
			ArrayList<JobData> allJobs = new ArrayList<JobData>();
			try {
				con = ConnectionProvider.getConnection();
				mystate = con.prepareStatement("select * from JobPost.Jobs");
				ResultSet rs = mystate.executeQuery();
				while(rs.next()) {
					if(rs.getString("JobTitle")==StudentDetails.getPost() || rs.getString("Region")==StudentDetails.getRegion()) {
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
					jd.setSalary(rs.getString("Sallary"));
					arr.add(jd);
					}
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
						jd.setSalary(rs.getString("Sallary"));
						allJobs.add(jd);
				}
			}
			catch(Exception e) {
				System.out.print(e);
			}
			if(StudentDetails.getPost()==null)
				return allJobs;
			return arr;
		}
		public ArrayList<JobData> getAllData() {
			ArrayList<JobData> arr = new ArrayList<JobData>();
			try {
				con = ConnectionProvider.getConnection();
				mystate = con.prepareStatement("select * from JobPost.Jobs");
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
		public ArrayList<Application> getMyApps(String userid){
			ArrayList<Application> arr = new ArrayList<Application>();
			try {
				con = ConnectionProvider.getConnection();
				mystate = con.prepareStatement("select * from Applications where StudentUserID = ?");
				mystate.setString(1, userid);
				ResultSet rs = mystate.executeQuery();
				while(rs.next()) {
					Application app = new Application();
					Connection fon = ConnectionProvider.getConnection();
					PreparedStatement ps = fon.prepareStatement("select CompanyName, JobTitle from Jobs where ID = ?");
					ps.setString(1, rs.getString("JobID"));
					ResultSet rs2 = ps.executeQuery();
					if(rs2.next()) {
						app.setCompName(rs2.getString("CompanyName"));
						app.setJobTitle(rs2.getString("JobTitle"));
					}
					app.setDescrip(rs.getString("StudentDesciption"));
					app.setStatus(rs.getString("Status"));
					arr.add(app);
				}
			}
			catch(Exception e) {
				System.out.print(e);
			}
			return arr;
		}
}
