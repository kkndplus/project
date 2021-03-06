package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BaseballTeam;
import service.BaseballTeamService;
import service.logic.BaseballTeamServiceLogic;

/**
 * Servlet implementation class TeamDetailController
 */
@WebServlet("/teamDetail.do")
public class TeamDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BaseballTeamService service = new BaseballTeamServiceLogic();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		BaseballTeam team = service.findTeam(id);
		System.out.println(id);
		System.out.println(team.getTeamId());
		request.setAttribute("team", team);
		request.setAttribute("players", service.findPlayerByTeam(id));
		request.getRequestDispatcher("/WEB-INF/views/teamDetail.jsp").forward(request, response);
	}

}
