package web.shoe;

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

import controller.shoeDAO.ShoeDAOImpl;
import model.shoe.Shoe;

/**
 * Servlet implementation class TypeClothes
 */
@WebServlet(urlPatterns = {"/shoe/typeshoe"})

public class TypeShoe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TypeShoe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type = request.getParameter("type");
		type = String.valueOf(type.charAt(0)).toUpperCase() + type.substring(1);
		System.out.println("Category: " + type);
		int page = 1;
		int recordsPerPage = 20;
		
		if(request.getParameter("page") != null)
			page = Integer.parseInt(request.getParameter("page"));
		
		ShoeDAOImpl shoeDAO = new ShoeDAOImpl();
		List<Shoe> shoe = new ArrayList<>();
		
		int totalPage = 0;
		
		String option = request.getParameter("search-option");

		try {
			totalPage= shoeDAO.totalShoeForType(type)/recordsPerPage + 1;
			shoe = shoeDAO.getShoeByType(type,(page-1)*recordsPerPage, recordsPerPage, option);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int noOfRecords = shoeDAO.getNoOfRecords();
		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
		
		for (int i = 0; i < shoe.size(); i++) {
			try {
				shoe.get(i).setImage(shoeDAO.getImghByShoeCode(shoe.get(i).getId()));
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println(noOfPages + " " + page + " " + totalPage);
		
		request.setAttribute("shoeList", shoe);
		request.setAttribute("typeShoe", type);
		request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
        request.setAttribute("totalPage", totalPage);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/views/shoe/type-shoe.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
