package subject_management;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Bean;
import dao.StudentDAO;

@WebServlet(urlPatterns = {"/subjectmanagement/insert/commit"})
public class SubjectInsertCommit extends HttpServlet{

	// doPostメソッド：フォームから送信されたデータを処理
    public void doPost(
        HttpServletRequest request, HttpServletResponse response
    ) throws ServletException, IOException {
        
        // エラーハンドリング
        try {
            // フォームから送信されたパラメータを取得
            String subject_name = request.getParameter("subject_name");
            int teacher_id = Integer.parseInt(request.getParameter("teacher_id"));

            // Studentオブジェクトの作成とデータ設定
            Bean s = new Bean();
            s.setSubject_name(subject_name);
            s.setTeacher_id(teacher_id);

            // DAOを利用してデータベースに学生情報を追加
            StudentDAO dao = new StudentDAO();
            int line = dao.insertSubject(s);
            
            // 挿入成功の場合、成功画面に遷移
            if (line > 0) {
                request.getRequestDispatcher("/subject_management/subject_insert_commit.jsp").forward(request, response);
            }
        } catch (Exception e) {
            // 例外が発生した場合、失敗画面に遷移
        	request.getRequestDispatcher("/top_page/error.jsp").forward(request, response);
        }
    }
}
