package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BaseballTeam;
import domain.Player;
import service.BaseballTeamService;

/**
 * PlayerTradeTargetListConroller<br>
 * - 1. 트레이드 대상 선수 목록(타겟선수의 팀을 제외한 모든 팀의 선수목록)을 조회한다.
 *      선수목록의 총 조회건수도 함께 보낸다. 
 * - 2. 타겟선수를 상세조회한다.
 * 
 */
@WebServlet("/player/tradeTargetList")
public class PlayerTradeTargetListConroller extends HttpServlet {

	/** UID */
	private static final long serialVersionUID = -8421778655710586578L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BaseballTeamService baseballService = new service.logic.BaseballTeamServiceLogic();

		String playerId = req.getParameter("playerId");
		String teamId = req.getParameter("teamId");
		
		List<BaseballTeam> teams = baseballService.findTradeTargetPalyers(teamId);
		Player tradePlayer = baseballService.findPlayer(playerId);
		
		int allPlayersCount = 0;
		for (BaseballTeam team : teams) {
			allPlayersCount += team.getPlayers().size();
		}

		req.setAttribute("teams", teams);
		req.setAttribute("tradePlayer", tradePlayer);
		req.setAttribute("allPlayersCount", allPlayersCount);

		req.getRequestDispatcher("/views/player/tradeTargetList.jsp").forward(req, resp);
	}

}
