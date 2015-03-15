package com.hamsterviel01.www.timus;

import java.util.*;
import java.io.*;

public class Dwarf1283 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		out.print(yearLeft(in.nextInt(), in.nextInt(), in.nextInt()));
		out.flush();
	}
	
	static int yearLeft(int a, int b, int c){
		//if b > a --> year is 0
		if (b >= a){
			return 0;
		} else if (a == 0) {
			return 0;
		} else {
			//if b < a
			//convert b and a into double
			double bDouble = (double)b;
			double aDouble = (double)a;
			double cDouble = (double)c;

			return (int)Math.ceil((Math.log(bDouble/aDouble) / Math.log(1 - cDouble/100)));
		}
		
	}
}
