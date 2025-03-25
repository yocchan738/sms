package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Bean;

public class StudentDAO extends DAO {

	public List<Bean> search(String keyword) throws Exception{
		List<Bean> list=new ArrayList<>();
		
		Connection con=getConnection();
		
		PreparedStatement st=con.prepareStatement(
				"SELECT * FROM scores sc JOIN student s ON sc.student_id = s.student_id JOIN class c ON s.class_id = c.class_id JOIN school sch ON s.school_id = sch.school_id JOIN subjects sub ON sc.subject_id = sub.subject_id JOIN teacher t ON sub.teacher_id = t.teacher_id where s.student_name like ?");
		
		st.setString(1, "%"+keyword+"%");
		
		ResultSet rs=st.executeQuery();
		
		while (rs.next()) {
			Bean s=new Bean();
			s.setClass_id(rs.getInt("class_id"));
			s.setClass_name(rs.getString("class_name"));
			s.setSchool_id(rs.getInt("school_id"));
			s.setSchool_name(rs.getString("school_name"));
			s.setStudent_id(rs.getInt("student_id"));
	        s.setStudent_name(rs.getString("student_name"));
	        s.setSubject_id(rs.getInt("subject_id"));
	        s.setSubject_name(rs.getString("subject_name"));
	        s.setTeacher_id(rs.getInt("teacher_id"));
	        s.setTeacher_name(rs.getString("teacher_name"));
	        s.setScore_id(rs.getInt("score_id"));
	        s.setScore_value(rs.getInt("score_value"));
	        list.add(s);
		}
		
		st.close();
		con.close();
		
		return list;
	}
}
