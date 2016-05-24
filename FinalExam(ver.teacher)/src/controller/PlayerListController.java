package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BaseballTeam;
import service.BaseballTeamService;
import service.logic.BaseballTeamServiceLogic;

/**
 * PlayerListController<br>
 * - 선택한 팀의 선수 목록을 조회한다.
 * 
 */
@WebServlet("/player/list")
public class PlayerListController extends HttpServlet {

	/** UID */
	private static final long serialVersionUID = -8421778655710586578L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BaseballTeamService baseballService = new BaseballTeamServiceLogic();

		String teamId = req.getParameter("teamId");
		
		BaseballTeam team = baseballService.findTeam(teamId);
		List<BaseballTeam> teams = new ArrayList<BaseballTeam>();
		teams.add(team);
		
		int allPlayersCount = 0;
		if(team.getPlayers() != null) {
			allPlayersCount = team.getPlayers().size();
		}

		req.setAttribute("teams", teams);
		req.setAttribute("allPlayersCount", allPlayersCount);

		req.getRequestDispatcher("/views/player/playerList.jsp").forward(req, resp);
	}

}
