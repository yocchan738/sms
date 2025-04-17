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

@WebServlet(urlPatterns = {"/studentscoremanagement/list"})
public class StudentScoreList extends HttpServlet {

	public void doPost(
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException{
		PrintWriter out=response.getWriter();
		try {
			int id=Integer.parseInt(request.getParameter("student_id"));
			StudentDAO dao=new StudentDAO();
			List<Bean> list=dao.searchScoresStudent(id);
			request.setAttribute("list", list);
			List<Bean> list_sum_avg=dao.searchScoresSumAvg(id);
			request.setAttribute("list_sum_avg", list_sum_avg);
			request.getRequestDispatcher("/student_score_management/student_score_list.jsp").forward(request, response);
		} catch(Exception e) {
			request.getRequestDispatcher("/top_page/error.jsp").forward(request, response);
		}
	}
}
