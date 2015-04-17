package com.hamsterviel01.www.javabasic;

import java.util.*;

class Apple {
	int leaves = 2;
	void getLeaves(){
		System.out.println(leaves);
	}
}

class Orange {
	
}

class OrangeVietnam extends Orange {
	void getName(){
		System.out.println(this.getClass());
	}
}

public class GenericsAndUpcasting {

	public static void main(String[] args) {
		// TODO Auto-generated constructor stub
		
		List apple = new ArrayList();
		ArrayList<Orange> orangeSpecific = new ArrayList<Orange>();
		
		Apple object1 = new Apple();
		Orange object2 = new Orange();
		OrangeVietnam object3 = new OrangeVietnam();
		
		apple.add(object1);
		apple.add(object2);
		apple.add(object3);
		
		orangeSpecific.add(object2);
		orangeSpecific.add(object3);
		
		for (Object object : apple) {
			System.out.println(object);
		}
		
//		apple.get(0).getLeaves();
		((OrangeVietnam)orangeSpecific.get(1)).getName();
	}

}
