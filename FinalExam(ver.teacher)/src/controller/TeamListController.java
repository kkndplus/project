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
import service.logic.BaseballTeamServiceLogic;

/**
 * TeamListController<br>
 * - 야구팀 전체 목록을 조회한다.
 * 
 */
@WebServlet("/team/list")
public class TeamListController extends HttpServlet {

	/** UID */
	private static final long serialVersionUID = -8421778655710586578L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BaseballTeamService baseballService = new BaseballTeamServiceLogic();
		
		List<BaseballTeam> teams = baseballService.findAllTeams();
		req.setAttribute("teams", teams);
		
		req.getRequestDispatcher("/views/team/teamList.jsp").forward(req, resp);
	}

}
