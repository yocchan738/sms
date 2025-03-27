package subject_manegement;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Bean;
import dao.StudentDAO;

@WebServlet(urlPatterns = {"/subjectmanegement/update/commit"})
public class SubjectUpdateCommit extends HttpServlet{

	// doPostメソッド：フォームから送信されたデータを処理
    public void doPost(
        HttpServletRequest request, HttpServletResponse response
    ) throws ServletException, IOException {
    	PrintWriter out=response.getWriter();
        
        // エラーハンドリング
        try {
            // フォームから送信されたパラメータを取得
        	int subject_id = Integer.parseInt(request.getParameter("subject_id"));
            String subject_name = request.getParameter("subject_name");
            int teacher_id = Integer.parseInt(request.getParameter("teacher_id"));

            // Studentオブジェクトの作成とデータ設定
            Bean s = new Bean();
            s.setSubject_id(subject_id);
            s.setSubject_name(subject_name);
            s.setTeacher_id(teacher_id);

            // DAOを利用してデータベースに学生情報を追加
            StudentDAO dao = new StudentDAO();
            int line = dao.updateSubjects(s);
            
            // 挿入成功の場合、成功画面に遷移
            if (line > 0) {
                request.getRequestDispatcher("/subject_manegement/subject_update_commit.jsp").forward(request, response);
            }
        } catch (Exception e) {
            // 例外が発生した場合、失敗画面に遷移
            //request.getRequestDispatcher("/errorpage/error.jsp").forward(request, response);
        	e.printStackTrace(out);
        }
    }
}
