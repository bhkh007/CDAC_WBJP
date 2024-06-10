package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    final static String PASSWORD = "cdac";
    final static String USERNAME = "root";
    final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    final static String URL = "jdbc:mysql://localhost:3306/school";
    
    public LoginServlet() {	
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pwr = response.getWriter();
		try {
			
			Class.forName(DRIVER);
			Connection conn  = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			Statement stmt = conn.createStatement();
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String qry = "SELECT * FROM user WHERE username='"+username+"' and password ='"+password+"'";
			ResultSet rs = stmt.executeQuery(qry);
			if(rs.next()) {
				HttpSession session = request.getSession();
				session.setAttribute("usernameSession", username);
				response.sendRedirect("ProfileServlet");
			}
			else {
			 pwr.println("<script>alert('Invalid username or password')</script>");
			 pwr.println("<script>location.href='index.html'</script>");
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}
}
