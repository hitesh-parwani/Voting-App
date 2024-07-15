

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
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet 
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

            PreparedStatement pmt = conn.prepareStatement("select * from users where users=? and pass=?");
            pmt.setString(1, user);
            pmt.setString(2, pass);
            ResultSet rs = pmt.executeQuery();
            String votedcolumn="";
            boolean uservalid = rs.next();
            if(uservalid==true) {
            votedcolumn=rs.getString(3);
            System.out.println(votedcolumn);
            }
            
            if(user.equals("admin") && pass.equals("password")) 
            {
            	out.println("<script type=\"text/javascript\">");
            	out.println("alert('welcome admin!');");
            	out.println("</script>");
            	RequestDispatcher fwd= req.getRequestDispatcher("/adminservlet");
            	fwd.include(req, resp);
            }
            if(uservalid==false)
            {
            	out.println("<script type=\"text/javascript\">");
            	out.println("alert('invalid username or password');");
            	out.println("</script>");
            	RequestDispatcher fwd= req.getRequestDispatcher("/index.html");
            	fwd.include(req, resp);
            	
            }
            if (votedcolumn.equals("bjp") || votedcolumn.equals("congress") || votedcolumn.equals("other")){
            	out.println("<script type=\"text/javascript\">");
                out.println("alert('User already voted');");
                out.println("</script>");
                RequestDispatcher fwd= req.getRequestDispatcher("/index.html");
                fwd.include(req, resp);
            } 
            if (votedcolumn.equals("notvoted") || votedcolumn.equals("voted")) {
            	Cookie username= new Cookie("user",rs.getString(1));
            	Cookie password= new Cookie("pass",rs.getString(2));
            	resp.addCookie(username);
            	resp.addCookie(password);
            	RequestDispatcher fwd= req.getRequestDispatcher("/vote.html");
                fwd.include(req, resp);
				
			}
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

}
