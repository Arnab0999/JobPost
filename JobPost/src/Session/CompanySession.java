package Session;
import java.util.ArrayList;
import login.post.registartion.*;
import show.jobs.*;

public class CompanySession {
	private static Customer cus;
	public static Customer getCus() {
		return cus;
	}
	public static void setCus(Customer cus) {
		CompanySession.cus = cus;
	}
	public static CompanyDetails getCompDet() {
		return compDet;
	}
	public static void setCompDet(CompanyDetails compDet) {
		CompanySession.compDet = compDet;
	}
	public static ArrayList<JobData> getJobs() {
		return jobs;
	}
	public static void setJobs(ArrayList<JobData> jobs) {
		CompanySession.jobs = jobs;
	}
	public static ArrayList<StudentData> getApps() {
		return apps;
	}
	public static void setApps(ArrayList<StudentData> apps) {
		CompanySession.apps = apps;
	}
	public static ArrayList<StudentData> getStuds() {
		return studs;
	}
	public static void setStuds(ArrayList<StudentData> studs) {
		CompanySession.studs = studs;
	}
	private static CompanyDetails compDet;
	private static ArrayList<JobData> jobs;
	private static ArrayList<StudentData> apps;
	private static ArrayList<StudentData> studs;
}
