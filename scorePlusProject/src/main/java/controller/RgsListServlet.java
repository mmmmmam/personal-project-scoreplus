package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.CstVO;
import dto.RgsVO;
import model.CstService;
import model.RgsService;

/**
 * Servlet implementation class RgsListServlet
 */
@WebServlet("/views/rgsList.do")
public class RgsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//접수내역조회
		HttpSession session = request.getSession();
		String cstid = (String)session.getAttribute("cstId");
		
		RgsService rservice = new RgsService();
		List<RgsVO> rgslist = rservice.selectRgsList(cstid);

		response.setContentType("text/html;charset=utf-8");
		
		request.setAttribute("rlist", rgslist);
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("rgsList.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//시험접수
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session = request.getSession();
		String cstid = (String)session.getAttribute("cstId");
		String testId = request.getParameter("testId");
		boolean rgsYn = true;
		String rspCd = "0000"; //접수성공
		int result = 0;
		
		RgsService rservice = new RgsService();
		List<RgsVO> rgslist = rservice.selectRgsList(cstid);

		for(int i = 0;i<rgslist.size();i++) {
			if(testId.equals(rgslist.get(i).getTest_id())){ rgsYn = false; }
		}
		
		if(rgsYn) {
			result = rservice.insertRgs(testId, cstid);
			if(result==0){
				rspCd = "0001"; //(0001:접수실패)
				response.sendRedirect("testList.do?rspCd="+rspCd);
			}else {
				response.sendRedirect("rgsList.do?rspCd="+rspCd);
			}
		}else {
			rspCd = "0002"; //(0002:중복접수)
			response.sendRedirect("testList.do?rspCd="+rspCd);
		}
		
	}
	
}
