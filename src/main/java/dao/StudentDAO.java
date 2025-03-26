package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Bean;

public class StudentDAO extends DAO {

	public List<Bean> searchScores(String keyword) throws Exception{
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
	public List<Bean> searchStudent(String keyword) throws Exception{
		List<Bean> list=new ArrayList<>();
		
		Connection con=getConnection();
		
		PreparedStatement st=con.prepareStatement(
				"SELECT * FROM student s join class c on s.class_id=c.class_id join school sch on s.school_id=sch.school_id where s.student_name like ?");
		
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
	        list.add(s);
		}
		
		st.close();
		con.close();
		
		return list;
	}
	public List<Bean> searchClass() throws Exception{
		List<Bean> list=new ArrayList<>();
		
		Connection con=getConnection();
		
		PreparedStatement st=con.prepareStatement(
				"SELECT * FROM class");
		
		ResultSet rs=st.executeQuery();
		
		while (rs.next()) {
			Bean s=new Bean();
			s.setClass_id(rs.getInt("class_id"));
			s.setClass_name(rs.getString("class_name"));
	        list.add(s);
		}
		
		st.close();
		con.close();
		
		return list;
	}
	public List<Bean> searchSchool(String keyword) throws Exception{
		List<Bean> list=new ArrayList<>();
		
		Connection con=getConnection();
		
		PreparedStatement st=con.prepareStatement(
				"SELECT * FROM school");
		
		ResultSet rs=st.executeQuery();
		
		while (rs.next()) {
			Bean s=new Bean();
			s.setSchool_id(rs.getInt("school_id"));
			s.setSchool_name(rs.getString("school_name"));
	        list.add(s);
		}
		
		st.close();
		con.close();
		
		return list;
	}
	public List<Bean> searchSubject(String keyword) throws Exception{
		List<Bean> list=new ArrayList<>();
		
		Connection con=getConnection();
		
		PreparedStatement st=con.prepareStatement(
				"SELECT * FROM subjects sub join teacher t on sub.teacher_id=t.teacher_id");
		
		ResultSet rs=st.executeQuery();
		
		while (rs.next()) {
			Bean s=new Bean();
			s.setSubject_id(rs.getInt("subject_id"));
	        s.setSubject_name(rs.getString("subject_name"));
	        s.setTeacher_id(rs.getInt("teacher_id"));
	        s.setTeacher_name(rs.getString("teacher_name"));
	        list.add(s);
		}
		
		st.close();
		con.close();
		
		return list;
	}
	public List<Bean> searchTeacher(String keyword) throws Exception{
		List<Bean> list=new ArrayList<>();
		
		Connection con=getConnection();
		
		PreparedStatement st=con.prepareStatement(
				"SELECT * FROM teacher");
		
		ResultSet rs=st.executeQuery();
		
		while (rs.next()) {
			Bean s=new Bean();
			s.setTeacher_id(rs.getInt("teacher_id"));
	        s.setTeacher_name(rs.getString("teacher_name"));
	        list.add(s);
		}
		
		st.close();
		con.close();
		
		return list;
	}
	
	public int insertClass(Bean c) throws Exception{
		Connection con=getConnection();
		
		PreparedStatement st=con.prepareStatement(
				"insert into class(class_name) values(?)");
		st.setString(1, c.getClass_name());
		int line=st.executeUpdate();
		
		st.close();
		con.close();
		return line;
	}
	public int insertSchool(Bean sch) throws Exception{
		Connection con=getConnection();
		
		PreparedStatement st=con.prepareStatement(
				"insert into school(school_name) values(?)");
		st.setString(1, sch.getSchool_name());
		int line=st.executeUpdate();
		
		st.close();
		con.close();
		return line;
	}
	public int insertStudent(Bean s) throws Exception{
		Connection con=getConnection();
		
		PreparedStatement st=con.prepareStatement(
				"insert into student(student_name,class_id,school_id) values(?,?,?)");
		st.setString(1, s.getStudent_name());
		st.setInt(2, s.getClass_id());
		st.setInt(3, s.getSchool_id());
		int line=st.executeUpdate();
		
		st.close();
		con.close();
		return line;
	}
	public int insertTeacher(Bean t) throws Exception{
		Connection con=getConnection();
		
		PreparedStatement st=con.prepareStatement(
				"insert into teacher(teacher_name) values(?)");
		st.setString(1, t.getTeacher_name());
		int line=st.executeUpdate();
		
		st.close();
		con.close();
		return line;
	}
	public int insertSubject(Bean sub) throws Exception{
		Connection con=getConnection();
		
		PreparedStatement st=con.prepareStatement(
				"insert into subjects(subject_name,teacher_id) values(?,?)");
		st.setString(1, sub.getSubject_name());
		st.setInt(2, sub.getTeacher_id());
		int line=st.executeUpdate();
		
		st.close();
		con.close();
		return line;
	}
	public int insertScores(Bean sc) throws Exception{
		Connection con=getConnection();
		
		PreparedStatement st=con.prepareStatement(
				"insert into scores(student_id,subject_id,score_value) values(?,?,?)");
		st.setInt(1, sc.getStudent_id());
		st.setInt(2, sc.getSubject_id());
		st.setInt(3, sc.getScore_value());
		int line=st.executeUpdate();
		
		st.close();
		con.close();
		return line;
	}
}
