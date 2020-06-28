package Session;
import java.util.ArrayList;

import login.post.registartion.*;
import show.jobs.*;
public class StudentSession {
	private static Customer cus;
	public static Customer getCus() {
		return cus;
	}
	public static void setCus(Customer cus) {
		StudentSession.cus = cus;
	}
	public static StudentData getStud() {
		return stud;
	}
	public static void setStud(StudentData stud) {
		StudentSession.stud = stud;
	}
	public static ArrayList<JobData> getJobs() {
		return jobs;
	}
	public static void setJobs(ArrayList<JobData> jobs) {
		StudentSession.jobs = jobs;
	}
	public static ArrayList<Application> getApps() {
		return apps;
	}
	public static void setApps(ArrayList<Application> apps) {
		StudentSession.apps = apps;
	}
	private static StudentData stud;
	private static ArrayList<JobData> jobs;
	private static ArrayList<Application> apps;
}
