
package com.banking.JavaApplication.src.com.bank;

import java.util.Scanner;

public class Credentials extends CreateAccount{
	public void credit() throws Exception {
	Scanner sc= new Scanner(System.in);
	System.out.println("Create Account ");
	System.out.println("Provide username");
	System.err.println("Username must be of 8 characters and starts with an uppercase alphabet. ");
	String uname=sc.next();
	setUname(uname);
	System.out.println("Username saved");
	System.out.println("Enter 4 digit password:");
	int pswd=sc.nextInt();
	setPswd(pswd);
}
}
