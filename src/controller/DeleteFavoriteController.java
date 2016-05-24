package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.User;
import service.UserMusicService;
import service.logic.UserMusicServiceLogic;

@WebServlet("/deleteFavorite.do")
public class DeleteFavoriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserMusicService service = new UserMusicServiceLogic();

		HttpSession session = request.getSession();
		if (session == null || session.getAttribute("loginedUser") == null) {
			response.sendRedirect("login.do");
		}else{
			int id = Integer.parseInt(request.getParameter("musicId"));

			User user = (User) session.getAttribute("loginedUser");
			service.remove(user.getLoginId(), id);

			response.sendRedirect("favoriteList.do");
		}
	}
}
