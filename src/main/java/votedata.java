

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class votedata
 */
@WebServlet("/votedata")
public class votedata extends HttpServlet {;

	
	 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		resp.setContentType("text/html");
    	PrintWriter out = resp.getWriter();
    	out.println("<html>\r\n"
    			+ "    <head>\r\n"
    			+ "    <link href=\"//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css\" rel=\"stylesheet\" id=\"bootstrap-css\">\r\n"
    			+ "    <script src=\"//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js\"></script>\r\n"
    			+ "    <script src=\"//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\r\n"
    			+ "        <style>\r\n"
    			+ "\r\n"
    			+ "            .wrapper{\r\n"
    			+ "                background: #505050;\r\n"
    			+ "    padding: 100px;\r\n"
    			+ "    margin: 100px;\r\n"
    			+ "          }\r\n"
    			+ "          \r\n"
    			+ "          .toggle_radio{\r\n"
    			+ "            position: relative;\r\n"
    			+ "            background: rgba(255,255,255,.1);\r\n"
    			+ "            margin: 4px auto;\r\n"
    			+ "            overflow: hidden;\r\n"
    			+ "            padding: 0 !important;\r\n"
    			+ "            -webkit-border-radius: 50px;\r\n"
    			+ "            -moz-border-radius: 50px;\r\n"
    			+ "            border-radius: 50px;\r\n"
    			+ "            position: relative;\r\n"
    			+ "            height: 26px;\r\n"
    			+ "            width: 318px;\r\n"
    			+ "          }\r\n"
    			+ "          .toggle_radio > * {\r\n"
    			+ "            float: left;\r\n"
    			+ "          }\r\n"
    			+ "          .toggle_radio input[type=radio]{\r\n"
    			+ "            display: none;\r\n"
    			+ "            /*position: fixed;*/\r\n"
    			+ "          }\r\n"
    			+ "          .toggle_radio label{\r\n"
    			+ "            font: 90%/1.618 \"Source Sans Pro\";\r\n"
    			+ "            color: rgba(255,255,255,.9);\r\n"
    			+ "            z-index: 0;\r\n"
    			+ "            display: block;\r\n"
    			+ "            width: 100px;\r\n"
    			+ "            height: 20px;\r\n"
    			+ "            margin: 3px 3px;\r\n"
    			+ "            -webkit-border-radius: 50px;\r\n"
    			+ "            -moz-border-radius: 50px;\r\n"
    			+ "            border-radius: 50px;\r\n"
    			+ "            cursor: pointer;\r\n"
    			+ "            z-index: 1;\r\n"
    			+ "            /*background: rgba(0,0,0,.1);*/\r\n"
    			+ "            text-align: center;\r\n"
    			+ "            /*margin: 0 2px;*/\r\n"
    			+ "            /*background: blue;*/ /*make it blue*/\r\n"
    			+ "          }\r\n"
    			+ "          .toggle_option_slider{\r\n"
    			+ "            /*display: none;*/\r\n"
    			+ "            /*background: red;*/\r\n"
    			+ "            width: 100px;\r\n"
    			+ "            height: 20px;\r\n"
    			+ "            position: absolute;\r\n"
    			+ "            top: 3px;\r\n"
    			+ "            -webkit-border-radius: 50px;\r\n"
    			+ "            -moz-border-radius: 50px;\r\n"
    			+ "            border-radius: 50px;\r\n"
    			+ "            -webkit-transition: all .4s ease;\r\n"
    			+ "            -moz-transition: all .4s ease;\r\n"
    			+ "            -o-transition: all .4s ease;\r\n"
    			+ "            -ms-transition: all .4s ease;\r\n"
    			+ "            transition: all .4s ease;\r\n"
    			+ "          }\r\n"
    			+ "          \r\n"
    			+ "          #first_toggle:checked ~ .toggle_option_slider{\r\n"
    			+ "            background: rgba(255,255,255,.3);\r\n"
    			+ "            left: 3px;\r\n"
    			+ "          }\r\n"
    			+ "          #second_toggle:checked ~ .toggle_option_slider{\r\n"
    			+ "            background: rgba(255,255,255,.3);\r\n"
    			+ "            left: 109px;\r\n"
    			+ "          }\r\n"
    			+ "          #third_toggle:checked ~ .toggle_option_slider{\r\n"
    			+ "            background: rgba(255,255,255,.3);\r\n"
    			+ "            left: 215px;\r\n"
    			+ "        }\r\n"
    			+ "        #votebutton{\r\n"
    			+ "            padding: 20px;\r\n"
    			+ "    text-align: center;\r\n"
    			+ "    margin: 15px;\r\n"
    			+ "        }\r\n"
    			+ "        </style>\r\n"
    			+ "    </head>\r\n"
    			+ "    <body>\r\n"
    			+ "\r\n"
    			+ "\r\n"
    			+ "	<form action=\"votedata\">\r\n"
    			+ "\r\n"
    			+ "        <div class=\"wrapper\">\r\n"
    			+ "            <div class=\"toggle_radio\">\r\n"
    			+ "                <input type=\"radio\" class=\"toggle_option\" id=\"first_toggle\" name=\"toggle_option\">\r\n"
    			+ "                <input type=\"radio\" checked class=\"toggle_option\" id=\"second_toggle\" name=\"toggle_option\">\r\n"
    			+ "    <input type=\"radio\" class=\"toggle_option\" id=\"third_toggle\" name=\"toggle_option\">\r\n"
    			+ "    <label for=\"first_toggle\"><p>BJP</p></label>\r\n"
    			+ "    <label for=\"second_toggle\"><p>CONGRESS</p></label>\r\n"
    			+ "    <label for=\"third_toggle\"><p>OTHER</p></label>\r\n"
    			+ "    <div class=\"toggle_option_slider\">\r\n"
    			+ "    </div>\r\n"
    			+ "  </div>\r\n"
    			+ "  <div id=\"votebutton\">\r\n"
    			+ "      <button type=\"submit\"  value=\"vote\" class=\"btn btn-warning\">vote</button>\r\n"
    			+ "    </div>\r\n"
    			+ "    \r\n"
    			+ "</form>\r\n"
    			+ "    \r\n"
    			+ "    </body>\r\n"
    			+ "</html>");
    	RequestDispatcher rd=req.getRequestDispatcher("/votesuccess");
    	rd.forward(req, resp);
	}
	
	
}
