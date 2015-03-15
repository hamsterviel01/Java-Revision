/**
 * 
 */
package com.hamsterviel01.www.javabasic;

import com.hamsterviel01.www.algorithm.advancetechnique.*;
import com.hamsterviel01.www.algorithm.advancetechnique.Sorting;
import com.hamsterviel01.www.algorithm.basictechnique.*;
/**
 * @author tuananhn
 *
 */
public class VarargType {

	/**
	 * This also shows how you can use varargs with a specified type other than Object. 
	 * Here, all the varargs must be String objects. It�s possible to use any type of argument 
	 * in varargs, including a primitive type. The following example also shows that the vararg 
	 * list becomes an array, and if there�s nothing in the list it�s an array of size zero:
	 */
	// TODO Auto-generated constructor stub
	static void f(Character... args) {
		System.out.println(args.getClass());
		System.out.println(" length " + args.length);
		for(Object obs : args)
			System.out.println(obs);
	}
	
	static void f(int... args){
		System.out.print(args.getClass() + ": ");
		for(int i: args)
			System.out.print(i + ", ");
		System.out.print("\n");
	}
	
	static void f(Integer... args){
		System.out.print(args.getClass() + ": ");
		for(int i: args)
			System.out.print(i + ", ");
		System.out.print("\n"); //new line
	}
	
	static void g(int... args) {
		System.out.println(args.getClass());
		System.out.println(" length " + args.length);
		for(Object obs : args)
			System.out.println(obs);
	}
	
	static void h(Object... args){
		System.out.println(args.getClass() + " " + args.length + " " + args.toString());
	}
	
	public static void main(String[] args) {
		//138 Thinking in Java Bruce Eckel
		//f('a');
		//f();
		f(new int[]{1, 2, 4});
		//f(2);
		f(new Integer[]{1, 4, 5});
		g('b');
		g();
		System.out.println("int[]: " + new int[0].getClass());
		h((Object)new Integer[]{3, 4, 5});
		h((Object[])new Integer[]{3, 4, 5});
		h();
		
		/** Test enum type */
		System.out.println(Enumeration.ASDFASD + ": " + Enumeration.ASDFASD.ordinal());
		Enumeration animals = Enumeration.FISH;
		switch (animals){
		case FISH: 
			System.out.println("This is a fish");
			break;
		case DOG:
			System.out.println("Gau Gau Gau");
			break;
		default:
		}
		
		Sorting as = new Sorting();
	}
}
