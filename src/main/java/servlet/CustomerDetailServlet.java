package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CustomerDAO;
import model.entity.CustomerBean;

@WebServlet("/customer-detail")
public class CustomerDetailServlet extends HttpServlet {

	public CustomerDetailServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// リクエストのエンコーディング
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		String url = "detail.jsp";
		int searchId = Integer.parseInt(id);

		CustomerDAO dao = new CustomerDAO(); // DAOクラスをインスタンス化

		// データ登録のtry-catchエラー処理
		try {
			CustomerBean customer = dao.IDSearchCustomer(searchId);
			url = "detail.jsp";
			if (customer == null) {
				url = "menu.jsp";
			}
			request.setAttribute("customer", customer);

		} catch (ClassNotFoundException | SQLException e) {
			// エラーページへリダイレクト
			url = "err.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 一覧ページへリダイレクト
		String url = "list.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}