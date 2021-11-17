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
 * Servlet implementation class ClothesDetail
 */
@WebServlet(urlPatterns = {"/clothes-detail"})
public class ClothesDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClothesDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String code = request.getParameter("id");
		ClothesDAOImpl clothesDAO = new ClothesDAOImpl();
		Clothes clothes = null;
		List<Clothes> list = new ArrayList<>();
		try {
			 clothes = clothesDAO.getClothByCode(code);
			list = clothesDAO.getFourRandomClothes();
			 clothes.setImage(clothesDAO.getImghByClothCode(clothes.getId()));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int i = 0; i < list.size(); i++) {
			try {
				list.get(i).setImage(clothesDAO.getImghByClothCode(list.get(i).getId()));
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		request.setAttribute("list", list);
		request.setAttribute("clothes", clothes);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/views/clothes/clothes-detail.jsp");
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
