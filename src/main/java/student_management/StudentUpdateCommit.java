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
 
@WebServlet(urlPatterns= {"/studentmanegement/update/commit"})
public class StudentUpdateCommit extends HttpServlet{
 
	public void doPost(
			HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {
			String name=request.getParameter("name");
			int class_id=Integer.parseInt(request.getParameter("class_id"));
			int school_id=Integer.parseInt(request.getParameter("school_id"));
			
			Bean p=new Bean();
			p.setStudent_name(name);
			p.setClass_id(class_id);
			p.setSchool_id(school_id);
			
			StudentDAO dao=new StudentDAO();
			int line=dao.updateStudent(p);
			if (line>0) {
				
			}
			request.getRequestDispatcher("/student_management/student_update_commit.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace(out);
			out.println("失敗");//error pageへ
		}
	}
}