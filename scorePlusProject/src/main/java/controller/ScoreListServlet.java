package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.ScoreVO;
import model.ScoreService;

/**
 * Servlet implementation class ScoreListServlet
 */
@WebServlet("/views/scoreList.do")
public class ScoreListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//성적조회
		HttpSession session = request.getSession();
		String cstid = (String)session.getAttribute("cstId");
		
		ScoreService sservice = new ScoreService();
		List<ScoreVO> scorelist = sservice.selectScoreList(cstid);
		
		response.setContentType("text/html;charset=utf-8");
		
		request.setAttribute("slist", scorelist);
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("scoreList.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
