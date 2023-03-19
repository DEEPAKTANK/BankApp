package Practice;

import java.util.Scanner;

public class Demo {
	public static void main(String[] args) throws Exception {
		
		
		Main1 m=new Main1();
		m.setpassword();
		String str=m.getpassword();
		System.out.println(str);
	}
	
	

}
class Main1{
	Scanner sc=new Scanner(System.in);
	private String pwd;
	private String uname;
	public  void setpassword() throws Exception
	{
		System.out.println("enter password ");
		pwd=sc.next();
		char fl=pwd.charAt(0);
	    char ll=pwd.charAt(pwd.length()-1);
		if((fl=='@'||fl=='!'||fl=='#')&&(ll>='A'&&ll<='Z')) {
		this.pwd=pwd;
		System.out.println(" password saved ");}
		else {
			System.out.println("incorrect");
			setpassword();
		}
		}
	public String getpassword()
	{
		return pwd;
	}
	public void setuname(){
		System.out.println(" enter usename ");
		 String uname=sc.next();
		if(uname.startsWith("@")&&(uname.endsWith("#")))
				{
			this.uname=uname;
			System.out.println("username saved");
			
				}

		
	}
	
	{
		
	}
		
	
}