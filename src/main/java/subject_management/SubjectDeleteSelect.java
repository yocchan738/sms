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

@WebServlet(urlPatterns = {"/subjectmanagement/delete/select"})
public class SubjectDeleteSelect extends HttpServlet {

	public void doGet(
			HttpServletRequest request, HttpServletResponse response
		) throws ServletException, IOException{
			PrintWriter out=response.getWriter();
			try {
				StudentDAO dao=new StudentDAO();
				List<Bean> subject_list=dao.searchSubject("");
				request.setAttribute("subject_list", subject_list);
				request.getRequestDispatcher("/subject_management/subject_delete_select.jsp").forward(request, response);
			} catch(Exception e) {
				request.getRequestDispatcher("/top_page/error.jsp").forward(request, response);
			}
		}
}
