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
import service.logic.BaseballTeamServiceLogic;

/**
 * Servlet implementation class TradeTargetListController
 */
@WebServlet("/tradeTargetList.do")
public class TradeTargetListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BaseballTeamService service = new BaseballTeamServiceLogic();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String playerId = request.getParameter("id");
		Player target = service.findPlayer(playerId);
		String teamId = target.getTeamId();
		request.setAttribute("target", target);
		List<BaseballTeam> list = service.findTradeTargetPlayers(teamId);
		request.setAttribute("tradelist", list);

		request.getRequestDispatcher("/WEB-INF/views/tradeTargetList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String targetPlayerId = request.getParameter("targetPlayer");
		String sourcePlayerId = request.getParameter("sourcePlayerId");
		service.tradePlayer(sourcePlayerId, targetPlayerId);
		
		response.sendRedirect(request.getContextPath());
	}

}
