package web.manage;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


import controller.shoeDAO.ShoeDAOImpl;
import model.shoe.Shoe;

/**
 * Servlet implementation class ManageClothes
 */
@WebServlet(urlPatterns = { "/manage/shoe/*" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50)
public class ManageShoe extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManageShoe() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getPathInfo());
		// TODO Auto-generated method stub
		String path;
		if (request.getPathInfo() != null) {
			path = request.getPathInfo();
		}
		else path = "";
		switch(path) {
			case "/create": 
				createShoe(request,response);
				break;
			case "/edit":
				editShoe(request,response);
				break;
			case "/manage/shoe/insert":
			try {
				insertShoe(request,response);
			} catch (ClassNotFoundException | IOException | ServletException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				break;
			case "/manage/shoe/update":
			try {
				updateShoe(request,response);
			} catch (ClassNotFoundException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				break;
			case "/delete":
			try {
				deleteShoe(request,response);
			} catch (ClassNotFoundException | SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				break;
			default:
				showShoe(request, response);
		}
		
		
	}
	
	
	

	private void updateShoe(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String brand = request.getParameter("brand");
		String material = request.getParameter("material");
		String price = request.getParameter("price");
		String discount = request.getParameter("discount");
		String typeShoe = request.getParameter("type");
        String warrantlyperiod = request.getParameter("warrantlyperiod");

		System.out.println(id + " " + name + " " + description + " " + brand + " " + material + " " + price + " " + discount + " " + typeShoe + " " + warrantlyperiod);
		
//		String id, String name, String description, String material, int discount, double price,
//		String typeClothes, String brand
		Shoe shoe = new Shoe(id, name, description, material, Integer.parseInt(discount), Double.parseDouble(price), typeShoe, brand,warrantlyperiod);
		ShoeDAOImpl dao = new ShoeDAOImpl();
		dao.updateShoe(shoe);
		response.sendRedirect("manage/shoe");
	}

	private void insertShoe(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String brand = request.getParameter("brand");
		String material = request.getParameter("material");
		String price = request.getParameter("price");
		String discount = request.getParameter("discount");
		String typeShoe = request.getParameter("type");
        String warrantlyperiod = request.getParameter("warrantlyperiod");
		System.out.println(id + " " + name + " " + description + " " + brand + " " + material + " " + price + " " + discount + " " + typeShoe + " " + warrantlyperiod);
//		String id, String name, String description, String material, int discount, double price,
//		String typeClothes, String brand
		Shoe shoe = new Shoe(name, description, material, Integer.parseInt(discount), Double.parseDouble(price), typeShoe, brand, warrantlyperiod );
		Part part1 = request.getPart("image1");
		Part part2 = request.getPart("image2");
		Part part3 = request.getPart("image3");
		Part part4 = request.getPart("image4");
		
		String fileName1 = part1.getSubmittedFileName();
		String fileName2 = part2.getSubmittedFileName();
		String fileName3 = part3.getSubmittedFileName();
		String fileName4 = part4.getSubmittedFileName();
		String savePath = "C:\\Users\\Tuan Cris\\git\\online_shop\\src\\main\\webapp\\views\\images\\shoe";
		savePath.replace('\\', '/');
		String filePath1 = savePath + File.separator + fileName1;
		String filePath2 = savePath + File.separator + fileName2;
		String filePath3 = savePath + File.separator + fileName3;
		String filePath4 = savePath + File.separator + fileName4;
		
		part1.write(filePath1);
		part2.write(filePath2);
		part3.write(filePath3);
		part4.write(filePath4);
		
		List<String> img = new ArrayList<>();
		img.add("images/shoe/" + fileName1);
		img.add("images/shoe/" + fileName2);
		img.add("images/shoe/" + fileName3);
		img.add("images/shoe/" + fileName4);
		
		shoe.setImage(img);
		
		ShoeDAOImpl dao = new ShoeDAOImpl();
		
		dao.insertShoe(shoe);
		
		response.sendRedirect("manage/shoe");
		
	}
	


	private void showShoe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ShoeDAOImpl dao = new ShoeDAOImpl();
		List<Shoe> list = null;
		try {
			list = dao.getAllShoe();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0; i < list.size();i++) {
			try {
				list.get(i).setImage(dao.getImghByShoeCode(list.get(i).getId()));
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		request.setAttribute("list", list);

		RequestDispatcher dispatcher = this.getServletContext()
				.getRequestDispatcher("/views/manage/manageShoe/manageShoeMain.jsp");
		dispatcher.forward(request, response);
	}

	private void deleteShoe(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		ShoeDAOImpl dao = new ShoeDAOImpl();
		dao.deleteShoe(id);
		response.sendRedirect("manage/shoe");
	}

	private void editShoe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Shoe shoe = null;
		ShoeDAOImpl dao = new ShoeDAOImpl();
		String id = request.getParameter("id");
		try {
			shoe = (Shoe) dao.getShoeByCode(id);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("shoe", shoe);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/views/manage/manageShoe/createShoeView.jsp");
		dispatcher.forward(request, response);
		
		
	}

	private void createShoe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/views/manage/manageShoe/createShoeView.jsp");
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
