/*
 * JDBC -> Java DataBase Connectivity
java.sql package
throw SQLException

1. Register the Driver (ClassNotFoundException)
2. Create the connection (Connection interface)
3. Prepare the SQL statement (Statement and PreparedStatement)
4. Fire the statement
5. Handle the result (ResultSet)
6. close the connection
 */

package com.springpeople.jdbcdemo.connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	
	public static Connection createConnection() {
		Connection con = null;
		try {
			//register the Driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//create connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_paychex", 
					"root", "Pass1234");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch(SQLException e) {
			System.out.println(e.getMessage() + ", Error Code: " + e.getErrorCode());
		}
		
		return con;
	}
}
