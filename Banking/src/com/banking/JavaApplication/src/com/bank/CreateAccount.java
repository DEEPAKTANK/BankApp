package com.banking.JavaApplication.src.com.bank;

import java.util.Scanner;

public class CreateAccount {

	private String uname;
	private int pswd;
	private double bal;
	public void setUname(String uname) throws Exception {
		
		if(uname.length()==8&& uname.charAt(0)>='A'&&uname.charAt(0)<='Z'
				) {
		this.uname=uname;
		//String quname="INSERT INTO `db_bank`.`banktable` (`username`, `password`) VALUES ('deepak', 'dddas');";
		}
		else {
			System.err.println("Username must be of 8 characters and starts with an uppercase alphabet. ");
			throw new Exception("Invalid Username.");
		}
	}
	public String getUname() {
		return uname;
		}
	public void setPswd(int pswd) throws Exception {
		if(pswd>=1000&&pswd<=9999) {
		this.pswd=pswd;
		System.out.println("\n Password successfully saved");
		}
		else {
			System.err.println("Password must be of 4 digit. ");

			throw new Exception(" Invalid Password");
		}
	}
	public int getPswd() {
		return pswd;
		}

	public void setBal(double cash) {
	    double bal=0;
		bal=cash+bal;
		double newBal=bal+this.bal;
		this.bal= newBal;
		System.out.println("Amount deposited \t");
	}
	public double getBal() {
		return bal;
	}
	public void wdraw() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("For withdrawal \n");
		System.out.println("Enter username: \n" );
		String uname=sc.next();
		System.out.println("Enter password: ");
		int pswd=sc.nextInt();
		if(pswd==this.pswd && uname.equals(this.uname)) {
			System.out.print("Enter the amount : ₹ ");
			int amount=sc.nextInt();
			if(amount<this.bal) {
				double newBal=this.bal-amount;
				System.out.println("\t Amount withdraw Successful. \n");
				//System.out.println("Balance :"+(newBal));
				this.bal=newBal;
				}
			else
				throw new Exception("Insufficient balance");
		}
		else
			throw new Exception("Incorrect Id or Password. Try again.");
}
	public void action() throws Exception{
	
			Scanner sc=new Scanner(System.in);
			System.out.println("\t Press 1 to Add balance");
			System.out.println("\t Press 2 to Withdraw amount");
			System.out.println("\t Press 3 to check Balance");
			System.out.println("\t Press 4 to reset username.");
			System.out.println("\t Press 5 to reset Password.");
			System.out.println("\t Press 6 to exit.");

			int choice=sc.nextInt();

			switch(choice) {
			case 1: System.out.print("Enter amount to Deposit:₹ ");
			int bal=sc.nextInt();
			setBal(bal);action();System.out.println();
			break;
			case 2: wdraw();System.out.println("\n");action();break;
			case 3: System.out.print( "₹ "+getBal());
			System.out.println("\n");
			action();break;
			case 4: System.out.println("Enter new username :");
			       String uname=sc.next();
				setUname(uname);System.out.println("\n");
		        action();break;
			case 5: System.out.println("Enter new Password :");
		       int pswd=sc.nextInt();
			setPswd(pswd);System.out.println("\n");
	        action();break;
			case 6: System.out.println("Thank you.");throw new Exception("Exit");
			default: System.out.println("Enter valid choice ");
			System.out.println();
			        action();
			        
	}
}}
