package tax;
//this class is relates to task 1.Used to check the username and password matches or not.
public class AuthenticationValidator {
	private static  String username="admin";
	private static String password="admin123";
	String currUserName;
	String currPassword;
	public AuthenticationValidator(String username,String password) {
		this.currUserName=username;
		this.currPassword=password;
	}
	public boolean validator() {
		if(currUserName.equals(username)&&currPassword.equals(password)) {
			return true;
		}
		return false;
	}
}
