package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.CstVO;
import model.CstService;

@WebServlet("/views/join.do")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("join.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//회원가입
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		CstVO cst = joinCst(request);
		CstService cservice = new CstService();
		int result = cservice.selectCheckCst(request.getParameter("joinid"));
		
		if(result == 0){
			int member = cservice.insertCst(cst);
			response.sendRedirect("loginCheck.do");
			
		}else {
			RequestDispatcher rd;
			rd = request.getRequestDispatcher("join.jsp");
			rd.forward(request, response);
		}

	}

	private CstVO joinCst(HttpServletRequest request) {
		String joinid = request.getParameter("joinid");
		String joinpw = request.getParameter("joinpw");
		String joinname = request.getParameter("joinname");
		String joinbirth = request.getParameter("joinbirth");

		CstVO cst = new CstVO();
		cst.setCst_id(joinid);
		cst.setCst_pw(joinpw);
		cst.setCst_name(joinname);
		cst.setCst_birth(joinbirth);
		
		return cst;
	}

}
