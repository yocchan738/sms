package student_manegement;

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

@WebServlet(urlPatterns = { "/studentmanegement/studentupdate" })
public class StudentUpdate extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	PrintWriter out = response.getWriter();
        try {
            StudentDAO dao = new StudentDAO();
            List<Bean> student = dao.searchStudent("");

            request.setAttribute("student", student);
            request.getRequestDispatcher("/student_manegement/student_update.jsp").forward(request, response);
        } catch (Exception e) {
        	e.printStackTrace(out);
        }
        
    }
}
