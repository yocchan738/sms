package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Bean;

public class StudentDAO extends DAO {

	/**
	 * 成績表を学生名で検索するメソッド
	 * 
	 * @param keyword 検索キーワード（部分一致）
	 * @return List<Bean> 検索結果のリスト
	 */
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
	/**
	 * 成績表を学生IDで検索するメソッド
	 * 
	 * @param keyword 検索キーワード（完全一致）
	 * @return List<Bean> 検索結果のリスト
	 */
	public List<Bean> searchScoresStudent(int keyword) throws Exception{
		List<Bean> list=new ArrayList<>();
		
		Connection con=getConnection();
		
		PreparedStatement st=con.prepareStatement(
				"SELECT * FROM scores sc JOIN student s ON sc.student_id = s.student_id JOIN class c ON s.class_id = c.class_id JOIN school sch ON s.school_id = sch.school_id JOIN subjects sub ON sc.subject_id = sub.subject_id JOIN teacher t ON sub.teacher_id = t.teacher_id where s.student_id=?");
		
		st.setInt(1, keyword);
		
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
	/**
	 * 成績表をsubject_idで検索するメソッド
	 * 
	 * @param keyword 検索キーワード（完全一致）
	 * @return List<Bean> 検索結果のリスト
	 */
	public List<Bean> searchScoresSubject(int keyword) throws Exception{
		List<Bean> list=new ArrayList<>();
		
		Connection con=getConnection();
		
		PreparedStatement st=con.prepareStatement(
				"SELECT * FROM scores sc JOIN student s ON sc.student_id = s.student_id JOIN class c ON s.class_id = c.class_id JOIN school sch ON s.school_id = sch.school_id JOIN subjects sub ON sc.subject_id = sub.subject_id JOIN teacher t ON sub.teacher_id = t.teacher_id where sub.subject_id=?");
		
		st.setInt(1, keyword);
		
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
	/**
	 * 学生表を学生名で検索するメソッド
	 * 
	 * @param keyword 検索キーワード（部分一致）
	 * @return List<Bean> 検索結果のリスト
	 */
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
	/**
	 * クラス表を返すメソッド
	 * 
	 * @return List<Bean> 結果のリスト
	 */
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
	/**
	 * 学校表を返すメソッド
	 * 
	 * @return List<Bean> 結果のリスト
	 */
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
	/**
	 * 教科表を返すメソッド
	 * 
	 * @return List<Bean> 結果のリスト
	 */
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
	/**
	 * 教諭表を返すメソッド
	 * 
	 * @return List<Bean> 結果のリスト
	 */
	public List<Bean> searchTeachers(String keyword) throws Exception{
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
	
	/**
     * クラス情報を追加するメソッド
     * 
     * @param Bean 追加するクラスオブジェクト
     * @return int 追加された行数
     */
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
	/**
     * 学校情報を追加するメソッド
     * 
     * @param Bean 追加する学校オブジェクト
     * @return int 追加された行数
     */
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
	/**
     * 学生情報を追加するメソッド
     * 
     * @param Bean 追加する学生オブジェクト
     * @return int 追加された行数
     */
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
	/**
     * 教諭情報を追加するメソッド
     * 
     * @param Bean 追加する教諭オブジェクト
     * @return int 追加された行数
     */
	public int insertTeachers(Bean t) throws Exception{
		Connection con=getConnection();
		
		PreparedStatement st=con.prepareStatement(
				"insert into teacher(teacher_name) values(?)");
		st.setString(1, t.getTeacher_name());
		int line=st.executeUpdate();
		
		st.close();
		con.close();
		return line;
	}
	/**
     * 教科情報を追加するメソッド
     * 
     * @param Bean 追加する教科オブジェクト
     * @return int 追加された行数
     */
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
	/**
     * 成績情報を追加するメソッド
     * 
     * @param Bean 追加する成績オブジェクト
     * @return int 追加された行数
     */
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
	
	/**
     * クラス情報を更新するメソッド
     * 
     * @param Bean 更新するクラスオブジェクト
     * @return int 更新された行数
     */
	public int updateClass(Bean c) throws Exception{
		Connection con=getConnection();
		
		PreparedStatement st=con.prepareStatement(
				"update class set class_name=? where class_id=?");
		st.setString(1, c.getClass_name());
		st.setInt(2, c.getClass_id());
		int line=st.executeUpdate();
		
		st.close();
		con.close();
		return line;
	}
	/**
     * 学校情報を更新するメソッド
     * 
     * @param Bean 更新する学校オブジェクト
     * @return int 更新された行数
     */
	public int updateSchool(Bean sch) throws Exception{
		Connection con=getConnection();
		
		PreparedStatement st=con.prepareStatement(
				"update school set school_name=? where school_id=?");
		st.setString(1, sch.getSchool_name());
		st.setInt(2, sch.getSchool_id());
		int line=st.executeUpdate();
		
		st.close();
		con.close();
		return line;
	}
	/**
     * 学生情報を更新するメソッド
     * 
     * @param Bean 更新する学生オブジェクト
     * @return int 更新された行数
     */
	public int updateStudent(Bean s) throws Exception{
		Connection con=getConnection();
		
		PreparedStatement st=con.prepareStatement(
				"update student set student_name=?, class_id=?, school_id=? where class_id=?");
		st.setString(1, s.getStudent_name());
		st.setInt(2, s.getClass_id());
		st.setInt(3, s.getSchool_id());
		st.setInt(4, s.getStudent_id());
		int line=st.executeUpdate();
		
		st.close();
		con.close();
		return line;
	}
	/**
     * 教諭情報を更新するメソッド
     * 
     * @param Bean 更新する教諭オブジェクト
     * @return int 更新された行数
     */
	public int updateTeachers(Bean t) throws Exception{
		Connection con=getConnection();
		
		PreparedStatement st=con.prepareStatement(
				"update teachers set teacher_name=? where teacher_id=?");
		st.setString(1, t.getTeacher_name());
		st.setInt(2, t.getSubject_id());
		int line=st.executeUpdate();
		
		st.close();
		con.close();
		return line;
	}
	/**
     * 教科情報を更新するメソッド
     * 
     * @param Bean 更新する教科オブジェクト
     * @return int 更新された行数
     */
	public int updateSubjects(Bean sub) throws Exception{
		Connection con=getConnection();
		
		PreparedStatement st=con.prepareStatement(
				"update subjects set subject_name=?, teacher_id=? where subject_id=?");
		st.setString(1, sub.getSubject_name());
		st.setInt(2, sub.getTeacher_id());
		st.setInt(3, sub.getSubject_id());
		int line=st.executeUpdate();
		
		st.close();
		con.close();
		return line;
	}
	/**
     * 成績情報を更新するメソッド
     * 
     * @param Bean 更新する成績オブジェクト
     * @return int 更新された行数
     */
	public int updateScores(Bean sc) throws Exception{
		Connection con=getConnection();
		
		PreparedStatement st=con.prepareStatement(
				"update Scores set student_id=?, subject_id=?, score_value=? where score_id=?");
		st.setInt(1, sc.getStudent_id());
		st.setInt(2, sc.getSubject_id());
		st.setInt(3, sc.getScore_value());
		st.setInt(4, sc.getScore_id());
		int line=st.executeUpdate();
		
		st.close();
		con.close();
		return line;
	}
}
