package score_management;

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

@WebServlet(urlPatterns = {"/scoremanagement/update"})
public class ScoreUpdate extends HttpServlet {

	public void doPost(
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException{
		// 出力用PrintWriterを取得
        PrintWriter out = response.getWriter();
        
        try {
        	int score_id = Integer.parseInt(request.getParameter("score_id"));
        	int student_id = 0;
        	int subject_id = 0;
            // StudentDAOのインスタンス生成
            StudentDAO dao = new StudentDAO();
            
            // 成績情報の全件取得（検索キーワードに空文字を指定）
            List<Bean> list_scores = dao.searchScores("");
            
            // 学生情報の全件取得（検索キーワードに空文字を指定）
            List<Bean> list_student = dao.searchStudent("");
            
            // 科目情報の全件取得（検索キーワードに空文字を指定）
            List<Bean> list_subject = dao.searchSubject("");
            
            // "score_id" に基づき、該当する成績情報を取得
            List<Bean> select_scores = dao.searchScoresID(score_id);
            // 成績情報からそれぞれのIDを取得
            for (Bean b : select_scores) {
            	student_id = b.getStudent_id();
            	subject_id = b.getSubject_id();
            }
            
            // "student_id" に基づき、該当する学生情報を取得
            List<Bean> select_student = dao.searchStudentID(student_id);
            
            // "subject_id" に基づき、該当する学生情報を取得
            List<Bean> select_subject = dao.searchSubjectID(subject_id);
            
            // 取得したデータをリクエスト属性に設定
            request.setAttribute("list_scores", list_scores);
            request.setAttribute("select_scores", select_scores);
            request.setAttribute("list_student", list_student);
            request.setAttribute("select_student", select_student);
            request.setAttribute("list_subject", list_subject);
            request.setAttribute("select_subject", select_subject);
            
            // score_manegement/score_update.jsp にフォワードして画面表示
            request.getRequestDispatcher("/score_management/score_update.jsp").forward(request, response);
        } catch (Exception e) {
        	request.getRequestDispatcher("/top_page/error.jsp").forward(request, response);
        }
	}
}
