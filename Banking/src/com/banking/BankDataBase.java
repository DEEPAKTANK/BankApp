package com.banking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BankDataBase {

	public static void main(String[] args) throws Exception {

		Class driverClass = Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/db_bank";
	    String user = "root";
	    String pass = "deepak@123"; 
		String query="";
		Connection con=DriverManager.getConnection(url, user, pass);
    	Statement st= con.createStatement();
    	System.out.println("server Online");
		st.executeUpdate(query);
	}

}
