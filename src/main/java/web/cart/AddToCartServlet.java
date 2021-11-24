package web.cart;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.clothesDAO.*;
import model.clothes.*;
import model.cart.Cart;
import controller.shoeDAO.*;
import model.shoe.*;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet(urlPatterns = { "/add-to-cart" })
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddToCartServlet() {
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
		// TODO Auto-generated method stub

		String type = request.getParameter("type");
		if (type.equals("model.clothes.Clothes")) {
			addClothes(request, response);
		} else if (type.equals("model.book.Book")) {
			addBook(request, response);
		} else if (type.equals("model.electronic.Electronic")) {
			addElectronic(request, response);
		} else if (type.equals("model.shoe.Shoe")) {
			addShoe(request, response);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/cart?action=view");
		dispatcher.forward(request, response);
	}

	
	private void addElectronic(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void addBook(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	public void addClothes(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null)
			cart = new Cart();
		String id = request.getParameter("id");
		String size = request.getParameter("size");
		String amount = request.getParameter("amount");
		int am = Integer.parseInt(amount);
		Clothes clothes = null;
		ClothesDAOImpl dao = new ClothesDAOImpl();
		if (am > 0) {
			try {
				clothes = dao.getClothByCode(id);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		clothes.setSize(size);
		clothes.setAmount(am);
		cart.addClothesToCart(clothes);
		session.setAttribute("cart", cart);
	}
	
	
	public void addShoe(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null)
			cart = new Cart();
		String id = request.getParameter("id");
		String size = request.getParameter("size");
		String amount = request.getParameter("amount");
		int am = Integer.parseInt(amount);
		Shoe shoe = null;
		ShoeDAOImpl dao = new ShoeDAOImpl();
		if (am > 0) {
			try {
				shoe = dao.getShoeByCode(id);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		shoe.setSize(size);
		shoe.setAmount(am);
		cart.addShoeToCart(shoe);
		session.setAttribute("cart", cart);
	}

}
