package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Music;
import domain.User;
import service.UserMusicService;
import service.logic.UserMusicServiceLogic;

/**
 * Servlet implementation class MylistController
 */
@WebServlet("/myList.do")
public class MylistController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private UserMusicService userMusicService = new UserMusicServiceLogic(); //서비스 호출

	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//상단의 재생목록 클릭시 수행. (현재 개인 재생목록 로딩이 되어야 함.)
		HttpSession session = request.getSession(); //세션을 불러온다.
		User user = (User) session.getAttribute("loginedUser"); //세션에 저장된 개인정보를 받아온다.
		
		List<Music> list = userMusicService.findMusicsByUser(user.getLoginId()); //개인 재생목록을 서버에서 받아온다.
		session.setAttribute("list", list); //받아온 개인 재생목록을 세션에 세팅
		request.getRequestDispatcher("/WEB-INF/views/mylist.jsp").forward(request, response);
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//전체 목록에서 담기 버튼 클릭시 발동. (현재 개인 재생목록 로딩과 곡 저장이 같이 되어야 함.)
		HttpSession session = req.getSession(); //세션을 불러온다.
		String id = req.getParameter("id"); //곡 id를 패러미터에서 받아온다.
		User user = (User) session.getAttribute("loginedUser"); //세션에 저장된 개인정보를 받아온다.
		userMusicService.register(user.getLoginId(), Integer.parseInt(id)); //유저 아이디와 곡 아이디를 이용해 개인 재생목록에 저장 완료.
		
		List<Music> list = userMusicService.findMusicsByUser(user.getLoginId()); //개인 재생목록을 서버에서 받아온다.
		session.setAttribute("list", list); //받아온 개인 재생목록을 세션에 세팅
		
		req.getRequestDispatcher("/WEB-INF/views/mylist.jsp").forward(req, resp);
	}

}
