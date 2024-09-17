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

import in.coder.dto.Students;
import in.coderdao.IStudentDao;
import in.coderdao.StudentDaoImpl;

/**
 * Servlet implementation class DisplayServlet
 */
@WebServlet("/disp")
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String semail = request.getParameter("semail");
		String smob = request.getParameter("smob");

		HttpSession session = request.getSession(false);
		session.setAttribute("semail", semail);
		session.setAttribute("smob", smob);
        
		IStudentDao studentDao = new StudentDaoImpl();
		Students student = new Students();
		student.setsName((String)session.getAttribute("sname"));
		student.setsAge(Integer.parseInt((String)session.getAttribute("sage")));
		student.setsQualification((String)session.getAttribute("squal"));
		student.setsDesignation((String)session.getAttribute("sdes"));
		student.setsEmail(semail);
		student.setsMobile(smob);
		String status = studentDao.insertStudent(student);
		
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>OUTPUT</title></head>");
		out.println("<body bgcolor='lightgreen'>");
		out.println("<h1 style='color:red; text-align:center;'><REGISTRATION DETAILS....</h1>");
		out.println("<center>");
		out.println("<table border='1'>");
		out.println("<tr><th>NAME</th><th>VALUES</th></tr>");


		Enumeration<String> attributeNames = session.getAttributeNames();
		while (attributeNames.hasMoreElements()) {
			String attributeName = (String) attributeNames.nextElement();
			Object attributeValue = session.getAttribute(attributeName);

			out.println("<tr><td>" + attributeName + "</td><td>" + attributeValue + "</td></tr>");

		}
		out.println("<tr><td>STATUS</td><td>"+status+"</td></tr>");

		out.println("</table>");
		out.println("<center>");
		out.println("</body>");
		out.println("</html>");
		out.close();
		System.out.println("SESSION ID "+session.getId());
	}

}
