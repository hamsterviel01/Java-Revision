package com.hamsterviel01.www.timus;

import java.math.*;

public class PairsOfIntegers1189 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public int calculatePairsOfInteger(int n){
		int count = 0;
		boolean even = (n%2 == 0);
		
		//i must >= 1 because n has at least 2 digits
		for (int i = 0; i<=String.valueOf(n).length(); i++){
			for (int m = 0; m <= 9; m++){
				//give a1 value, calculate a2
				//n = 11*a1*10^i + 2*a2 + m*10^i
				int tenPowerI = tenToPow(i);
				
				for (int a1 = 1; 11*a1*tenPowerI <= n; a1++){
					//check if a1 and n with odd and even
					if (i!=0){
						if (even) {
							int a2 = (n - m*tenPowerI - 11*a1*tenPowerI)/2;
							count++;
							constructIntegerPair(a1, a2, m, i);
						}
					} else {
						
					}
				}
				
			}
		}
		
		return count;
	}
	
	public int[] constructIntegerPair(int a1, int a2, int m, int i){
		int tenPowerI = tenToPow(i);
		return new int[]{a1*tenPowerI*10 + m*tenPowerI + a2, a1*tenPowerI + a2};
	}
	
	public int tenToPow(int i){
		return (int)Math.pow(10.0, (double)(i));
	}

}
