package bean;

public class Authentication implements java.io.Serializable {
	
	private int user_id;
	private String login_id;
	private String password;
	
	public int getId() {
		return user_id;
	}
	public String getLoginId() {
		return login_id;
	}
	public String getPassword() {
		return password;
	}
	
	public void setId(int user_id) {
		this.user_id=user_id;
	}
	public void setLoginId(String login_id) {
		this.login_id=login_id;
	}
	public void setPassword(String password) {
		this.password=password;
	}
}
