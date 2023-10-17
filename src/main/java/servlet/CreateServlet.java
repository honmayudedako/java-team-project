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

/**
 * Servlet implementation class CreateServlet
 */
@WebServlet("/CreateServlet")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストのエンコーディング
	    request.setCharacterEncoding("UTF-8");
		
		//　フォームから入力した値を取得
		CustomerBean customer = new CustomerBean(); 
		customer.setName(request.getParameter("customerName"));
		customer.setNameKana(request.getParameter("customerNameKana"));
		customer.setPostCode(request.getParameter("postCode"));
		customer.setAreaCode(request.getParameter("areaCode"));
		customer.setGender(request.getParameter("gender"));
		customer.setBirthday(request.getParameter("birthday"));
		customer.setPhoneNumber(request.getParameter("phoneNumber"));
		
		CustomerDAO dao = new CustomerDAO();
		// データ登録のtry-catchエラー処理
		String url = "";
		
		try {
			dao.createCustomer(customer);
			url = "create.jsp";
		} catch(ClassNotFoundException | SQLException e) {
			url = "login.jsp";
		}
		
		// リクエストスコープに入力値を一時的に表示
		String name = request.getParameter("customerName");
		request.setAttribute("message", name);
		
		// 一覧ページへリダイレクト
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
	    rd.forward(request, response);
	}

}
