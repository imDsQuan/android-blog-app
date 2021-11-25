package web;

import java.io.IOException;
import java.sql.SQLException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.accountDAO.AccountDAOImpl;
import controller.customerDAO.CustomerDAOImpl;
import model.customer.Account;
import model.customer.Customer;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/views/main/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		AccountDAOImpl dao = new AccountDAOImpl();
		CustomerDAOImpl cusDao = new CustomerDAOImpl();
		Customer cus;
		Account a;
		try {
			a = dao.Login(username, password);
			cus = cusDao.getCustomerByID(dao.getCustomerIDByUsername(username));
			if(a == null) {
				request.setAttribute("mess", "Wrong username or password");
				request.getRequestDispatcher("/views/main/login.jsp").forward(request, response);
			}else {
				HttpSession session = request.getSession();
				session.setAttribute("acc", a);
				session.setAttribute("customer", cus);
				session.setMaxInactiveInterval(1000);
				response.sendRedirect("home");
			}
		} 
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
