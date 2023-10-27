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
		String url = "edit.jsp";
		int searchId = 0;
		try {
			searchId = Integer.parseInt(id);
		} catch (NumberFormatException e) {
			url = "list.jsp";
		}
		
		CustomerDAO dao = new CustomerDAO();
		try {
			List<AreaBean> areaList = AreaDAO.areaList();
			request.setAttribute("areaList", areaList);
			CustomerBean customer = dao.IDSearchCustomer(searchId);
			
			if (customer == null) {
				url = "menu.jsp";
			}
			request.setAttribute("customer", customer);

		} catch (ClassNotFoundException | SQLException e) {
			url = "err.jsp";
		}
		//フォワード
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストのエンコーディング
	    request.setCharacterEncoding("UTF-8");
	    int customerId = Integer.parseInt(request.getParameter("customerId"));
		
		//　フォームから入力した値を取得
		CustomerBean customer = new CustomerBean();
		customer.setId(customerId);
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
		
		errors = Validator.CustomerValidator(customer);
		request.setAttribute("customer", customer);
		String url = "edit.jsp";
		
		try {
			List<AreaBean> areaList = AreaDAO.areaList();
			request.setAttribute("areaList", areaList);
		} catch(ClassNotFoundException | SQLException e) {	
		}
		
		if(!errors.isEmpty()) {
			//リクエストスコープにエラーメッセージを保存
			request.setAttribute("id", customerId);
			request.setAttribute("errors", errors);
			//response.sendRedirect(request.getContextPath() + "/customer-edit?id=" + URLEncoder.encode(request.getParameter("customerId"), "UTF-8"));
		} else {
			try {
				dao.editCustomer(customer);
				request.setAttribute("success", "情報の変更が完了しました");
			} catch(ClassNotFoundException | SQLException e) {
				request.setAttribute("sqlFailed", "情報の登録に失敗しました"+e.getMessage());
			} finally {
				
			}
		}
		// フォワード
		RequestDispatcher rd = request.getRequestDispatcher(url);
	    rd.forward(request, response);
	    //response.sendRedirect(request.getContextPath() + "/customer-edit?id=" + URLEncoder.encode(customerId, "UTF-8"));
	}

}
