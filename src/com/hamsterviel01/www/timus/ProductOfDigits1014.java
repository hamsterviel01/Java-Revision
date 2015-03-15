package com.hamsterviel01.www.timus;
/**
 * Your task is to find the minimal positive integer number Q so that the product of digits of Q is exactly equal to N.
 * Input
 * The input contains the single integer number N (0 ≤ N ≤ 10^9).
 * Output
 * Your program should print to the output the only number Q. If such a number does not exist print −1.
 */

import java.io.*;
import java.util.*;

/**
 * @author DrHamsterviel
 *
 */
public class ProductOfDigits1014 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		out.println(getMultiplicand(in.nextInt()));
		out.flush();
	}
	
	static long getMultiplicand(int n){
		int[] multiplicand = new int[36];
		int countDigits = 0;
		
		if (n == 0){
			return 0;
		} else if (n == 1){
			return 1;
		}
		
		for (int digit = 9; digit >= 2; digit--){
			while (n%digit == 0){
				n = n/digit;
				multiplicand[countDigits] = digit;
				countDigits++;
			}
		}
		
		//return null if end-result of this dividing process - n is a number that is not 1
		if (n != 1){
			return -1;
		} else {
			long output = 0;
			for (int i = multiplicand.length - 1; i >= 0; i--){
				if (multiplicand[i] != 0){
					output = output*10 + multiplicand[i];
				}
			}
			return output;
		}
	}
}
