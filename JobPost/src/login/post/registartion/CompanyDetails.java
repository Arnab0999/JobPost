package login.post.registartion;
import java.io.InputStream;;

public class CompanyDetails {
	private static String email;
	private static InputStream logo;
	public static InputStream getLogo() {
		return logo;
	}
	public static void setLogo(InputStream logo) {
		CompanyDetails.logo = logo;
	}
	public static String getEmail() {
		return email;
	}
	public static void setEmail(String email) {
		CompanyDetails.email = email;
	}
	public static String getCompanyname() {
		return companyname;
	}
	public static void setCompanyname(String companyname) {
		CompanyDetails.companyname = companyname;
	}
	public static String getJobtitle() {
		return jobtitle;
	}
	public static void setJobtitle(String jobtitle) {
		CompanyDetails.jobtitle = jobtitle;
	}
	public static String getLocation() {
		return location;
	}
	public static void setLocation(String location) {
		CompanyDetails.location = location;
	}
	public static String getRegion() {
		return region;
	}
	public static void setRegion(String region) {
		CompanyDetails.region = region;
	}
	public static String getDescryption() {
		return descryption;
	}
	public static void setDescryption(String descryption) {
		CompanyDetails.descryption = descryption;
	}
	public static String getWebsite() {
		return website;
	}
	public static void setWebsite(String website) {
		CompanyDetails.website = website;
	}
	private static String companyname;
	private static String jobtitle;
	private static String location;
	private static String region;
	private static String descryption;
	private static String website;
}
