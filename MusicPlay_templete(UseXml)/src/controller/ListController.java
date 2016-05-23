package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Music;
import service.logic.MusicServiceLogic;

/**
 * Servlet implementation class ListController
 */
@WebServlet("/list.do")
public class ListController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private MusicServiceLogic musicService = new MusicServiceLogic();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//최상위 화면. 즉, 초기화면
		List<Music> list = musicService.findAll();//서버에서 모든 곡들을 받아옴.
		request.setAttribute("list", list);//리퀘스트에 모든 곡들을 담은 리스트 세팅.
		
		request.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doPost는 검색 결과를 보여줘야 한다.
		String name = request.getParameter("songName"); //검색내용을 패러미터에서 받아온다.
		List<Music> list = musicService.findByName(name); //메소드 실행 후 검색 결과를 리스트로 저장.
		request.setAttribute("list", list); //리퀘스트에 모든 곡들을 담은 리스트 세팅.
		request.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(request, response); //최상위 루트(/MusicPlay)로 이동.
	}

}
