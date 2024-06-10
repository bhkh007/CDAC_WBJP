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


public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    final static String PASSWORD = "cdac";
    final static String USERNAME = "root";
    final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    final static String URL = "jdbc:mysql://localhost:3306/school";
   
    public ProfileServlet() {
        super();
       
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pwr = response.getWriter();
		try {
			
			HttpSession session = request.getSession();
			if(session!=null) {
				String username = (String)session.getAttribute("usernamesession");
				Class.forName(DRIVER);
				Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
				Statement stmt = conn.createStatement();
				String qry = "SELECT * FROM user WHERE username='"+username+"'";
				ResultSet rs = stmt.executeQuery(qry);
				if(rs.next()) {
					int id = rs.getInt("id");
					String phone = rs.getString("phone");
					String email = rs.getString("email");
					pwr.println("<h3>Welcome"+username+ "</h3>");
					pwr.println("<h4>Welcome"+id+ "</h4>");
					pwr.println("<h4>Welcome"+phone+ "</h4>");
					pwr.println("<h4>Welcome"+email+ "</h4>");
					pwr.println("<a htef = 'LogoutServlet'>Logout</a>");
					
				}
				else {
					pwr.println("<h4>Problem in fetching data</h4>");
				}
				response.sendRedirect("index.html");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
