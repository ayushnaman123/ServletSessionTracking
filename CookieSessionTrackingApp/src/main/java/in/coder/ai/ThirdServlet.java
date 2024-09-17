package in.coder.ai;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.coder.dao.IProductDao;
import in.coder.dao.ProductDaoImpl;
import in.coder.dto.Product;

/**
 * Servlet implementation class ThirdServlet
 */
@WebServlet("/disp")
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pcategory = request.getParameter("pcategory");
		String pmanufacturer = request.getParameter("pmanufacturer");
		
		Cookie[] cookies = request.getCookies();
		String pname = cookies[0].getValue();
		String pcost = cookies[1].getValue();
		String pbrand = cookies[2].getValue();
		String pquantity = cookies[3].getValue();
		
		IProductDao dao = new ProductDaoImpl();
		
		Product product = new Product();
		product.setpName(pname);
		product.setpCost(Integer.parseInt(pcost));
		product.setpBrand(pbrand);
		product.setpQuantity(Integer.parseInt(pquantity));
		product.setpCategory(pcategory);
		product.setpManufacturer(pmanufacturer);
		
		String status = dao.insertProduct(product);
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>OUTPUT</title></head>");
		out.println("<body bgcolor='lightgreen'>");
		out.println("<h1 style='color:red; text-align:center;'><REGISTRATION DETAILS....</h1>");
		out.println("<center>");
		out.println("<table border='1'>");
		out.println("<tr><th>NAME</th><th>VALUES</th></tr>");
		out.println("<tr><td>PNAME</td><td>" + pname + "</td></tr>");
		out.println("<tr><td>PCOST</td><td>" + pcost + "</td></tr>");
		out.println("<tr><td>PBRAND</td><td>" + pbrand + "</td></tr>");
		out.println("<tr><td>PQUANTITY</td><td>" + pquantity + "</td></tr>");
		out.println("<tr><td>PCATEGORY</td><td>" + pcategory + "</td></tr>");
		out.println("<tr><td>PMANUFACTURER</td><td>" + pmanufacturer + "</td></tr>");
		out.println("<tr><td>STATUS</td><td>" + status + "</td></tr>");
		out.println("</table>");
		out.println("<center>");
		out.println("</body>");
		out.println("</html>");
		out.close();
		
	}
	

}
