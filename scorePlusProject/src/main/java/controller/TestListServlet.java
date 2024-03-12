package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.TestVO;
import model.TestService;

/**
 * Servlet implementation class TestType
 */
@WebServlet("/views/testList.do")
public class TestListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//시험일정조회
		TestService tservice = new TestService();
		List<TestVO> testlist = tservice.selectTestList();
		
		request.setAttribute("tlist", testlist);
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("testList.jsp");
		rd.forward(request, response);
		
	}

}
