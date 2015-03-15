/**
 * 
 */
package com.hamsterviel01.www.oopdatastructure;

/**
 * @author tuananhn
 *
 */
public class OrderStatisticTree extends RedBlackTree{
	public OrderStatisticTree(int rootIndex, int treeMaxNumberOfNode, int[] keyArray, int[] parentArray, int[] leftChildArray, int[] rightChildArray, int[] satelliteData, String[] color){
		super(rootIndex, treeMaxNumberOfNode, keyArray, parentArray, leftChildArray, rightChildArray, satelliteData, color);
	}
}
