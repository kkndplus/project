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
 * Servlet implementation class TeamListController
 */
@WebServlet("/teamList.do")
public class TeamListController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	private BaseballTeamService service = new BaseballTeamServiceLogic();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//최상위 화면. 즉, 초기화면
		List<BaseballTeam> list = service.findAllTeams();//서버에서 모든 곡들을 받아옴.
		request.setAttribute("list", list);//리퀘스트에 모든 곡들을 담은 리스트 세팅.
		
		request.getRequestDispatcher("/WEB-INF/views/teamList.jsp").forward(request, response);
	}

}
