package DataStructureInOOP;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arrayValue = {-1, 12, 15, 4, 10, 2, 18, 7, 14, 21, 5};
		int[] arrayLeft = {-1, 7, 8, 10, 5, -1, 1, -1, 6, -1, -1};
		int[] arrayRight = {-1, 3, -1, -1, 9, -1, 4, -1, 2, -1, -1};
		BinaryTree tree1 = new BinaryTree(arrayValue, arrayLeft, arrayRight);
		
		tree1.printAllNodeValueRecursive10dot4dot2(6);
		
		int treeMaxNumberOfNode = 12;
		int rootIndex = 4;
		int[] keyArray = 			{ 1,  2,  3,  4,  5,  5,  6,  7,  8, 10, 11,  9};
		int[] parentArray = 		{ 1,  2,  4,  2, -1,  6,  8,  6,  4,  8,  9,  9};
		int[] leftChildArray = 		{-1,  0,  1, -1,  2, -1,  5, -1,  6, 11, -1, -1};
		int[] rightChildArray = 	{-1, -1,  3, -1,  8, -1,  7, -1,  9, 10, -1, -1};
		int[] satelliteData = 		{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
		String[] color = 			{"black", "black", "black", "black", "black", "black", "black", "black", "black", "black", "black", "black"};
		BinarySearchTree binarySearchTree1 = new BinarySearchTree(rootIndex, treeMaxNumberOfNode, keyArray, parentArray, leftChildArray, rightChildArray, satelliteData);
		RedBlackTree tree = new RedBlackTree(rootIndex, treeMaxNumberOfNode, keyArray, parentArray, leftChildArray, rightChildArray, satelliteData, color);
		
		tree.printInOrderTreeWalk();
		binarySearchTree1.printInOrderTreeWalk();
		binarySearchTree1.delete(5);
		binarySearchTree1.printInOrderTreeWalk();
		binarySearchTree1.printPreOrderTreeWalk();
		binarySearchTree1.insert(3);
		binarySearchTree1.printInOrderTreeWalk();
		binarySearchTree1.printPreOrderTreeWalk();
	}
}
