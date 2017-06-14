import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Login extends HttpServlet {
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        String sub=request.getParameter("LOGIN");
                  
      if(validate.check(name, pass))
        {
        HttpSession s1=request.getSession(true);
        RequestDispatcher r1 = request.getRequestDispatcher("welcome");
        r1.include(request, response);
        }
      
        else{
             
            out.println("<h3>"+  "wrongcredentials" + "</h3>");
            RequestDispatcher r1=request.getRequestDispatcher("lgin.html");
            r1.include(request, response);
       
        
            
        }   
        }
        
    }  
