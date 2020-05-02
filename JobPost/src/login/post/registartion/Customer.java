package login.post.registartion;

public class Customer {
	private static String userid;
	private static String password;
	private static String type;
	public String getType() {
		return Customer.type;
	}
	public void setType(String t) {
		Customer.type = t;
	}
	
	public String getUserid() {
		return Customer.userid;
	}
	public void setUserid(String id) {
		Customer.userid = id;
	}
	public String getPassword() {
		return Customer.password;
	}
	public void setPassword(String passwd) {
		Customer.password = passwd;
	}
	
	
}
