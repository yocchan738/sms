package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Authentication;

public class AuthenticationDAO extends DAO {
	public Authentication search(String login_id, String password)
		throws Exception {
		Authentication authentication=null;
		
		Connection con=getConnection();
		
		PreparedStatement st;
		st=con.prepareStatement("select * from users where login_id=? and password=?");
		st.setString(1, login_id);
		st.setString(2, password);
		ResultSet rs=st.executeQuery();
		
		while (rs.next()) {
			authentication=new Authentication();
			authentication.setId(rs.getInt("user_id"));
			authentication.setLoginId(rs.getString("login_id"));
			authentication.setPassword(rs.getString("password"));
		}
		
		st.close();
		con.close();
		return authentication;
	}
}