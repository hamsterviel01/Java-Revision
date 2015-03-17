package com.hamsterviel01.www.timus;

import java.io.*;
import java.util.*;

public class PairsOfIntegers1189 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		PrintWriter out = new PrintWriter(System.out);
		
		out.println(calculatePairsOfInteger(n));
		out.flush();
		calculatePairsOfIntegerPrintOut(n);
	}
	
	public static int calculatePairsOfInteger(int n){
		int count = 0;
		boolean even = (n%2 == 0);
		int lengthOfN = String.valueOf(n).length() - 1;
		
		//n = 11*a1*10^i + 2*a2 + m*10^i
		//what is i?? i is any number that guarantee LHS < RHS
		//i = 0 -> a2 = 0
		//A + B = N;
		//A can start with one 0
		
		for (int i = 0; i<=lengthOfN; i++){
			//give a1 value, calculate a2
			int tenPowerI = tenToPow(i);
			
			//How to calculate m???
			//m is one digit of a1ma2 --> any digit is ok, as long as it fit the equation
			// if i = n --> m != 0
			
			if (i == 0) {
				//a2 is -1, not 0 --> number constructed will be without a2, n = 11a1 + m
				int m = n%11;
				//System.out.println("Checkpoint 5");
				count++;
			} else if (i == lengthOfN){
				// i = n, a1 is -1 and m != 0--> number constructed will be without a1
				// n = 2*a2*10^(lengthOfN-1) + m*10^lengthOfN
				int m = 1;
				while (m*tenPowerI < n){
					if (even){
						count++;
					}
					m++;
				}
			} else if (i!=0 && i!= n){
				for (int m = 0; m <= 9; m++){
					//n = 11*a1*10^i + 2*a2 + m*10^i
					//a1 cannot be any number, it must be greater than 10^(lengthOfN - i - 1 - 1) )extra -1 because A can start with one 0
					int a1 = tenToPow(lengthOfN - i - 2);
					while (11*a1*tenPowerI < n - m*tenPowerI){
						//check if a1 and n with odd and even
						if (even) {
							//System.out.println("Checkpoint 4");
							
							//be aware of this computation 
							int a2 = (n - m*tenPowerI - 11*a1*tenPowerI)/2;
							if (a2 < tenToPow(i)){
								count++;
							}
						}
						a1++;
					}
				}
			}
		}
		
		return count;
	}
	
	public static int calculatePairsOfIntegerPrintOut(int n){
		int count = 0;
		boolean even = (n%2 == 0);
		int lengthOfN = String.valueOf(n).length() - 1;
		
		//n = 11*a1*10^i + 2*a2 + m*10^i
		//what is i?? i is any number that guarantee LHS < RHS
		//i = 0 -> a2 = 0
		//A + B = N;
		//A can start with one 0
		
		for (int i = 0; i<=lengthOfN; i++){
			//give a1 value, calculate a2
			int tenPowerI = tenToPow(i);
			
			//How to calculate m???
			//m is one digit of a1ma2 --> any digit is ok, as long as it fit the equation
			// if i = n --> m != 0
			
			if (i == 0) {
				//a2 is -1, not 0 --> number constructed will be without a2, n = 11a1 + m
				int m = n%11;
				//System.out.println("Checkpoint 5");
				count++;
				constructIntegerPairPrintOut((n - m)/11, -1, m, i, n);
			} else if (i == lengthOfN){
				// i = n, a1 is -1 and m != 0--> number constructed will be without a1
				// n = 2*a2*10^(lengthOfN-1) + m*10^lengthOfN
				int m = 1;
				while (m*tenPowerI < n){
					if (even){
						count++;
						constructIntegerPairPrintOut(-1, (n - m*tenPowerI)/2, m, i, n);
					}
					m++;
				}
			} else if (i!=0 && i!= n){
				for (int m = 0; m <= 9; m++){
					//n = 11*a1*10^i + 2*a2 + m*10^i
					//a1 cannot be any number, it must be greater than 10^(lengthOfN - i - 1 - 1) )extra -1 because A can start with one 0
					int a1 = tenToPow(lengthOfN - i - 2);
					while (11*a1*tenPowerI < n - m*tenPowerI){
						//check if a1 and n with odd and even
						if (even) {
							//System.out.println("Checkpoint 4");
							
							//be aware of this computation 
							int a2 = (n - m*tenPowerI - 11*a1*tenPowerI)/2;
							if (a2 < tenToPow(i)){
								count++;
								constructIntegerPairPrintOut(a1, a2, m, i, n);
							}
						}
						a1++;
					}
				}
			}
		}
		
		return count;
	}
	
	static public int[] constructIntegerPair(int a1, int a2, int m, int i){
		//System.out.println("Checkpoint 7");
		int tenPowerI = tenToPow(i);
		if (a2 != -1 && a1 != -1){
			return new int[]{a1*tenPowerI*10 + m*tenPowerI + a2, a1*tenPowerI + a2};
		} else if (a2 == -1) {
			return new int[]{a1*10 + m, a1};
		} else {
			return new int[]{m*tenPowerI + a2, a2};
		}
		
		//what if a1 is 0 ?????
	}
	
	static public void constructIntegerPairPrintOut(int a1, int a2, int m, int i, int n){
		//System.out.println("Checkpoint 7");
		int tenPowerI = tenToPow(i);
		if (a2 != -1 && a1 != -1){
			System.out.println(a1*tenPowerI*10 + m*tenPowerI + a2 + " + " + a1*tenPowerI + a2 + " = " + n);
		} else if (a2 == -1) {
			System.out.println(a1*10 + m + " + " + a1 + " = " + n);
		} else {
			System.out.println(m*tenPowerI + a2 + " + " + a2 + " = " + n);
		}
		
		//what if a1 is 0 ?????
	}
	
	static public int tenToPow(int i){
		//System.out.println("Checkpoint 8");
		return (int)Math.pow(10.0, (double)(i));
	}

}
