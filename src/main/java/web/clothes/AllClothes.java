package web.clothes;

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

import controller.clothesDAO.ClothesDAOImpl;
import model.clothes.Clothes;

/**
 * Servlet implementation class AllClothes
 */
@WebServlet(urlPatterns = {"/clothes"})
public class AllClothes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllClothes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String option = request.getParameter("search-option");
		
		System.out.println("Search option: " + option);
		
		
		int page = 1;
		int recordsPerPage = 20;
		
		if(request.getParameter("page") != null)
			page = Integer.parseInt(request.getParameter("page"));
		
		ClothesDAOImpl clothesDAO = new ClothesDAOImpl();
		List<Clothes> clothes = new ArrayList<>();
		
		int totalPage = 0;
		
		try {
			totalPage= clothesDAO.totalClothes()/recordsPerPage + 1;
			clothes = clothesDAO.getRecords((page-1)*recordsPerPage, recordsPerPage, option);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int noOfRecords = clothesDAO.getNoOfRecords();
		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
		
		for (int i = 0; i < clothes.size(); i++) {
			try {
				clothes.get(i).setImage(clothesDAO.getImghByClothCode(clothes.get(i).getId()));
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println(noOfPages + " " + page + " " + totalPage);
		
		
		
		request.setAttribute("clothesList", clothes);
		request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
        request.setAttribute("totalPage", totalPage);
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/views/clothes/all-clothes.jsp");
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
