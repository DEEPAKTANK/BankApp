package com.banking;

import java.util.Scanner;

public class ActionClass extends AccountDetails {
 
	private String username;
	private String pswd;
	double bal;
	String token;
	public void action() throws Exception
	{ 
		Scanner sc=new Scanner(System.in);
		System.out.println("\t Press 1 to Create Account.");
		System.out.println("\t Press 2 to Log-in.");
		System.out.println("\t Press 3 forgot username/password");
		int input=sc.nextInt();
		switch(input) 
		{
		case 1: userdetails();
		       break;
		case 2: System.out.print("Enter username: ");
                String uname2=sc.next();
                System.out.print("Enter password: ");
                String pswd1=sc.next();
	      		boolean vpswd =Validate.vLogin(uname2,pswd1);
				 if(vpswd) {
					 this.username=uname2;
					 this.token=Validate.vtoken(username);
		        	home();
		        }
		        else {
		        	System.out.println("Incorrect Credentials.Try again.");
		        	action();break;
		        }
		case 3: forgotCredential();
		default: System.err.println("Enter valid option");
		        action();
		}
		}

	  void home() throws Exception {
		System.out.println("\t Enter 1 to Add balance.");
		System.out.println("\t Enter 2 to Withdraw money.");
		System.out.println("\t Enter 3 to Check Balance.");
		System.out.println("\t Enter 4 to reset credential.");
		System.out.println("\t Press 0 to LogOut.");
		int input= sc.nextInt();
		switch(input) {
		case 1:System.out.print("Enter amount to Deposit:₹ ");
		       double bal=sc.nextInt();	       
		       setBal(bal,username);
		       System.out.println("Current balance: "+Validate.vBal(username));
		       home();
		       System.out.println();break;
		case 2: withdraw(username);
		       System.out.println("Current Balance: "+Validate.vBal(username));
		       System.out.println("\n");
		       home();break;
		case 3:this.bal=Validate.vBal(username);	
			System.out.print( "₹ "+this.bal);System.out.println("\n");
		       home();break;
		case 4: resetCredential();break;
		case 0: action();
		default: System.err.println("Invalid Input. Try again");
		        home();
		}
	}
	
	private void resetCredential() throws Exception {
	
		System.out.println("\t Enter 1 to reset pin.");
		System.out.println("\t Enter 2 to reset username.");
		System.out.println("\t Enter 0 to return to Home.");
		int input=sc.nextInt();
		switch(input) {
		
		case 1:System.out.print("Enter username: ");
		      String uname1=sc.next();
		      System.out.print("Enter password :");
		      String pswd1=sc.next();
		      if(uname1.equals(username)&& pswd1.equals(Validate.vpassword(username))) {
		    	  Validate.resetpin(username);;
		    	  home();break;  }
		      else {
		    	  System.out.println("Invalid username/password.");
		    	  home();break; }
		case 2:System.out.print("Enter old username:");
		       String uname11=sc.next();
		       if(uname11.equals(Validate.vuname(token))) {
		    	   Validate.resetUsername(token);		    	   
		       }
		       else {
		    	   System.out.println("Invalid username. Try again");
		    	   home();break;
		       }
		case 0:home();break;
		default:System.out.println("Enter valid input.");
		        home();
		        }
		}
	private void forgotCredential() throws Exception {
		System.out.println("\t Enter 1 to to get username.");
		System.out.println("\t Enter 2 to forgot password.");
		System.out.println("\t Enter 0 to return to Login Page.");
		int input=sc.nextInt();
		switch(input) {
		case 1:System.out.print("Enter token number:");
	       String ctoken=sc.next();
	       System.out.print("Enter password:");
	       String cpswd=sc.next();
	       System.out.print("Enter pin:");
	       int pin=sc.nextInt();
	       if(cpswd.equals(Validate.vpassword(ctoken,pin))&& pin==Validate.vpin(ctoken)) {
		   System.out.println("Your username is :"+ Validate.vuname(ctoken));
		   break;
		   }
	       else {
	    	   System.out.println("Invalid token number/password.");
	    	   action();
	       }
	    case 2:System.out.print("Enter Username:");
              String cuname=sc.next();
              System.out.print("Enter Token number:");
              String cctoken=sc.next();
             if(cuname.equals(Validate.vuname(cctoken))&& cctoken.equals(Validate.vtoken(cuname))) {
          	   Validate.resetPswd(cuname);
         	   action();break;}
	    case 0: action();break;
	    default:System.out.println("Enter valid input.");
                forgotCredential();
		}
		
	}
	}
