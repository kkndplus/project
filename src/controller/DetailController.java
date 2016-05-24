package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Music;
import service.MusicService;
import service.logic.MusicServiceLogic;

@WebServlet("/detail.do")
public class DetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		MusicService service = new MusicServiceLogic();
		String musicId = request.getParameter("musicId");
		
		Music music = (Music)service.find(Integer.parseInt(musicId));
		
		request.setAttribute("music", music);
		
		request.getRequestDispatcher("detail.jsp").forward(request, response);
		
	}
}
