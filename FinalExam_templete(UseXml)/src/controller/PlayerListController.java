package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BaseballTeamService;
import service.logic.BaseballTeamServiceLogic;

/**
 * Servlet implementation class PlayListController
 */
@WebServlet("/playerList.do")
public class PlayerListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BaseballTeamService service = new BaseballTeamServiceLogic();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String teamId = request.getParameter("id");
		if (teamId !=null) {
			request.setAttribute("player", service.findPlayerByTeam(teamId));
			request.setAttribute("team", service.findTeam(teamId));
		} else {
			request.setAttribute("allList", service.findAllTeamsWithPlayers());
		}
		request.getRequestDispatcher("/WEB-INF/views/playerList.jsp").forward(request, response);
	}

}
