package web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.customerDAO.CustomerDAOImpl;
import model.customer.Account;
import model.customer.Address;
import model.customer.Customer;
import model.customer.FullName;

import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.Date;  
/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet(urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		FullName fullname = new FullName(firstname, lastname);
		String dob = request.getParameter("dob");
		String tel = request.getParameter("tel");
		String homeNo = request.getParameter("homeNo");
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String district = request.getParameter("district");
		Address address = new Address(Integer.parseInt(homeNo), street, city, district);
		System.out.println(firstname + lastname + dob + tel + homeNo + street + city + district);
		Date date1 = null;
		try {
			date1 = new SimpleDateFormat("dd/MM/yyyy").parse(dob);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String gender = request.getParameter("gender");
		HttpSession session = request.getSession();
		Account acc = (Account) session.getAttribute("resgisterAccount");
		System.out.println(acc.getUsername() + acc.getPassword());
		System.out.println();
		Customer customer = new Customer(tel, new SimpleDateFormat("yyyy-MM-dd").format(date1), gender, fullname, address);
		customer.setAccount(acc);
		CustomerDAOImpl dao = new CustomerDAOImpl();
		try {
			dao.insertCustomer(customer);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int theLast = 0;
		try {
			theLast = dao.getTheLastRecords();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			dao.insertAccount(theLast, acc);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			dao.insertAddress(theLast, address);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			dao.insertFullName(theLast, fullname);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("login");
		
		
		
	}

}
