import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class REGISTRATION extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
	
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        try{
        
            //creating the seesion
           
            
        //loading drivers for mysql
         String username = "root";
            String password = "eGcVt5egKo";
            String url = "jdbc:mysql:// mysql29745-wywtt.cloud.cms500/wywtt";
            Class.forName ("com.mysql.jdbc.Driver").newInstance();
            Connection  con = DriverManager.getConnection (url, username, password);


        PreparedStatement ps=con.prepareStatement
                  ("insert into WYWTT values(?,?,?)");

        ps.setString(1, pass);
        ps.setString(2, name);
        ps.setString(3, email);
       
        int i=ps.executeUpdate();
        
          if(i>0)
          {
              out.println("You sucessfully registered");
              RequestDispatcher rs = request.getRequestDispatcher("lgin.html");
              rs.include(request, response);

          }
          else{
             out.println("WRONG INPUTS");              
          }
        
        }
        catch(Exception se)
        {
            se.printStackTrace();
        }
	
      }
  }

