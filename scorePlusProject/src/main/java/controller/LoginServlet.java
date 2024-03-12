package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.CstVO;
import model.CstService;

@WebServlet("/views/loginCheck.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");

		//로그인체크
		String cstid = request.getParameter("cstid");
		String cstpw = request.getParameter("cstpw");
		
		CstService cstService = new CstService();
		CstVO cst = cstService.selectById(cstid, cstpw);
		
		HttpSession session = request.getSession();

		if (cst == null) {
			response.sendRedirect("loginCheck.do");
			return;
		}
		
		//session에 로그인 정보를 저장하기(있으면 얻기, 없으면 생성)
		session.setAttribute("cstId", cst.getCst_id());
		response.sendRedirect("../views/main.jsp");
		
	}

}
