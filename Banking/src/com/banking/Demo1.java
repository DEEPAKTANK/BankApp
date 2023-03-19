package com.banking;

import java.sql.*;


public class Demo1 {

  
	public static void main(String[] args) throws Exception, ClassNotFoundException, SQLException {
		Class driverClass = Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("main starts");

		String url = "jdbc:mysql://localhost:3306/db_bank";
	    String user = "root";
	    String pass = "deepak@123"; 
  
//		String query="INSERT INTO `db_bank`.`banktable` (`username`, `password`) VALUES ('Deepak tank', '12345');";
		String query="select * from db_bank.bank\r\n"
	    + "where user_name='Deepak07';";
		Connection con=DriverManager.getConnection(url, user, pass);
    	Statement st= con.createStatement();
    	System.out.println("Connected");
		//st.executeUpdate(query);
		ResultSet rs=st.executeQuery(query);
		while(rs.next())
		 {  
        System.out.println(rs.getString("token")+" -"+rs.getString("password")); 	}	
		st.close();
		con.close();
	}
}
