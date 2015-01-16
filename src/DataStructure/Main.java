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
		
		linkedList2.insertLinkedList(23, 0);
		linkedList2.insertLinkedList(22, 0);
		linkedList2.insertLinkedList(21, 1);
		linkedList2.insertLinkedList(25, 2);
		linkedList2.insertLinkedList(27, 0);
		linkedList2.insertLinkedList(21, 1);
		
		linkedList2.deleteLinkedList(0);
		linkedList2.deleteLinkedList(3);
		linkedList2.deleteLinkedList(2);
	}

}
