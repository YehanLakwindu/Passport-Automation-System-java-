package passss;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbconnection {


	public Connection connectDB() {
		Connection conn =null;
			 try {
			     String dbname = "TEST12";
			     String username = "root";
			     String pwd = "200251";
			     
			     
			      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbname,username,pwd);
			     return conn;
			     
		}catch(SQLException ex) {
			return conn;
		     }
		}
	}
