package in.coder.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.coder.dao.DepositDaoImpl;
import in.coder.dao.IDepositDao;
import in.coder.dto.Deposit;

@WebServlet("/third")
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String depositorName = request.getParameter("depositorName");
		String depositAmount = request.getParameter("depositAmount");
		
		HttpSession session = request.getSession();
		session.setAttribute("depositorName", depositorName);
		session.setAttribute("depositAmount", depositAmount);
		
		IDepositDao dao = new DepositDaoImpl();
		
		Deposit deposit = new Deposit();
		deposit.setAccountNo((String)session.getAttribute("accountNo"));
		deposit.setAccountName((String)session.getAttribute("accountName"));
		deposit.setAccountType((String)session.getAttribute("accountType"));
		deposit.setAccountBranch((String)session.getAttribute("accountBranch"));
		deposit.setDepositorName(depositorName);
		deposit.setDepositorAmount(Integer.parseInt(depositAmount));
		
		String status = dao.doInsert(deposit);
		
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Deposit Form</title></head>");
		out.println("<body bgcolor='cyan'>");
		out.println("<center>");
		out.println("<h1 style='color: red;'><marquee>Details About Transaction.. </marquee></h1>");
		out.println("<table border='1'>");
		out.println("<tr><th>NAME</th><th>VALUE</th></tr>");
		Enumeration<String> attributeNames = session.getAttributeNames();
		
		while(attributeNames.hasMoreElements()) {
			String attributeName = (String)attributeNames.nextElement();
			Object attributeValue = session.getAttribute(attributeName);
			out.println("<tr>");
			out.println("<td>"+attributeName+"</td>");
			out.println("<td>"+attributeValue+"</td>");
			out.println("</tr>");
		}
		out.println("<tr><td>STATUS</td><td>"+status+"</td></tr>");
		out.println("</table>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
