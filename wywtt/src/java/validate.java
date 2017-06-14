/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bahul
 */
public class validate  {
    public static boolean check(String name,String pass){  
boolean status=false;  
try{  
 String username = "root";
            String password = "eGcVt5egKo";
            String url = "jdbc:mysql://mysql29745-wywtt.cloud.cms500.com/wywtt";
            Class.forName ("com.mysql.jdbc.Driver").newInstance();
            Connection  con = DriverManager.getConnection (url, username, password);
      
PreparedStatement ps=con.prepareStatement( "select * from WYWTT where name=? and PASS=?");  
ps.setString(1,name);  
ps.setString(2,pass);  
      
ResultSet rs=ps.executeQuery();  
status=rs.next();  
          
}
catch(Exception e){System.out.println(e);}  
return status;  

    }  


    
}
