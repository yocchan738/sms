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

@WebServlet(urlPatterns = {"/scoremanagement/delete/select"})
public class ScoreDeleteSelect extends HttpServlet {

	public void doGet(
			HttpServletRequest request, HttpServletResponse response
		) throws ServletException, IOException{
			PrintWriter out=response.getWriter();
			try {
				StudentDAO dao=new StudentDAO();
				List<Bean> list_scores=dao.searchScores("");
				request.setAttribute("list_scores", list_scores);
				request.getRequestDispatcher("/score_management/score_delete_select.jsp").forward(request, response);
			} catch(Exception e) {
				request.getRequestDispatcher("/top_page/error.jsp").forward(request, response);
			}
	}
}
