package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;


public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public LogoutServlet() {
        super();
        
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try {
			
			HttpSession session = request.getSession(false);
			if(session!=null){
				session.invalidate();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
