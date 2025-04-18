package subject_score_management;

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

@WebServlet(urlPatterns = {"/subjectscoremanagement/list"})
public class SubjectScoreList extends HttpServlet {

	public void doPost(
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException{
		PrintWriter out=response.getWriter();
		try {
			StudentDAO dao=new StudentDAO();
			List<Bean> list=dao.searchScoresSubject(Integer.parseInt(request.getParameter("subject_id")));
			request.setAttribute("list", list);
			request.getRequestDispatcher("/subject_score_management/subject_score_list.jsp").forward(request, response);
		} catch(Exception e) {
			request.getRequestDispatcher("/top_page/error.jsp").forward(request, response);
		}
	}
}
