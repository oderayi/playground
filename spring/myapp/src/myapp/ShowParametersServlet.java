package myapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowParameters
 */
@WebServlet(description = "Display all parameters submitted by form", urlPatterns = { "/show-params" })
public class ShowParametersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowParametersServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " + "Transitional//EN\">\n";
		String title = "Reading All Request Parameters";
		out.println(
				docType + "<HTML>\n" + "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" + "<BODY BGCOLOR=\"#FDF5E6\">\n"
						+ "<H1 ALIGN=CENTER>" + title + "</H1>\n" + "<TABLE BORDER=1 ALIGN=CENTER>\n"
						+ "<TR BGCOLOR=\"#FFAD00\">\n" + "<TH>Parameter Name<TH>Parameter Value(s)");
		Enumeration<String> paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String paramName = (String) paramNames.nextElement();
			out.print("<TR><TD>" + paramName + "\n<TD>");
			String[] paramValues = request.getParameterValues(paramName);
			if (paramValues.length == 1) {
				String paramValue = paramValues[0];
				if (paramValue.length() == 0)
					out.println("<I>No Value</I>");
				else
					out.println(paramValue);
			} else {
				out.println("<UL>");
				for (int i = 0; i < paramValues.length; i++) {
					out.println("<LI>" + paramValues[i]);
				}
				out.println("</UL>");
			}
		}
		out.println("</TABLE>\n</BODY></HTML>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}