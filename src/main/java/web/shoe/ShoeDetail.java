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
 * Servlet implementation class ClothesDetail
 */
@WebServlet(urlPatterns = {"/shoe-detail"})
public class ShoeDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoeDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String code = request.getParameter("id");
		ShoeDAOImpl shoeDAO = new ShoeDAOImpl();
		Shoe shoe = null;
		List<Shoe> list = new ArrayList<>();
		try {
			 shoe = shoeDAO.getShoeByCode(code);
			 
			list = shoeDAO.getFourRandomShoe();
			 shoe.setImage(shoeDAO.getImghByShoeCode(shoe.getId()));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int i = 0; i < list.size(); i++) {
			try {
				list.get(i).setImage(shoeDAO.getImghByShoeCode(list.get(i).getId()));
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		request.setAttribute("list", list);
		request.setAttribute("shoe", shoe);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/views/shoe/shoe-detail.jsp");
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
