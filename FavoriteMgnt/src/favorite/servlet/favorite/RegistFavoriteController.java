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
 * Servlet implementation class RegistController
 */
@WebServlet("/registFavorite.do")
public class RegistFavoriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private FavoriteLogic favorite = new FavoriteLogic();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/view/registFavorite.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Favorite faver = new Favorite();
		String url = request.getParameter("url");
		String description = request.getParameter("description");
		String code = request.getParameter("category");
		Category cat = Category.getByCode(code);
		faver.setUrl(url);
		faver.setDescription(description);
		faver.setCategory(cat);
		favorite.registerFavorite(faver);
		response.sendRedirect("list.do");
	}

}
