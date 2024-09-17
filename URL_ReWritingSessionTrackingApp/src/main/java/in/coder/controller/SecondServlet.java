package in.coder.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/second")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accountType = request.getParameter("accountType");
		String accountBranch = request.getParameter("accountBranch");
		
		HttpSession session = request.getSession();
		session.setAttribute("accountType", accountType);
		session.setAttribute("accountBranch", accountBranch);
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Deposit Form</title></head>");
		out.println("<body bgcolor='cyan'>");
		out.println("<center>");
		out.println("<h1 style='color: red;'><marquee>Deposit Form</marquee></h1>");
		out.println("<form method='post' action='"+response.encodeURL("./third")+"'>");
		out.println("<table>");
		out.println("<tr><th>DepositorName</th><td><input type='text' name='depositorName' /></td></tr>");
		out.println("<tr><th>DepositAmount</th><td><input type='text' name='depositAmount' /></td></tr>");
		out.println("<tr><th></th><td><input type='submit' value='reg' /></td></tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
