package score_management;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Bean;
import dao.StudentDAO;

@WebServlet(urlPatterns = {"/scoremanagement/update/commit"})
public class ScoreUpdateCommit extends HttpServlet {

	public void doPost(
			HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {
			int score_id=Integer.parseInt(request.getParameter("score_id"));
			int student_id=Integer.parseInt(request.getParameter("student_id"));
			int subject_id=Integer.parseInt(request.getParameter("subject_id"));
			int score_value=Integer.parseInt(request.getParameter("score_value"));
			
			Bean s=new Bean();
			s.setScore_id(score_id);
			s.setStudent_id(student_id);
			s.setSubject_id(subject_id);
			s.setScore_value(score_value);
			
			StudentDAO dao=new StudentDAO();
			int line=dao.updateScores(s);
			if (line>0) {
				request.getRequestDispatcher("/score_management/score_update_commit.jsp").forward(request, response);
			}
		} catch (Exception e) {
			request.getRequestDispatcher("/top_page/error.jsp").forward(request, response);
		}
	}
}
