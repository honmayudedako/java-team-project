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

import model.dao.AreaDAO;
import model.dao.CustomerDAO;
import model.entity.AreaBean;
import model.entity.CustomerBean;
import validation.Validator;

/**
 * Servlet implementation class CreateServlet
 */
@WebServlet("/create")
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
		String url = "create.jsp";
		try {
			List<AreaBean> areaList = AreaDAO.areaList();
			request.setAttribute("areaList", areaList);	
		} catch (ClassNotFoundException | SQLException e) {
			url = "err.jsp";
		} finally {
			// フォワード
			RequestDispatcher rd = request.getRequestDispatcher(url);
		    rd.forward(request, response);
		}
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
		List<String> errors = new ArrayList<>();
		
		String url = "create.jsp";
		
		try {
			List<AreaBean> areaList = AreaDAO.areaList();
			request.setAttribute("areaList", areaList);	
		} catch (ClassNotFoundException | SQLException e) {
			url = "err.jsp";
		} 
		
		// データ登録のtry-catchエラー処理	
		errors = Validator.CustomerValidator(customer);
		if(!errors.isEmpty()) {
			//url = "create.jsp";
			//リクエストスコープにエラーメッセージを保存
			request.setAttribute("errors", errors);
		} else {
			try {
				dao.createCustomer(customer);
				url = "list.jsp";
			} catch(ClassNotFoundException | SQLException e) {
				request.setAttribute("sqlFailed", "情報の登録に失敗しました"+e.getMessage());
				//url = "create.jsp";
			}
		}
		// フォワード
		RequestDispatcher rd = request.getRequestDispatcher(url);
	    rd.forward(request, response);
	}

}
