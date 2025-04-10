package authentication;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Authentication;
import dao.AuthenticationDAO;

@WebServlet(urlPatterns = {"/authentication/login"})
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String loginId = request.getParameter("login_id");
        String password = request.getParameter("password");
        
        try {
            AuthenticationDAO dao = new AuthenticationDAO();
            Authentication auth = dao.search(loginId, password);
            
            if (auth != null) {
               
                HttpSession session = request.getSession();
                session.setAttribute("user", auth);
                response.sendRedirect("login_success.jsp");
            } else {
                
                request.setAttribute("error", "Invalid login ID or password");
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}