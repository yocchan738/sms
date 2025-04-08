package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Admin;

public class AdminDAO extends DAO {
	public Admin search(String login, String password)
		throws Exception {
		Admin admin=null;
		
		Connection con=getConnection();
		
		PreparedStatement st;
		st=con.prepareStatement("select * from admin where login=? and password=?");
		st.setString(1, login);
		st.setString(2, password);
		ResultSet rs=st.executeQuery();
		
		while (rs.next()) {
			admin=new Admin();
			admin.setId(rs.getInt("id"));
			admin.setLogin(rs.getString("login"));
			admin.setPassword(rs.getString("password"));
		}
		
		st.close();
		con.close();
		return admin;
	}
}