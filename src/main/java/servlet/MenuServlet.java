package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "menu.jsp";
		
//		HttpSession session = request.getSession();
//		UserBean user = (UserBean)session.getAttribute("user");
//		if(user == null) {
//			url = "login.jsp";
//		} 
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		
		String path = "";
		
		if (request.getParameter("button").equals("顧客一覧")) {
			path = "/customer-list";
		} else if (request.getParameter("button").equals("顧客登録")) {
			path = "/create";
		} else if (request.getParameter("button").equals("権限編集") ) {
			path = "/authority-edit"; 
		} else if (request.getParameter("button").equals("顧客編集") ) {
			path = "/customer-edit"; 
		}
		
	    //メニューページにリダイレクト
  		response.sendRedirect(request.getContextPath() + path); 
	  		
	}

}
