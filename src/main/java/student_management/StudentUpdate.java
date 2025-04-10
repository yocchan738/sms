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

@WebServlet(urlPatterns = { "/studentmanagement/update" })
public class StudentUpdate extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	PrintWriter out = response.getWriter();
        try {
        	int student_id = Integer.parseInt(request.getParameter("id"));
        	int class_id = 0;
        	int school_id = 0;
            StudentDAO dao = new StudentDAO();
            List<Bean> student_list = dao.searchStudent("");
            List<Bean> select_student = dao.searchStudentID(student_id);
            for (Bean b : select_student) {
            	class_id=b.getClass_id();
            	school_id=b.getSchool_id();
            }
            List<Bean> class_list = dao.searchClass("");
            List<Bean> school_list = dao.searchSchool("");
            
            List<Bean> select_class = dao.searchClassID(class_id);
            List<Bean> select_school = dao.searchSchoolID(school_id);
            request.setAttribute("student_list", student_list);
            request.setAttribute("select_student", select_student);
            request.setAttribute("class_list", class_list);
            request.setAttribute("select_class", select_class);
            request.setAttribute("school_list", school_list);
            request.setAttribute("select_school", select_school);
            request.getRequestDispatcher("/student_management/student_update.jsp").forward(request, response);
        } catch (Exception e) {
        	e.printStackTrace(out);
        }
        
    }
}
