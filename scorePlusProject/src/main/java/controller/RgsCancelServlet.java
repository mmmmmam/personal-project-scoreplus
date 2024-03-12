package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.RgsService;

/**
 * Servlet implementation class RgsCancleServlet
 */
@WebServlet("/views/rgsCancel.do")
public class RgsCancelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//접수취소
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int rgsNo = Integer.parseInt(request.getParameter("rgsno"));

		RgsService rservice = new RgsService();
		int result = rservice.deleteRgs(rgsNo);
		
		request.setAttribute("", result);
		
		response.sendRedirect("rgsList.do");
	}

}
