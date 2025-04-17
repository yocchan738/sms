package student_management;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Bean;
import dao.StudentDAO;

@WebServlet(urlPatterns = {"/studentmanagement/delete/commit"})
public class StudentDeleteComit extends HttpServlet {

	public void doPost(
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException{
		PrintWriter out=response.getWriter();
		int student_id = Integer.parseInt(request.getParameter("id")); 
		try {
			Bean s=new Bean();
			s.setStudent_id(student_id);
			StudentDAO dao=new StudentDAO();
			int line=dao.deleteStudent(s);
			if (line>0) {
				
			}
			request.getRequestDispatcher("/student_management/student_delete_commit.jsp").forward(request, response);
		} catch (Exception e) {
			request.getRequestDispatcher("/top_page/error.jsp").forward(request, response);
		}
	}
}