package com.hamsterviel01.www.javabasic;

abstract class A {
	
}

abstract class B {
	
}

public class TestBed {
	public void f() { System.out.println("f()"); }
	public static class Tester {
		public static void main(String[] args) {
			TestBed t = new TestBed();
			t.f();
		}
	}
	
	public class testMultipleAbstract extends A, B {
		
	}
}
