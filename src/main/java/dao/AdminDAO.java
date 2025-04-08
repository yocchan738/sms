package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Admin;

public class AdminDAO extends DAO {
	public Admin search(String loginid, String password)
		throws Exception {
		Admin admin=null;
		
		Connection con=getConnection();
		
		PreparedStatement st;
		st=con.prepareStatement("select * from admin where loginid=? and password=?");
		st.setString(1, loginid);
		st.setString(2, password);
		ResultSet rs=st.executeQuery();
		
		while (rs.next()) {
			admin=new Admin();
			admin.setId(rs.getInt("id"));
			admin.setLogin(rs.getString("loginid"));
			admin.setPassword(rs.getString("password"));
		}
		
		st.close();
		con.close();
		return admin;
	}
}