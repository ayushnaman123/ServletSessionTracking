package in.coder.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SecondServlet
 */
@WebServlet("/second")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String squal = request.getParameter("squal");
		String sdes = request.getParameter("sdes");
		
		HttpSession session = request.getSession(false);
		session.setAttribute("squal", squal);
		session.setAttribute("sdes", sdes);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("./form3.html");
		requestDispatcher.forward(request, response);
	}

}
