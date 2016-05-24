package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BaseballTeam;
import service.BaseballTeamService;

/**
 * PlayerAllListController <br>
 * - 선수 전체 목록을 조회한다.
 * 
 */
@WebServlet("/player/allList")
public class PlayerAllListController extends HttpServlet {

	/** UID */
	private static final long serialVersionUID = -8421778655710586578L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BaseballTeamService baseballService = new service.logic.BaseballTeamServiceLogic();

		List<BaseballTeam> teams = baseballService.findAllTeamsWithPlayers();

		int allPlayersCount = 0;
		for (BaseballTeam team : teams) {
			allPlayersCount += team.getPlayers().size();
		}

		req.setAttribute("teams", teams);
		req.setAttribute("allPlayersCount", allPlayersCount);

		req.getRequestDispatcher("/views/player/playerList.jsp").forward(req, resp);
	}

}
