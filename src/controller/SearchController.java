package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Music;
import service.MusicService;
import service.logic.MusicServiceLogic;

@WebServlet("/searchByName.do")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		MusicService service = new MusicServiceLogic();
		
		List<Music> list = service.findByName(request.getParameter("musicName"));
		request.setAttribute("musicList", list);
		
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}
}
