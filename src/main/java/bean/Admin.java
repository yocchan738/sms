package bean;

public class Admin implements java.io.Serializable {
	
	private int id;
	private String loginid;
	private String password;
	
	public int getId() {
		return id;
	}
	public String getLoginId() {
		return loginid;
	}
	public String getPassword() {
		return password;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	public void setLogin(String loginid) {
		this.loginid=loginid;
	}
	public void setPassword(String password) {
		this.password=password;
	}
}
