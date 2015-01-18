package DataStructure;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack stack1 = new Stack(2);
		Queue queue1 = new Queue(3);
		SinglyLinkedList linkedList1 = new SinglyLinkedList(6);
		DoubleLinkedList linkedList2 = new DoubleLinkedList(5);
		BinaryTree tree1 = new BinaryTree(11);
		int[] arrayValue = {-1, 12, 15, 4, 10, 2, 18, 7, 14, 21, 5};
		int[] arrayLeft = {-1, 7, 8, 10, 5, -1, 1, -1, 6, -1, -1};
		int[] arrayRight = {-1, 3, -1, -1, 9, -1, 4, -1, 2, -1, -1};
		
		tree1.importTreeData(arrayValue, arrayLeft, arrayRight, 6);
		tree1.printAllNodeValueRecursive10dot4dot2(6);
	}

}
