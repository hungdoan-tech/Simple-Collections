package mypack;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChaoMung
 */
@WebServlet("/ChaoMung")
public class ChaoMung extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChaoMung() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletOutputStream	out =  response.getOutputStream();
		out.println("<html>");		
      	out.println("<head>");
  		out.println("<title>Hello Servlet</title>");
      	out.println("<style>");      	
      	out.println(".head-title {");
      	out.println("text-align: center;");
      	out.println("box-shadow: 5px 5px 5px #666;");
      	out.println("-moz-box-shadow: 5px 5px 5px #666;");
      	out.println("-webkit-box-shadow: 5px 5px 5px #666;");
      	out.println("border: 2px solid black;");
      	out.println("font-size: 2rem;");
      	out.println("}");      	
      	out.println(".head-title h3 {");
      	out.println("color:blue;");
      	out.println("}");      	
      	out.println(".head-title p {");
      	out.println("color:red;");
      	out.println("}");      	
      	out.println("</style>");
      	out.println("</head>");      	
	  	out.println("<body>");
	  	out.println("<div class= \"head-title\">");
	  	out.println("<h3>Java Web Application Programming</h3>");
	  	out.println("<p>Java EE (Servlet/JSP/Struts/Spring)</p>");
	  	out.println("</div");
	  	out.println("</body>");	  	
	  	out.println("<html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
