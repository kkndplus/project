package favorite.servlet.favorite;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import favorite.entity.Favorite;
import favorite.service.FavoriteLogic;

/**
 * Servlet implementation class ListController
 */
@WebServlet("/list.do")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private FavoriteLogic favorite = new FavoriteLogic();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Favorite> list = favorite.findAllFavorites();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/view/list.jsp").forward(request, response);
	}

}
