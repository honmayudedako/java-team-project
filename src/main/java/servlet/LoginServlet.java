package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.UserDAO;
import model.entity.UserBean;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	* @see HttpServlet#HttpServlet()
	*/
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		UserBean user = (UserBean) session.getAttribute("user");
		// セッションにuserインスタンスが保存されているかを確認
		if (user != null) {
			//ログインしていればメニューページにリダイレクト
			response.sendRedirect(request.getContextPath() + "/menu");
		} else {
			//ログインしていなければログインページにフォワード
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストのエンコーディング
		request.setCharacterEncoding("UTF-8");

		// リクエストパラメータの取得
		String id = request.getParameter("id"); // ユーザID
		String password = request.getParameter("password"); // パスワード
		String url = "menu.jsp"; // メニュー画面のパス
		String loginError = "";
		UserDAO dao = new UserDAO(); // UserDAOクラスをインスタンス化

		// try-catchで例外処理
		try {
			// UserDAOクラスのcheckLoginメソッドを呼び出してユーザ情報を取得
			UserBean user = dao.checkLogin(id, password);
			// idとpasswordがデータベースに登録されていた場合
			if (user != null) {
				user.setAuthenticated(true);
				// セッションオブジェクト取得し、セッションスコープに値をセット
				HttpSession session = request.getSession();
				session.setAttribute("user", user);

				//メニューページにリダイレクト		
				url = "menu.jsp";
			} 
			// idとpasswordが未入力の場合
			else if (id == "" && password == "") {
				loginError = "ログインIDとパスワードが未入力です";
				url = "login.jsp";
			}
			// idとpasswordがデータベースに登録されていなかった場合
			else {
				loginError = "ログインID、またはパスワードが正しくありません";
				url = "login.jsp";
			}
			request.setAttribute("loginError", loginError);
		} catch (ClassNotFoundException | SQLException e) {
			url = "err.jsp"; // エラーページのパス
			e.printStackTrace();
		} 
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);		
	}
}
