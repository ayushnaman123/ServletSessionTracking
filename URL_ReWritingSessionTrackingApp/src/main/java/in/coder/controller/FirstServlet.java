package in.coder.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accountNo = request.getParameter("accountNo");
		String accountName = request.getParameter("accountName");
		
		HttpSession session = request.getSession();
		session.setAttribute("accountNo", accountNo);
		session.setAttribute("accountName", accountName);
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Deposit Form</title></head>");
		out.println("<body bgcolor='cyan'>");
		out.println("<center>");
		out.println("<h1 style='color: red;'><marquee>DEPOSIT FORM</marquee></h1>");
		out.println("<form method='post' action='"+response.encodeURL("./second")+"'>");
		out.println("<table>");
		out.println("<tr><th>AccountType</th><td><input type='text' name='accountType' /></td></tr>");
		out.println("<tr><th>AccountBranch</th><td><input type='text' name='accountBranch' /></td></tr>");
		out.println("<tr><th></th><td><input type='submit' value='next' /></td></tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
