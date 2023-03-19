package com.banking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Validate {
	static String url = "jdbc:mysql://localhost:3306/db_bank";
    static String user = "root";
    static String pass = "deepak@123";

	static Scanner sc=new Scanner(System.in);
	
	public void setUname() {}

	public static boolean vLogin(String uname2,String pswd1) throws SQLException, Exception {
	
        Class driverClass = Class.forName("com.mysql.cj.jdbc.Driver");
    	Connection con=DriverManager.getConnection(url, user, pass);
    	Statement st= con.createStatement();

    	String query="select password from db_bank.bank\r\n"
    			+ "where user_name='"+uname2+"';";
    	try{
    		ResultSet rs=st.executeQuery(query); 
    		rs.next();
    		String p=rs.getString(1);
    		if(pswd1.equals(p)) {
    			 return true;
    			 }
    		else
    			return false;
    	}
    	catch(Exception e) {
    		return false;
    	}
	}
	public static double vBal(String uname2) throws Exception {
		 Class driverClass = Class.forName("com.mysql.cj.jdbc.Driver");
	    	Connection con=DriverManager.getConnection(url, user, pass);
	    	Statement st= con.createStatement();
	
	    	String query="select balance from db_bank.bank\r\n"
	    			+ "where user_name='"+uname2+"';";
	    	ResultSet rs=st.executeQuery(query);  		  
			rs.next();  
		return rs.getDouble(1);
		
	}
	public static String vpassword(String uname2) throws Exception {
		 Class driverClass = Class.forName("com.mysql.cj.jdbc.Driver");
	    	Connection con=DriverManager.getConnection(url, user, pass);
	    	Statement st= con.createStatement();
	
	    	String query="select password from db_bank.bank\r\n"
	    			+ "where user_name='"+uname2+"';";
	    	
	    		ResultSet rs=st.executeQuery(query); 
	    		rs.next();
	    		return rs.getString(1);
	}
	public static String vpassword(String token,int pin) throws Exception {
		 Class driverClass = Class.forName("com.mysql.cj.jdbc.Driver");
	    	Connection con=DriverManager.getConnection(url, user, pass);
	    	Statement st= con.createStatement();
	  
	    	String query="select password from db_bank.bank\r\n"
	    			+ "where token='"+token+"';";
	    	
	    		ResultSet rs=st.executeQuery(query); 
	    		rs.next();
	    		return rs.getString(1);
	}
	public static String vuname(String token) throws Exception {
		 Class driverClass = Class.forName("com.mysql.cj.jdbc.Driver");
	    	Connection con=DriverManager.getConnection(url, user, pass);
	    	Statement st= con.createStatement();

	    	String query="select user_name from db_bank.bank\r\n"
	    			+ "where token='"+token+"';";
	    	
	    		ResultSet rs=st.executeQuery(query); 
	    		rs.next();
	    		return rs.getString(1);
	}
	public static String vtoken(String uname2) throws Exception {
		 Class driverClass = Class.forName("com.mysql.cj.jdbc.Driver");
	    	Connection con=DriverManager.getConnection(url, user, pass);
	    	Statement st= con.createStatement();
	      	String query="select token from db_bank.bank\r\n"
	    			+ "where user_name='"+uname2+"';";
	    	
	    		ResultSet rs=st.executeQuery(query); 
	    		rs.next();
	    		return rs.getString(1);
	}
	public static void resetpin(String uname2) throws Exception {
		System.out.println("Enter new pin code:");
		System.err.println("--Pin code must be of  6 digits--");
		int pin=sc.nextInt();
		if(pin>=10000&&pin<=999999) {
			System.out.print("Re-enter pin code :");
			int  repin=sc.nextInt();
			if(pin==repin) {
				Class driverClass = Class.forName("com.mysql.cj.jdbc.Driver");
		    	Connection con=DriverManager.getConnection(url, user, pass);
		    	Statement st= con.createStatement();
		    	System.out.println("server Online");
		    	String query2="UPDATE `db_bank`.`bank` SET `pin` = '"+pin+"' WHERE (`user_name` = '"+uname2+"');";
			 	st.executeUpdate(query2);
			 	
				System.out.println("Pin code saved.");
			}
			else {
				System.out.println("Pin mismatch .Try again");
				resetpin( uname2);
			}
		}
		else {
			System.out.println("Invalid pin.Try again");
			resetpin(uname2);
		}
	}
	public static void resetPswd(String uname) throws Exception {
		System.out.println("Enter new password:");
		System.err.println("Password must be 8 to 16 character long.");
		System.err.println("must Starts with Uppercase alphabet and contain atleast 1digit and 1 special character(@#$%&)");
		String pswd=sc.next();
		if(Character.isUpperCase(pswd.charAt(0))&&pswd.length()>=8&&pswd.length()<=16){
			if(pswd.contains("@")
				||pswd.contains("#")||pswd.contains("$")||pswd.contains("%")||pswd.contains("&")
				||pswd.contains("*")) {
				if(pswd.contains("0")||pswd.contains("1")||pswd.contains("2")||pswd.contains("3")||
						pswd.contains("4")||pswd.contains("5")||pswd.contains("6")||
						pswd.contains("7")||pswd.contains("8")||pswd.contains("9")) {
			System.out.print("Re-enter the password-");
			String copypswd=sc.next();
			if(pswd.equals(copypswd)) {
				Class driverClass = Class.forName("com.mysql.cj.jdbc.Driver");
	    	    Connection con=DriverManager.getConnection(url, user, pass);
	    	    Statement st= con.createStatement();
	    	    System.out.println("server Online");
	    	    String query2="UPDATE `db_bank`.`bank` SET `password` = '"+pswd+"' WHERE (`user_name` = '"+uname+"');";
		     	st.executeUpdate(query2);
		        System.out.println("New Password saved.");
				
			}
			else {
				System.out.println("Invalid password");
				System.out.println("Try again");
				resetPswd(uname);
				}
			}
				else {
					System.out.println("Invalid password. Must contain a Number ");
					System.out.println("Try again");
					resetPswd(uname);
					}
				}
			else {
				System.out.println("Invalid password. Must contain special character '@#$%&*'");
			System.out.println("Try again");
			resetPswd(uname);
			}
			}
		else {
			System.out.println("Invalid password.Must be 8 to 16 character long.");
		System.out.println("Try again");
		resetPswd(uname);
		}
		}
	
	public static void resetUsername(String token) throws Exception {
		System.out.println("Enter new username:");
		String uname=sc.next();
		
		if(uname.length()>=8&& uname.charAt(0)>='A'&&uname.charAt(0)<='Z'
				) {
			System.out.println("Re-enter new username:");
			String uname22=sc.next();
			if(uname22.equals(uname)) {
				Class driverClass = Class.forName("com.mysql.cj.jdbc.Driver");
	    	    Connection con=DriverManager.getConnection(url, user, pass);
	    	    Statement st= con.createStatement();
	    	    System.out.println("server Online");
	    	    String query2="UPDATE `db_bank`.`bank` SET `user_name` = '"+uname+"' WHERE (`user_name` = '"+token+"');";
		     	st.executeUpdate(query2);
		        System.out.println("username saved.");
		    }
			else {
				System.out.println("Username mismatch. Try again");
				resetUsername(token);
			}
		}
		else {
			System.err.println("Username must be of 8 characters and starts with an uppercase alphabet. ");
			System.out.println("try again");
			resetUsername(token);
			}
		}
	public static int vpin(String token) throws Exception {
		Class driverClass = Class.forName("com.mysql.cj.jdbc.Driver");
    	Connection con=DriverManager.getConnection(url, user, pass);
    	Statement st= con.createStatement();
    	String query="select pin from db_bank.bank\r\n"
    			+ "where token='"+token+"';";
    	
    		ResultSet rs=st.executeQuery(query); 
    		rs.next();
    		return rs.getInt(1);
		
		
	}
	
	
	
	
	
	
	
	

}
