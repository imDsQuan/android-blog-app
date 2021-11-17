package web.cart;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.*;
import controller.clothesDAO.ClothesDAOImpl;
import model.cart.Cart;
import model.clothes.Clothes;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet(urlPatterns = { "/cart" })
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartServlet() {
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
		String action = request.getParameter("action");
		System.out.println(action);
		switch (action) {
		case "view":
			viewCart(request, response);
			break;
		case "delete":
			deleteItem(request, response);
			break;
		case "sub":
			subItem(request, response);
			break;
		case "add":
			addItem(request, response);
			break;

		}
	}

	private void addItem(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String type = request.getParameter("type");
		System.out.println(type);
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		if (type.equalsIgnoreCase("model.clothes.Clothes")) {
			String id = request.getParameter("id");
			String action = request.getParameter("action");
			System.out.println("ID = " + id);
			System.out.println("Action = " + action);
			cart.addQuantityClothes(id);

		}
		session.setAttribute("cart", cart);
		response.sendRedirect("/Online-Shop/cart?action=view");

	}

	private void subItem(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String type = request.getParameter("type");
		System.out.println(type);
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		if (type.equalsIgnoreCase("model.clothes.Clothes")) {
			String id = request.getParameter("id");
			String action = request.getParameter("action");
			System.out.println("ID = " + id);
			System.out.println("Action = " + action);
			cart.subQuantityClothes(id);

		}
		session.setAttribute("cart", cart);
		response.sendRedirect("/Online-Shop/cart?action=view");

	}

	private void deleteItem(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String type = request.getParameter("type");
		System.out.println(type);
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null)
			cart = new Cart();
		if (type.equalsIgnoreCase("model.clothes.Clothes")) {
			String id = request.getParameter("id");
			try {
				cart.delClothesItem(id);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		session.setAttribute("cart", cart);
		response.sendRedirect("/Online-Shop/cart?action=view");

	}

	private void viewCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		double total = 0;
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null)
			cart = new Cart();
		total = cart.totalMoney();
		List<Clothes> listClothes = new ArrayList<>();
		for (int i = 0; i < cart.numberOfClothes(); i++) {
			Clothes clothes = cart.getClothesItem(i);
			listClothes.add(clothes);
		}

		ClothesDAOImpl clothesDAO = new ClothesDAOImpl();

		for (int i = 0; i < listClothes.size(); i++) {
			try {
				listClothes.get(i).setImage(clothesDAO.getImghByClothCode(listClothes.get(i).getId()));
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("Total:" + total);
		double sum = Math.round(total * 1.1 * 100.0) / 100.0;
		request.setAttribute("listClothes", listClothes);
		request.setAttribute("subtotal", total);
		request.setAttribute("tax", Math.round(total * 0.1 * 100.0) / 100.0);
		request.setAttribute("total", sum);

		RequestDispatcher dispatcher = request.getRequestDispatcher("views/main/cart.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
