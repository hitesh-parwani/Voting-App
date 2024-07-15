

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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class votesuccess
 */
@WebServlet("/votesuccess")
public class votesuccess extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    	System.out.println(user+"  "+pass);
    	 try {
    		 resp.setContentType("text/html");
    		 Cookie arr[]=req.getCookies();
    		 String pass = arr[0].getValue();
    		 String user = arr[1].getValue();
    		 PrintWriter out = resp.getWriter();
    		 String vote=req.getParameter("voted");
    		 System.out.println(vote);
         	System.out.println(user+" "+pass);
//         	System.out.println(pass+" "+user);


             Class.forName("oracle.jdbc.driver.OracleDriver");
             Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "hr", "12345678");

             PreparedStatement pmt = conn.prepareStatement("update users set vote=? where users=? and pass=?");
             pmt.setString(1, vote);
             pmt.setString(2, user);
             pmt.setString(3, pass);
             pmt.executeUpdate();
             out.println("<script type=\"text/javascript\">");
             out.println("alert('voted successfully!');");
             out.println("</script>");
             RequestDispatcher fwd= req.getRequestDispatcher("/index.html");
             fwd.include(req, resp);
             
             }
    	 catch (ClassNotFoundException | SQLException e) {
             e.printStackTrace();
         }
             
		
	}

}
