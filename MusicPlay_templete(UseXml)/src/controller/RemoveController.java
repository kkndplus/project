package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.User;
import service.UserMusicService;
import service.logic.UserMusicServiceLogic;

/**
 * Servlet implementation class RemoveController
 */
@WebServlet("/remove.do")
public class RemoveController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private UserMusicService userMusicService = new UserMusicServiceLogic(); //remove 메소드를 쓰기 위해 서비스 호출

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(); //세션을 가져온다.
		String id = request.getParameter("id"); // remove요청과 같이 넘어온 곡 id를 패러미터에서 받아온다.
		User user = (User) session.getAttribute("loginedUser"); //세션에 저장된 개인정보를 User 객체로 받아온다.
		userMusicService.remove(user.getLoginId(), Integer.parseInt(id)); //remove 메소드 사용
//		List<Music> list = userMusicService.findMusicsByUser(user.getLoginId()); //수정된 개인재생목록을 리스트로 서버에서 받아옴.
//		session.setAttribute("pvlist", list); //수정된 재생목록을 세션에 저장
		
//		request.getRequestDispatcher("/WEB-INF/views/mylist.jsp").forward(request, response); //디스패치
		response.sendRedirect("myList.do");
	}

}
