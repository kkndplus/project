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

@WebServlet("/login.do")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		UserService service = new UserServiceLogic();
		
		User user = new User();
		user.setLoginId(request.getParameter("loginId"));
		user.setPassword(request.getParameter("password"));
		
		User loginedUser = service.login(user);
		
		if(loginedUser != null){
			HttpSession session = request.getSession();
			session.setAttribute("loginedUser", loginedUser);
		}else{
			HttpSession session = request.getSession(false);
			session.invalidate();
		}
		response.sendRedirect("list.do");
	}
}
