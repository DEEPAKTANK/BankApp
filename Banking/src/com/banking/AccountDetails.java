package com.banking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

   class AccountDetails {
	  static String url = "jdbc:mysql://localhost:3306/db_bank";
	   static String user = "root";
	   static String pass = "deepak@123";
	  
	private String uname;
	private String pswd;
	private double bal;
	 String firstName;
	 String lastName;
	private String token;
	 private int pin;
	Scanner sc=new Scanner(System.in);

public void userdetails() throws Exception {
	
	
	
	System.out.print("Enter first name: ");
	this.firstName=sc.next();
	System.out.print("Enter last name: ");
	this.lastName=sc.next();
	System.out.println("--Wait for 10 seconds your token number is being generated--");
	Thread.sleep(10000);
	Random r=new Random();
	int num=r.nextInt(10000);
	this.token="BOO-"+num;
	System.out.println("Your token number is: "+this.token);
	setUname();
	setPswd();
	setPin();
	Class driverClass = Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection(url, user, pass);
	Statement st= con.createStatement();
	System.out.println("server Online");
	String query="INSERT INTO `db_bank`.`bank` (`token`, `first_name`, `last_name`, `user_name`, `password`, `balance`, `pin`) "
			+ "VALUES ('"+getToken()+"', '"+firstName+"', '"+lastName+"', '"+getUname()+"', '"+getPswd()+"', '"+getBal()+"', '"+getPin()+"');";
	
	st.executeUpdate(query);
	st.close();
	con.close();
	System.out.println("-------Account Created Successfully--------");
	
}
public String getToken() {
	return token;
}
public void setUname() throws Exception {
	System.out.println("Enter new username:");
	String uname=sc.next();
	if(uname.length()>=8&& uname.charAt(0)>='A'&&uname.charAt(0)<='Z'
			) {
	this.uname=uname;
	System.out.println("username saved.");
	}
	else {
		System.err.println("Username must be of 8 characters and starts with an uppercase alphabet. ");
		System.out.println("try again");
		setUname();
		//throw new Exception("Invalid Username.");
	}
}
public String getUname() {
	return uname;
}
public void setPswd() {
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
		this.pswd=pswd;
		System.out.println("password saved");
		}
		else {
			System.out.println("Invalid password");
			System.out.println("Try again");
			setPswd();
			}
		}
			else {
				System.out.println("Invalid password");
				System.out.println("Try again");
				setPswd();
				}
			}
		else {
			System.out.println("Invalid password");
		System.out.println("Try again");
		setPswd();
		}
		}
	else {
		System.out.println("Invalid password");
	System.out.println("Try again");
	setPswd();
	}
	}
public String getPswd() {
	return pswd;
}

public void setPin() throws Exception {
	System.out.println("Enter new pin code:");
	System.err.println("--Pin code must be of  6 digits--");
	int pin=sc.nextInt();
	if(pin>=10000&&pin<=999999) {
		System.out.print("Re-enter pin code:");
		int  repin=sc.nextInt();
		if(pin==repin) {
			this.pin=pin;
	
			System.out.println("Pin code saved.");
		}
		else {
			System.out.println("Pin mismatch .Try again");
			setPin();
		}
	}
	else {
		System.out.println("Invalid pin.Try again");
		setPin();
	}
}
public int getPin() {
	return pin;
}
public double getBal() {
	return bal;
}
public void setBal(double cash,String uname2) throws Exception {
	 Class.forName("com.mysql.cj.jdbc.Driver");
   
	Connection con=DriverManager.getConnection(url, user, pass);
 	Statement st= con.createStatement();
 	System.out.println("server Online");
    String query1="select balance from db_bank.bank\r\n"
			+ "where user_name='"+uname2+"';";
    ResultSet rs=st.executeQuery(query1);  		  
	rs.next();  
	this.bal=rs.getDouble(1);
	double newBal=cash+this.bal;
	this.bal= newBal;
 	String query="UPDATE `db_bank`.`bank` SET `balance` = '"+this.bal+"' WHERE (`user_name` = '"+uname2+"');";
 	st.executeUpdate(query);
	
	System.out.println("Amount deposited \t");
	st.close();
	con.close();
}


public void withdraw(String uname2) throws Exception {
	if(Validate.vBal(uname2)>0) {
	System.out.println("For withdrawal ");
	System.out.println("-------------------");
	System.out.println("\n");
		System.out.print("Enter the amount : ₹ ");
		double amount=sc.nextDouble();
		System.out.print("Enter pin code: ");
		int cpin=sc.nextInt();
		
		Connection con=DriverManager.getConnection(url, user, pass);
	 	Statement st= con.createStatement();
	 	System.out.println("server Online");
	    String query1="select pin from db_bank.bank\r\n"
				+ "where user_name='"+uname2+"';";
	    ResultSet rs=st.executeQuery(query1);  		  
		rs.next();  
		pin=rs.getInt(1);
		
		if(cpin==pin) 
		{
			if(amount<Validate.vBal(uname2)) 
			{
				double newBal=Validate.vBal(uname2)-amount;
				System.out.println("\t Amount withdraw Successful. \n");
				this.bal=newBal;
				System.out.println("Balance :"+(newBal));
				String query="UPDATE `db_bank`.`bank` SET `balance` = '"+this.bal+"' WHERE (`user_name` = '"+uname2+"');";
			 	st.executeUpdate(query);
				
				
			}
			else {
				System.err.print("Insufficient balance.");
				}
			}
		else {
			throw new Exception(" Invalid PIN CODE");
			}
	}
	else {
		System.out.println("Insufficient balance.");
	    
	}
}
	
}
