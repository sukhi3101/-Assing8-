package MyPackage;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Login extends HttpServlet {
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("index/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String name = request.getParameter("name");
        String dept = request.getParameter("dept");
        
        if(Validate.checkUser(name,dept))
        {
            RequestDispatcher rs = request.getRequestDispatcher("Welcome");
            rs.forward(request, response);
        }
        else
        {
           out.println("Username or Password incorrect");
           RequestDispatcher rs = request.getRequestDispatcher("index.html");
           rs.include(request, response);
        }
    }  
}