package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import service.UserService;
import service.logic.UserServiceLogic;

/**
 * Servlet implementation class JoinController
 */
@WebServlet("/join.do")
public class JoinController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceLogic(); //서비스 호출.

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//doGet 작업은 회원가입 페이지를 보여준다. 
		request.getRequestDispatcher("/WEB-INF/views/join.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//join.do의 post 작업은 회원 가입이다.

		User user = new User(); //객체 생성
		String name = request.getParameter("name"); //패러미터에서 값 받아옴
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");

		user.setName(name); //받아온 값들 세팅.
		user.setLoginId(loginId);
		user.setPassword(password);

		if (!userService.register(user)){//회원 가입 작업 메소드
			throw new RuntimeException("회원 가입을 할 수 없습니다."); //false값이 반환되면 에러 메시지 송출
		}
		response.sendRedirect(request.getContextPath()); //최상위 루트(/MusicPlay)로 이동.

	}

}
