package score_management;

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

@WebServlet(urlPatterns = {"/scoremanagement/insert"})
public class ScoreInsert extends HttpServlet {

	public void doGet(
			HttpServletRequest request, HttpServletResponse response
		) throws ServletException, IOException{
			PrintWriter out=response.getWriter();
			try {
				StudentDAO dao=new StudentDAO();
				List<Bean> list_student=dao.searchStudent("");
				request.setAttribute("list_student", list_student);
				List<Bean> list_subject=dao.searchSubject("");
				request.setAttribute("list_subject", list_subject);
				request.getRequestDispatcher("/score_management/score_insert.jsp").forward(request, response);
			} catch(Exception e) {
				request.getRequestDispatcher("/top_page/error.jsp").forward(request, response);
			}
	}
}
