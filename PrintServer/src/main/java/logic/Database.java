package logic;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class Database {
	

	Connection c = null;
	Statement stmt = null;
	Crypto crypto = new Crypto();
	
	public String queryPasswordFromDatabase(String user) {
		
		String sql = "select * from users";
				
				try {
					stmt = c.createStatement();
					ResultSet result = stmt.executeQuery(sql);
					
					while(result.next()) {
						String uuid = result.getString("user");
						String password = result.getString("password");
						System.out.println(uuid + " | " + password);
					}
					 c.close();
					
				} catch (SQLException e) {
					System.out.println("ERROR!!!");
					e.printStackTrace();
				}
				
				return "password";
		
	}
	
	public void initialiseDatabase() throws RemoteException {
	      try {
	          Random rand = new Random();
	          int rand_int = rand.nextInt(1000);
	          c = DriverManager.getConnection("jdbc:sqlite:database\\database" + rand_int + ".db");
	         
	          // create table
	          String sql = "create table users (user varchar(20), password varchar(200))";
	          stmt = c.createStatement();
	          stmt.executeUpdate(sql);
	          stmt.close();
		        
	          // populate table (user, password)
	          stmt = c.createStatement();
	       
	          sql = "insert into users values ('admin','admin')";
	          stmt.executeUpdate(sql);
	          
	          sql = "insert into users values ('jeff','" + crypto.encrypt("password22") + "')";
	          stmt.executeUpdate(sql);
	          
	          /*
	          if(insert > 0) {
	            	//System.out.println("insert to table: success!!");
	          }
	          */
	        
	          stmt.close();

	      } catch ( Exception e ) {
	          System.err.println("[Server]: " + e.getClass().getName() + " --> " + e.getMessage() );
	          System.exit(0);
	      }
	      // System.out.println("[Server]: Database is up!");
	      // System.out.println("Table created successfully");
        // System.exit(0);
		
	}

}
