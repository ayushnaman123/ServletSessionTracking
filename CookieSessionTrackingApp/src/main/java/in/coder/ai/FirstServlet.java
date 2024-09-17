package in.coder.ai;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pname = request.getParameter("pname");
		String pcost = request.getParameter("pcost");
		
		Cookie cookie1 = new Cookie("pname", pname);
		Cookie cookie2 = new Cookie("pcost", pcost);
		
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("./form2.html");
		requestDispatcher.forward(request, response);
		
		
	}

}
