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
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/customer-delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		int searchId = 0;
		try {
			searchId = Integer.parseInt(id);
		} catch (NumberFormatException e) {
			RequestDispatcher rd = request.getRequestDispatcher("Customer_List.jsp");
			rd.forward(request, response);
		}
		
		CustomerDAO dao = new CustomerDAO();
		try {			
			CustomerBean customer = dao.IDSearchCustomer(searchId);
			
			String url = "customerDelete.jsp";
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
		//削除ボタンを押したとき
		request.setCharacterEncoding("UTF-8");
		String customerId = request.getParameter("customerId");
		try {
			CustomerDAO.deleteCustomer(customerId);
			response.sendRedirect(request.getContextPath() + "/customer-list"); 
		} catch (ClassNotFoundException | SQLException e) {
			
		}
		
	}

}
