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
import model.dao.SearchDAO;
import model.entity.AreaBean;
import model.entity.CustomerBean;
import validation.Validator;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/customer-edit")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		SearchDAO dao = new SearchDAO();
		try {
			List<AreaBean> areaList = AreaDAO.areaList();
			request.setAttribute("areaList", areaList);
			CustomerBean customer = dao.IDSearchCustomer(id);
			String url = "customerEdit.jsp";
			if (customer == null) {
				url = "menu.jsp";
			}
			request.setAttribute("customer", customer);
			
			//フォワード
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			RequestDispatcher rd = request.getRequestDispatcher("err.jsp");
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
		
		// データ登録のtry-catchエラー処理
		String url = "create.jsp";
		errors = Validator.CustomerValidator(customer);
		request.setAttribute("customer", customer);
		url = "customerEdit.jsp";
		if(!errors.isEmpty()) {
			
			//リクエストスコープにエラーメッセージを保存
			request.setAttribute("errors", errors);
		} else {
			try {
				List<AreaBean> areaList = AreaDAO.areaList();
				request.setAttribute("areaList", areaList);
				dao.editCustomer(customer);
				request.setAttribute("success", "情報の変更が完了しました");
			} catch(ClassNotFoundException | SQLException e) {
				request.setAttribute("sqlFailed", "情報の登録に失敗しました"+e.getMessage());
			}
		}
		
		// フォワード
		RequestDispatcher rd = request.getRequestDispatcher(url);
	    rd.forward(request, response);
	}

}
