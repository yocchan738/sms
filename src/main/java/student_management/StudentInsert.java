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

@WebServlet(urlPatterns = {"/studentmanagement/insert"})
public class StudentInsert extends HttpServlet {

	public void doGet(
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException{
		PrintWriter out=response.getWriter();
		try {
			StudentDAO dao=new StudentDAO();
			List<Bean> school_list=dao.searchSchool("");
			List<Bean> class_list=dao.searchClass("");
			request.setAttribute("school_list", school_list);
			request.setAttribute("class_list", class_list);
			request.getRequestDispatcher("/student_management/student_insert.jsp").forward(request, response);
		} catch(Exception e) {
			request.getRequestDispatcher("/top_page/error.jsp").forward(request, response);
		}
	}
}
