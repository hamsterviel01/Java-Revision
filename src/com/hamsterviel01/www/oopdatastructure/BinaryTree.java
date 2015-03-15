package com.hamsterviel01.www.oopdatastructure;

public class BinaryTree {
	private int numberOfNodes;
	private int rootIndex = 0; 
	private BinaryTreeNode[] binaryTree;
	
	//create empty tree
	public BinaryTree(int numberOfNodes){
		this.numberOfNodes = numberOfNodes;
		binaryTree = new BinaryTreeNode[numberOfNodes];
	}
	
	//create a full tree
	public BinaryTree(BinaryTreeNode[] binaryTree, int rootIndex){
		this.rootIndex = rootIndex;
		this.binaryTree = binaryTree;
	}
	
	public BinaryTree(int[] arrayValue, int[] arrayLeft, int[] arrayRight){ 
		binaryTree = new BinaryTreeNode[11];
		
		for (int i = 0; i < binaryTree.length; i++){
			this.binaryTree[i] = new BinaryTreeNode();
			this.binaryTree[i].setIndex(i);
			this.binaryTree[i].setValue(arrayValue[i]);
			this.binaryTree[i].setLeftChildIndex(arrayLeft[i]);
			this.binaryTree[i].setRightChildIndex(arrayRight[i]);
		}
	}
	
	//10dot4dot2 is name of exercise in Introduction to Algorithms
	protected void printAllNodeValueRecursive10dot4dot2(int i){
		if (binaryTree[i].getLeftChildIndex() == -1 && binaryTree[i].getRightChildIndex() == -1){
			System.out.println(binaryTree[i].getValue());
		}  else if (binaryTree[i].getLeftChildIndex() != -1 && binaryTree[i].getRightChildIndex() == -1) {
			System.out.println(binaryTree[i].getValue());
			printAllNodeValueRecursive10dot4dot2(binaryTree[i].getLeftChildIndex());
		} else if (binaryTree[i].getRightChildIndex() != -1 && binaryTree[i].getLeftChildIndex() == -1){
			System.out.println(binaryTree[i].getValue());
			printAllNodeValueRecursive10dot4dot2(binaryTree[i].getRightChildIndex());
		} else {
			System.out.println(binaryTree[i].getValue());
			printAllNodeValueRecursive10dot4dot2(binaryTree[i].getLeftChildIndex());
			printAllNodeValueRecursive10dot4dot2(binaryTree[i].getRightChildIndex());
		}
	}
	
	protected void printAllNodeValueNonRecursive10dot4dot5(){
		int level = 0;
		int currentNode = rootIndex;
		
		//Store array index of leftmost element which has the same level that has child
		//-1 if that element is not found yet
		//-2 if there is no such element
		int leftMostSiblingContainChildIndex = rootIndex;
		
		do {
			
		} while (leftMostSiblingContainChildIndex != -2 && binaryTree[currentNode].getLeftChildIndex() != -1 && binaryTree[currentNode].getRightChildIndex() != -1);
	}
}
