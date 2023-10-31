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

@WebServlet("/permission")
public class PermissionServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 一覧ページへリダイレクト
		String url = "permission.jsp";
		
		//もしも権限が閲覧者ならばメニューページへリダイレクト
		HttpSession session = request.getSession();
		UserBean user = (UserBean) session.getAttribute("user");
		if (user.getAuthorityCode().equals("A0") || user.getAuthorityCode().equals("A1")) {
			url = "menu.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        String id = request.getParameter("user_id");
        String authorityCode = request.getParameter("authorityCode");

        UserDAO userDAO = new UserDAO();

        try {
            userDAO.setUserAuthority(id, authorityCode);
            response.sendRedirect("suc.jsp");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.sendRedirect("err.jsp");
        }
    }
}
