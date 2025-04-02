package score_management;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Bean;
import dao.StudentDAO;

@WebServlet(urlPatterns = {"/scoremanagement/insert/commit"})
public class ScoreInsertCommit extends HttpServlet {

	public void doPost(
	        HttpServletRequest request, HttpServletResponse response
	    ) throws ServletException, IOException {
	        
	        // エラーハンドリング
	        try {
	            // フォームから送信されたパラメータを取得
	            int student_id = Integer.parseInt(request.getParameter("student_id"));
	            int subject_id = Integer.parseInt(request.getParameter("subject_id"));
	            int score_value = Integer.parseInt(request.getParameter("score_value"));

	            // Studentオブジェクトの作成とデータ設定
	            Bean s = new Bean();
	            s.setStudent_id(student_id);
	            s.setSubject_id(subject_id);
	            s.setScore_value(score_value);

	            // DAOを利用してデータベースに学生情報を追加
	            StudentDAO dao = new StudentDAO();
	            int line = dao.insertScores(s);
	            
	            // 挿入成功の場合、成功画面に遷移
	            if (line > 0) {
	                request.getRequestDispatcher("/score_management/score_insert_commit.jsp").forward(request, response);
	            }
	        } catch (Exception e) {
	            // 例外が発生した場合、失敗画面に遷移
	            request.getRequestDispatcher("/insert/failure.jsp").forward(request, response);
	        }
	    }
}
