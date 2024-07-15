

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class signup
 */
@WebServlet("/signup")
public class signup extends HttpServlet 
{
	
		
	
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
		{
			try {
	        	resp.setContentType("text/html");
	        	String user = req.getParameter("uname");
	        	String pass = req.getParameter("upass");
	        	PrintWriter out = resp.getWriter();


	            Class.forName("oracle.jdbc.driver.OracleDriver");
	            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "hr", "12345678");

	            PreparedStatement pmt = conn.prepareStatement("insert into users values(?,?,'notvoted')");
	            pmt.setString(1, user);
	            pmt.setString(2, pass);
	            pmt.executeUpdate();
	            out.println("<script type=\"text/javascript\">");
                out.println("alert('User Registerd successfully!');");
                out.println("</script>");
                RequestDispatcher fwd= req.getRequestDispatcher("/index.html");
                fwd.include(req, resp);
			  } catch (ClassNotFoundException | SQLException e) {
		            e.printStackTrace();
		        }
			
			
		}

}
