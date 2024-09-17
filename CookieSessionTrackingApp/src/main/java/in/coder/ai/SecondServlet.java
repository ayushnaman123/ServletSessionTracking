package in.coder.ai;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet
 */
@WebServlet("/second")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pbrand = request.getParameter("pbrand");
		String pquantity = request.getParameter("pquantity");
		
		Cookie cookie1 = new Cookie("pbrand", pbrand);
		Cookie cookie2 = new Cookie("pquantity", pquantity);
		
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("./form3.html");
		requestDispatcher.forward(request, response);
		
		
	}

}
