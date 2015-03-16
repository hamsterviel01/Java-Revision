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

/**
 * Solution from xukien - 0.078s
 * 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class No1014 {

    public static     Stack<Integer> sk= new Stack<Integer>();
    public static boolean isprime(int x)
    {
        if (x<2) return false;
        if (x==2) return true;
        if(x%2==0) return false;
        for (int i=3;i*i<=x;i+=2)
            if (x%i==0) return false;
        return true;
    }

    public static void run(int x)
    {

        if (x/10==0)
        {
            if (x==0) sk.push(10);
            else    sk.push(x);
            return;
        }
        if (isprime(x))
        {
            sk.push(-1);
            return;
        }

        while (x!=1)
        {
            int i;
            for(i=9; i>1; i--)
                if( x%i==0)
                {
                    sk.push(i);
                    x=x/i;
                    if(isprime(x)&&(x>10))
                    {
                        sk.clear();
                        sk.push(-1);
                        return;
                    }
                    break;
                }
            if (i==1)
            {
                sk.clear();
                sk.push(-1);
                return;
            }
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader rd =new BufferedReader( new InputStreamReader(System.in));
        int n=Integer.parseInt(rd.readLine());
        run(n);
        String temp="";
        while(!sk.isEmpty())
        {
            temp+=sk.pop().toString();
        }
            System.out.print(temp);
        System.exit(0);
    }

}
 * */
