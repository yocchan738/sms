package subject_management;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Bean;
import dao.StudentDAO;

@WebServlet(urlPatterns = {"/subjectmanagement/update"})
public class SubjectUpdate extends HttpServlet {

	public void doGet(
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException{
		PrintWriter out=response.getWriter();
		try {
			int subject_id = Integer.parseInt(request.getParameter("subject_id"));
			int teacher_id = 0;
			StudentDAO dao=new StudentDAO();
			List<Bean> subject_list=dao.searchSubject("");
			List<Bean> subject_select_id=dao.searchSubjectID(subject_id);
			for (Bean s : subject_select_id) {
				teacher_id = s.getTeacher_id();
			}
			List<Bean> teacher_list=dao.searchTeachers("");
			List<Bean> teacher_select_id=dao.searchTeachersID(teacher_id);
			request.setAttribute("subject_list", subject_list);
			request.setAttribute("subject_select_id", subject_select_id);
			request.setAttribute("teacher_list", teacher_list);
			request.setAttribute("teacher_select_id", teacher_select_id);
			request.getRequestDispatcher("/subject_management/subject_update.jsp").forward(request, response);
		} catch(Exception e) {
			e.printStackTrace(out);
		}
	}
}
