package student_management;

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

@WebServlet(urlPatterns = {"/studentmanagement/delete/select"})
public class StudentDeleteSelect extends HttpServlet {

	public void doGet(
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException{
		PrintWriter out=response.getWriter();
		try {
			StudentDAO dao=new StudentDAO();
			List<Bean> student_list=dao.searchStudent("");
			request.setAttribute("student_list", student_list);
			request.getRequestDispatcher("/student_management/student_delete_select.jsp").forward(request, response);
		} catch(Exception e) {
			request.getRequestDispatcher("/top_page/error.jsp").forward(request, response);
		}
	}
}
