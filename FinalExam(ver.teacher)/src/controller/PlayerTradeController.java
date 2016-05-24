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
 * PlayerTradeController<br>
 * - 선택한 선수와 타겟선수의 팀을 서로 교체한다.
 * 
 */
@WebServlet("/player/trade")
public class PlayerTradeController extends HttpServlet {

	/** UID */
	private static final long serialVersionUID = 2201065040602708104L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String sourcePlayerId = req.getParameter("sourcePlayerId");
		String targetPlayerId = req.getParameter("targetPlayerId");
		BaseballTeamService service = new BaseballTeamServiceLogic();
		service.tradePlayer(sourcePlayerId, targetPlayerId);
		
		resp.sendRedirect(req.getContextPath()+"/player/allList");
	}

}
