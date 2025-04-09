package student_score_management;

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

@WebServlet(urlPatterns = {"/studentscoremanagement/search"})
public class StudentScoreSearch extends HttpServlet {

	public void doGet(
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException{
		PrintWriter out=response.getWriter();
		try {
			StudentDAO dao=new StudentDAO();
			List<Bean> list=dao.searchStudent("");
			request.setAttribute("list", list);
			request.getRequestDispatcher("/student_score_management/student_score_search.jsp").forward(request, response);
		} catch(Exception e) {
			e.printStackTrace(out);
		}
	}
}
