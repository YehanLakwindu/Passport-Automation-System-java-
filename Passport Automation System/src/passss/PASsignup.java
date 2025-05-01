package passss;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PASsignup {
 public void newlogin(String FullName,String Email,String Username,String password,String ConPassword) {
  try {
	  dbconnection dbc = new dbconnection();
      Connection c = dbc.connectDB();
           
    String sql = "insert into SingUp(FullName,Email,Username,password,ConPassword) values(?,?,?,?,?)";
    PreparedStatement statement = c.prepareStatement(sql);
    
    statement.setString(1,FullName);
    statement.setString(2,Email);
    statement.setString(3,Username);
             statement.setString(4,password);
             statement.setString(5,ConPassword);
             
             int update = statement.executeUpdate();
     
     if (update > 0) {
       System.out.println("Data updated successfully!");
       
     } 
     else {
       System.out.println("Data update Failed!");
     }
   }
   catch(SQLException ex) {
    System.out.println("Update Failed");
    System.out.println(ex);
    }
 }

}