package web.manage;

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
import controller.managerAccountDAO.ManagerAccountDAOImpl;
import model.customer.Account;

/**
 * Servlet implementation class ManageLogin
 */
@WebServlet(urlPatterns = {"/manager-login"})
public class ManageLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/views/manage/manageLogin.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		ManagerAccountDAOImpl dao = new ManagerAccountDAOImpl();
		Account account;
		try {
			account = dao.getManagerAccount(username, password);
			if(account == null) {
				request.setAttribute("mess", "Wrong username or password");
				request.getRequestDispatcher("/views/manage/manageLogin.jsp").forward(request, response);
			}else {
				HttpSession session = request.getSession();
				session.setAttribute("managerAccount", account);
				session.setMaxInactiveInterval(1000);
				response.sendRedirect("manage");
			}
		} 
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
