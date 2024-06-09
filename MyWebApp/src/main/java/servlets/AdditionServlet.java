package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AdditionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		int a = Integer.parseInt(request.getParameter("n1"));
		int b = Integer.parseInt(request.getParameter("n2"));
		int c = a+b;
		System.out.println("Sum is : "+c);
	
		 PrintWriter pwr=response.getWriter(); 
		 pwr.println("Sum is : " + c);
		 
	}

}
