package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MusicService;
import service.logic.MusicServiceLogic;

/**
 * Servlet implementation class DetailController
 */
@WebServlet("/detail.do")
public class DetailController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private MusicService musicService = new MusicServiceLogic();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		session.setAttribute("song", musicService.find(Integer.parseInt(id)));
		request.getRequestDispatcher("/WEB-INF/views/detail.jsp").forward(request, response);
		
	}

}
