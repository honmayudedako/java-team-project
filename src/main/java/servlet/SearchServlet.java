package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CustomerDAO;
import model.entity.CustomerBean;

@WebServlet("/customer-list")
public class SearchServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストのエンコーディング
		request.setCharacterEncoding("UTF-8");

		// 一覧ページへリダイレクト
		String url = "list.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストのエンコーディング
		request.setCharacterEncoding("UTF-8");

		// フォームから送信された値を取得
		String searchWord = request.getParameter("searchWord");

		CustomerDAO dao = new CustomerDAO(); // DAOクラスをインスタンス化

		List<CustomerBean> customerList = new ArrayList<>();
		String url = "list.jsp";
		// データ登録のtry-catchエラー処理
		try {
			customerList = dao.SearchCustomer(searchWord);
			request.setAttribute("customerList", customerList);
			// 一覧ページへリダイレクト
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("該当しません");
			// エラーページへリダイレクト
			url = "err.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}