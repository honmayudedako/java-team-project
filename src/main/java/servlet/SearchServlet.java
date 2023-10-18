package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.SearchDAO;

@WebServlet("/customer-list")
public class SearchServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// リクエストのエンコーディング
		request.setCharacterEncoding("UTF-8");

		// フォームから送信された値を取得
		String searchWord = request.getParameter("searchWord");

		SearchDAO dao = new SearchDAO(); // SearchDAOクラスをインスタンス化

		// データ登録のtry-catchエラー処理
		try {
			dao.createCustomer(customer);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("該当しません");
		}

		/*request.setAttribute("message", "登録完了");*/
		// 一覧ページへリダイレクト
		/*String url = "create.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);*/

	}
}