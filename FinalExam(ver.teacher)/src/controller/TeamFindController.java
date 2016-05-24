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
 * TeamFindController<br>
 * - 선택된 팀 정보를 상세조회 한다.
 * 
 */
@WebServlet("/team/find")
public class TeamFindController extends HttpServlet {

	/** UID */
	private static final long serialVersionUID = -8421778655710586578L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String teamId = req.getParameter("teamId");
		BaseballTeamService service = new BaseballTeamServiceLogic();
		BaseballTeam team = service.findTeam(teamId);
		req.setAttribute("team", team);
		
		req.getRequestDispatcher("/views/team/teamDetail.jsp").forward(req, resp);
	}

}
