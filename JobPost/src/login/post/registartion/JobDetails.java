package login.post.registartion;

import java.io.InputStream;

public class JobDetails {
	private static int ID;
	private static String UserID;
	public static String getUserID() {
		return UserID;
	}
	public static void setUserID(String userID) {
		UserID = userID;
	}
	public static int getID() {
		return ID;
	}
	public static void setID(int iD) {
		ID = iD;
	}
	private static String email;
	private static InputStream logo;
	public static InputStream getLogo() {
		return logo;
	}
	public static void setLogo(InputStream logo) {
		JobDetails.logo = logo;
	}
	public static String getEmail() {
		return email;
	}
	public static void setEmail(String email) {
		JobDetails.email = email;
	}
	public static String getCompanyname() {
		return companyname;
	}
	public static void setCompanyname(String companyname) {
		JobDetails.companyname = companyname;
	}
	public static String getJobtitle() {
		return jobtitle;
	}
	public static void setJobtitle(String jobtitle) {
		JobDetails.jobtitle = jobtitle;
	}
	public static String getLocation() {
		return location;
	}
	public static void setLocation(String location) {
		JobDetails.location = location;
	}
	public static String getRegion() {
		return region;
	}
	public static void setRegion(String region) {
		JobDetails.region = region;
	}
	public static String getDescryption() {
		return descryption;
	}
	public static void setDescryption(String descryption) {
		JobDetails.descryption = descryption;
	}
	public static String getWebsite() {
		return website;
	}
	public static void setWebsite(String website) {
		JobDetails.website = website;
	}
	private static String companyname;
	private static String jobtitle;
	private static String location;
	private static String region;
	private static String descryption;
	private static String website;
	private static String status;
	public static String getStatus() {
		return status;
	}
	public static void setStatus(String status) {
		JobDetails.status = status;
	}
	private static String salary;
	public static String getSalary() {
		return salary;
	}
	public static void setSalary(String salary) {
		JobDetails.salary = salary;
	}
}
