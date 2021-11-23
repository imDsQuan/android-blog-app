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

import controller.clothesDAO.ClothesDAOImpl;
import model.clothes.Clothes;

/**
 * Servlet implementation class ManageClothes
 */
@WebServlet(urlPatterns = { "/manage/clothes/*" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50)
public class ManageClothes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManageClothes() {
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
				createClothes(request,response);
				break;
			case "/edit":
				editClothes(request,response);
				break;
			case "/manage/clothes/insert":
			try {
				insertClothes(request,response);
			} catch (ClassNotFoundException | IOException | ServletException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				break;
			case "/manage/clothes/update":
			try {
				updateClothes(request,response);
			} catch (ClassNotFoundException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				break;
			case "/delete":
			try {
				deleteClothes(request,response);
			} catch (ClassNotFoundException | SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				break;
			default:
				showClothes(request, response);
		}
		
		
	}
	
	
	

	private void updateClothes(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String brand = request.getParameter("brand");
		String material = request.getParameter("material");
		String price = request.getParameter("price");
		String discount = request.getParameter("discount");
		String typeClothes = request.getParameter("type");
		System.out.println(id + " " + name + " " + description + " " + brand + " " + material + " " + price + " " + discount + " " + typeClothes);
		
//		String id, String name, String description, String material, int discount, double price,
//		String typeClothes, String brand
		Clothes clothes = new Clothes(id, name, description, material, Integer.parseInt(discount), Double.parseDouble(price), typeClothes, brand);
		ClothesDAOImpl dao = new ClothesDAOImpl();
		dao.updateClothes(clothes);
		response.sendRedirect("manage/clothes");
	}

	private void insertClothes(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String brand = request.getParameter("brand");
		String material = request.getParameter("material");
		String price = request.getParameter("price");
		String discount = request.getParameter("discount");
		String typeClothes = request.getParameter("type");
		System.out.println(id + " " + name + " " + description + " " + brand + " " + material + " " + price + " " + discount + " " + typeClothes);
//		String id, String name, String description, String material, int discount, double price,
//		String typeClothes, String brand
		Clothes clothes = new Clothes(name, description, material, Integer.parseInt(discount), Double.parseDouble(price), typeClothes, brand);
		Part part1 = request.getPart("image1");
		Part part2 = request.getPart("image2");
		Part part3 = request.getPart("image3");
		Part part4 = request.getPart("image4");
		
		String fileName1 = part1.getSubmittedFileName();
		String fileName2 = part2.getSubmittedFileName();
		String fileName3 = part3.getSubmittedFileName();
		String fileName4 = part4.getSubmittedFileName();
		String savePath = "C:\\Users\\Admin\\eclipse-workspace\\Online-Shop\\src\\main\\webapp\\views\\images\\clothes";
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
		img.add("images/clothes/" + fileName1);
		img.add("images/clothes/" + fileName2);
		img.add("images/clothes/" + fileName3);
		img.add("images/clothes/" + fileName4);
		
		clothes.setImage(img);
		
		ClothesDAOImpl dao = new ClothesDAOImpl();
		
		dao.insertClothes(clothes);
		
		response.sendRedirect("manage/clothes");
		
	}
	


	private void showClothes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ClothesDAOImpl dao = new ClothesDAOImpl();
		List<Clothes> list = null;
		try {
			list = dao.getAllClothes();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0; i < list.size();i++) {
			try {
				list.get(i).setImage(dao.getImghByClothCode(list.get(i).getId()));
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		request.setAttribute("list", list);

		RequestDispatcher dispatcher = this.getServletContext()
				.getRequestDispatcher("/views/manage/manageClothes/manageClothesMain.jsp");
		dispatcher.forward(request, response);
	}

	private void deleteClothes(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		ClothesDAOImpl dao = new ClothesDAOImpl();
		dao.deleteClothes(id);
		response.sendRedirect("manage/clothes");
	}

	private void editClothes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Clothes clothes = null;
		ClothesDAOImpl dao = new ClothesDAOImpl();
		String id = request.getParameter("id");
		try {
			clothes = (Clothes) dao.getClothByCode(id);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("clothes", clothes);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/views/manage/manageClothes/createClothesView.jsp");
		dispatcher.forward(request, response);
		
		
	}

	private void createClothes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/views/manage/manageClothes/createClothesView.jsp");
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
