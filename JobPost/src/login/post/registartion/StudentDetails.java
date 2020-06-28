package login.post.registartion;

public class StudentDetails {
	private static String appID;
	public static String getAppID() {
		return appID;
	}

	public static void setAppID(String appID) {
		StudentDetails.appID = appID;
	}

	private static String email;
	private static String firstname;
	private static String lastname;
	private static String region;
	private static String age;
	private static String post;
	private static String skills;
	public static String getFirstname() {
		return firstname;
	}

	public static void setFirstname(String firstname) {
		StudentDetails.firstname = firstname;
	}

	public static String getLastname() {
		return lastname;
	}

	public static void setLastname(String lastname) {
		StudentDetails.lastname = lastname;
	}

	public static String getRegion() {
		return region;
	}

	public static void setRegion(String region) {
		StudentDetails.region = region;
	}

	public static String getAge() {
		return age;
	}

	public static void setAge(String age) {
		StudentDetails.age = age;
	}

	public static String getPost() {
		return post;
	}

	public static void setPost(String post) {
		StudentDetails.post = post;
	}

	public static String getSkills() {
		return skills;
	}

	public static void setSkills(String skills) {
		StudentDetails.skills = skills;
	}
	public static String getEmail() {
		return email;
	}

	public static void setEmail(String email) {
		StudentDetails.email = email;
	}
	
}
