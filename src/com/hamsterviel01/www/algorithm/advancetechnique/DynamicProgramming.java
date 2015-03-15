/**
 * 
 */
package com.hamsterviel01.www.algorithm.advancetechnique;

/**
 * @author tuananhn
 *
 */
public class DynamicProgramming {

	/**
	 * 
	 */
	
	String[] sequence1;
	String[] sequence2;
	public DynamicProgramming(String[] sequence1, String[] sequence2) {
		// TODO Auto-generated constructor stub
		this.sequence1 = sequence1;
		this.sequence2 = sequence2;
	}
	
	
	//May be write a program to find longest sub-sequence of 2 arrays of strings --> DNA stuffs, etc.
	public void topDownWithMemoization(){
		
	}
	
	public void bottomUpMethod(){
		
	}
	
	public int similarityOfTwoSequence(){
		/*Using bottom up appoarch
		 * 4 steps:
		 * - Characterize the structure of an optimal solution
		 * - Recursively define the value of an optimal solution
		 * - Compute the value of an optimal solution
		 * - Construct an optimal solution from computed information*/
		
		//This table will store all smallest
		int[][] tableOfSimilarPair= new int [sequence1.length * sequence2.length][2];
		
	}
}
