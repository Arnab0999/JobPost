package Session;
import java.util.ArrayList;

import show.jobs.*;
public class HomeSession {
	private static ArrayList<JobData> allJobs;
	private static String StudentNumber;
	public static String getStudentNumber() {
		return StudentNumber;
	}

	public static void setStudentNumber(String studentNumber) {
		StudentNumber = studentNumber;
	}

	public static String getCompanyNumber() {
		return CompanyNumber;
	}

	public static void setCompanyNumber(String companyNumber) {
		CompanyNumber = companyNumber;
	}

	public static String getJobsFilled() {
		return JobsFilled;
	}

	public static void setJobsFilled(String jobsFilled) {
		JobsFilled = jobsFilled;
	}

	private static String CompanyNumber;
	private static String JobsFilled;
	public static ArrayList<JobData> getAllJobs() {
		return allJobs;
	}

	public static void setAllJobs(ArrayList<JobData> allJobs) {
		HomeSession.allJobs = allJobs;
	}

	
	
}
