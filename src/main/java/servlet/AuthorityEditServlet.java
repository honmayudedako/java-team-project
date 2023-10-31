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

@WebServlet("/authority-edit")
public class AuthorityEditServlet extends HttpServlet {

	public AuthorityEditServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "authorityEdit.jsp";

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String authorityCode = request.getParameter("authorityCode");
		String userId = request.getParameter("userId");

		String url = "authorityEdit.jsp";

		try {
			UserDAO.setAuthority(authorityCode, userId);
			response.sendRedirect("menu.jsp");
		} catch (ClassNotFoundException | SQLException e) {
			url = "err.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
		}

	}
}
