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


@WebServlet("/views/myProfile.do")
public class MyProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//회원정보조회
		HttpSession session = request.getSession();
		String cstid = (String)session.getAttribute("cstId");
		
		CstService cservice = new CstService();
		CstVO cstInfo = cservice.selectCst(cstid);
		
		request.setAttribute("cstprofile", cstInfo);
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("myProfile.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//비밀번호변경
		HttpSession session = request.getSession();
		String cstid = (String)session.getAttribute("cstId");
		String newpass = request.getParameter("newpass");
		
		CstService cservice = new CstService();
		int rsltCnt = cservice.updateCst(cstid, newpass);
		String message = rsltCnt>0?"Update Success":"Update Fail";
		
		response.sendRedirect("myProfile.do?message="+message);
	}

}
