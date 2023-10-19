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

import model.dao.SearchDAO;
import model.entity.CustomerBean;

@WebServlet("/customer-list")
public class SearchServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		// リクエストのエンコーディング
		request.setCharacterEncoding("UTF-8");

		// フォームから送信された値を取得
		String searchWord = request.getParameter("searchWord");

		SearchDAO dao = new SearchDAO(); // SearchDAOクラスをインスタンス化

		List<CustomerBean> customerList = new ArrayList<>();

		// データ登録のtry-catchエラー処理
		try {
			customerList = dao.SearchCustomer(searchWord);
			request.setAttribute("customerList", customerList);

			// 一覧ページへリダイレクト
			String url = "Customer_List.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("該当しません");

		}

	}
}