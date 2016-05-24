package favorite.servlet.favorite;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import favorite.service.FavoriteLogic;

/**
 * Servlet implementation class RemoveController
 */
@WebServlet("/remove.do")
public class RemoveController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private FavoriteLogic favorite = new FavoriteLogic();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		favorite.removeFavorite(id);
		response.sendRedirect("list.do");
	}

}
