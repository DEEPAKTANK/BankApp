package com.banking;

public class Passworsd {
	String pswd;
	public void setPswd(String pswd) {
		if(Character.isUpperCase(pswd.charAt(0))&&pswd.length()>=8){
			if(pswd.contains("@")
				||pswd.contains("#")||pswd.contains("$")||pswd.contains("%")||pswd.contains("&")
				||pswd.contains("*")) {
				if(pswd.contains("0")||pswd.contains("1")||pswd.contains("2")||pswd.contains("3")||
						pswd.contains("4")||pswd.contains("5")||pswd.contains("6")||
						pswd.contains("7")||pswd.contains("8")||pswd.contains("9")) {
			
			this.pswd=pswd;
			System.out.println("password saved");}
				else {
					System.out.println("Invalid password");
				}

		}
			else
				System.out.println("Invalid password");}
		else 
			System.out.println("Invalid password");
		}
}
