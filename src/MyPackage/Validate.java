package MyPackage;

import java.sql.*;

public class Validate
 {
     public static boolean checkUser(String name,String dept) 
     {
      boolean st =false;
      try{

	 //loading drivers for mysql
         Class.forName("com.mysql.jdbc.Driver");

 	 //creating connection with the database 
         
         Connection con=DriverManager.getConnection("jdbc:mysql:///sys","root","root");
    //     Connection con=DriverManager.getConnection("jdbc:mysql:/ /localhost:3306/test","root","root");
         PreparedStatement ps =con.prepareStatement("select * from employee where name=? and dept=?");
       
         ps.setString(1, name);
         ps.setString(2, dept);
         ResultSet rs =ps.executeQuery();
         st = rs.next();
        
      }catch(Exception e)
      {
          e.printStackTrace();
      }
         return st;                 
  }   
}