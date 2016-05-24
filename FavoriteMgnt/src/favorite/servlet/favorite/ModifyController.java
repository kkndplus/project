package favorite.servlet.favorite;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import favorite.entity.Category;
import favorite.entity.Favorite;
import favorite.service.FavoriteLogic;

/**
 * Servlet implementation class ModifyController
 */
@WebServlet("/modify.do")
public class ModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private FavoriteLogic favorite = new FavoriteLogic();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Favorite favor = favorite.findFavorite(id);
		String cat = favor.getCategory().getCode();
		request.setAttribute("favor", favor);
		request.setAttribute("cat", cat);
		request.getRequestDispatcher("/view/modify.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String url = request.getParameter("url");
		String desc = request.getParameter("description");
		String code = request.getParameter("selCategory");
		Favorite favor = new Favorite(url,desc,Category.getByCode(code));
		favor.setId(id);
		favorite.modifyFavorite(favor);
		response.sendRedirect("list.do");
	}

}
