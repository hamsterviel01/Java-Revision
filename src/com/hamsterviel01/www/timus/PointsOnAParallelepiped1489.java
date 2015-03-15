package com.hamsterviel01.www.timus;

import java.util.*;
import java.io.*;

public class PointsOnAParallelepiped1489 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in1 = new Scanner(System.in);
		Scanner in2 = new Scanner(System.in);
		Scanner in3 = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		out.print(calculate3DDistance(in1.nextInt(), in1.nextInt(), in1.nextInt(), in2.nextDouble(), in2.nextDouble(), in3.nextDouble(), in3.nextDouble()));
		out.flush();
	}
	
	static double[] convert2DInto3D(int a, int b, int c, double x, double y){
		/** There are 6 plan we need to take into consideration
		 * We will transform 2D coordinate into 3D coordinate
		 * */
		if (x>=c && x<=c+a && y>(2*b+c)){
			return new double[]{x-c, y, y-2*b+c};
		} else if (x<c && y>=(b+c) && y<=(2*b+c)){
			return new double[]{0, y-b-c, c-x};
		} else if (x>(c+a) && y>=(b+c) && y<=(2*b+c)){
			return new double[]{a, y-b-c, x-a-c};
		} else if (x>=c && x<=(c+a) && y>=b && y<(b+c)){
			return new double[]{x-c, 0, y-b};
		} else {
			return new double[]{x-c, y, c};
		}
	}
	
	static double calculate3DDistance(int a, int b, int c, double x1, double y1, double x2, double y2){
		double[] point1 = convert2DInto3D(a, b, c, x1, y1);
		double[] point2 = convert2DInto3D(a, b, c, x2, y2);
		
		double distance1 = Math.abs(point1[0] - point2[0]);
		double distance2 = Math.abs(point1[1] - point2[1]);
		double distance3 = Math.abs(point1[2] - point2[2]);
		
		return Math.sqrt(distance1 * distance1 + distance2 * distance2 + distance3 * distance3);
	}
}
