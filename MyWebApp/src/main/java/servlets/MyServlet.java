package servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



public class MyServlet extends HttpServlet {
	
	 @Override
	public void init() throws ServletException {
		System.out.println("Init called");
	}
	 
	 @Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Service called");
	}
	 
	 @Override
	public void destroy() {
		System.out.println("Destroy called");
	}
}
