package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CustomerDetailDAO;
import model.entity.CustomerBean;

@WebServlet("/customerDetail")
public class CustomerDetailServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.getWriter().append("Served at: ").append(request.getContextPath());
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        CustomerDetailDAO dao = new CustomerDetailDAO();
        List<CustomerBean> customerDetailList = dao.getCustomerDetails(customerId);
        request.setAttribute("customerDetailList", customerDetailList);
        request.getRequestDispatcher("/customerDetail.jsp").forward(request, response);
    }
}
