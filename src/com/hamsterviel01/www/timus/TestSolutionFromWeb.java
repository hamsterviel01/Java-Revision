package com.hamsterviel01.www.timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class TestSolutionFromWeb {

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
