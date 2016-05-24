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

@WebServlet("/join.do")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("join.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService service = new UserServiceLogic();
		
		User user = new User();
		
		user.setLoginId(request.getParameter("loginId"));
		user.setPassword(request.getParameter("password"));
		user.setName(request.getParameter("name"));
		
		if(!service.register(user)){
			response.sendRedirect("join.do");
		}
		response.sendRedirect("list.do");
	}

}
