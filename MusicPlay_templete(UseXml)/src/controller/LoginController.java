package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.User;
import service.UserService;
import service.logic.UserServiceLogic;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login.do")
public class LoginController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceLogic(); //서비스 호출.

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//로그인 페이지를 보여준다.
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//로그인 하는 작업
		HttpSession session = request.getSession(); // 세션을 받아온다.

		User user = new User(); //패러미터로 넘어온 값들을 저장하기 위해 User 객체 생성
		String loginId = request.getParameter("loginId"); //패러미터에서 로그인id를 받아옴
		String password = request.getParameter("password"); //패러미터에서 패스워드를 받아옴

		user.setLoginId(loginId); //User 객체에 로그인id 세팅
		user.setPassword(password); //User 객체에 패스워드 세팅

		User account = userService.login(user); //로그인 작업 결과를 account 객체에 저장
		if (account != null) { //account가 null이 아닐 경우는 작업결과가 성공적이라는 얘기.
			session.setAttribute("loginedUser", account); //세션에 개인정보 세팅.
		}
		response.sendRedirect(request.getContextPath()); //최상위 루트(/MusicPlay)로 이동.
	}

}
