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

@WebServlet(urlPatterns = {"/scoremanagement/delete/commit"})
public class ScoreDeleteCommit extends HttpServlet {

	public void doPost(
			HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {
			int score_id=Integer.parseInt(request.getParameter("score_id"));
			
			Bean s=new Bean();
			s.setScore_id(score_id);
			
			StudentDAO dao=new StudentDAO();
			int line=dao.deleteScores(s);
			if (line>0) {
				request.getRequestDispatcher("/score_management/score_delete_commit.jsp").forward(request, response);
			}
		} catch (Exception e) {
			request.getRequestDispatcher("/top_page/error.jsp").forward(request, response);
		}
	}
}
