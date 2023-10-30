package servlet;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.UserDAO;

@WebServlet("/permission")
public class PermissionServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 一覧ページへリダイレクト
		String url = "menu.jsp";
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
