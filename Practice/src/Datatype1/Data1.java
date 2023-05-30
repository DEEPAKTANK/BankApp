package Datatype1;

import java.util.ArrayList;

public class Data1 {
	Object a;
	public Data1(String a){
		this.a=a;
	}
	public String toString() {
		
		
		return (String) a;
		
	}
	private void store(Object a) {
		ArrayList<Object>b=new ArrayList<>();
		b.add(a);
		
	}

}
