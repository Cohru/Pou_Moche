package Data;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Data_Source {
    Connection conn = null;
  

  public Connection createConnection()
  {
  
    try
    {

        String url       = "jdbc:mysql://localhost:3306/pou_moche";
        String user      = "root";
        String password  = "cytech0001";

        // create a connection to the database
        conn = DriverManager.getConnection(url, user, password);

    }
    catch( Exception e )
    {
      System.out.println("Error Occured " + e.toString());
    }
    return conn;
  }
  

      
 
}
