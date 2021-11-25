package web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.accountDAO.AccountDAOImpl;
import model.customer.Account;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet(urlPatterns = { "/sign-up" })
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignUpServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		AccountDAOImpl dao = new AccountDAOImpl();
		Account a = null;

		try {
			a = dao.getAccountByUsername(username);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (a != null) {
			request.setAttribute("messError", "Username already exists!");
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/views/main/login.jsp");
			dispatcher.forward(request, response);
		} else {
			Account resAcc = new Account(username, password);

			HttpSession session = request.getSession();
			session.setAttribute("resgisterAccount", resAcc);

			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/views/main/registerForm.jsp");
			dispatcher.forward(request, response);

		}

	}

}
