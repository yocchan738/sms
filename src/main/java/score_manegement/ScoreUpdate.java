package score_manegement;

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

@WebServlet(urlPatterns = {"/scoremanegement/update"})
public class ScoreUpdate extends HttpServlet {

	public void doPost(
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException{
		// 出力用PrintWriterを取得
        PrintWriter out = response.getWriter();
        
        try {
        	int score_id = Integer.parseInt(request.getParameter("score_id"));
            // StudentDAOのインスタンス生成
            StudentDAO dao = new StudentDAO();
            
            // 成績情報の全件取得（検索キーワードに空文字を指定）
            List<Bean> list_scores = dao.searchScores("");
            
            // リクエストパラメータ "score_id" に基づき、該当する学生情報を取得
            List<Bean> select_scores = dao.searchScoresID(score_id);
            
            // 取得したデータをリクエスト属性に設定
            request.setAttribute("list", list_scores);
            request.setAttribute("list_s", select_scores);
            
            // update/input.jsp にフォワードして画面表示
            request.getRequestDispatcher("/update/input.jsp").forward(request, response);
        } catch (Exception e) {
            // 例外発生時、エラーメッセージのスタックトレースを出力
            e.printStackTrace(out);
        }
	}
}
