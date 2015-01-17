package DataStructure;

public class BinaryTree {
	private int numberOfNodes;
	private int rootIndex; 
	private int[] valueArray;
	private int[] leftChildIndexArray;
	private int[] rightChildIndexArray;
	private int[] parrentIndexArray;
	
	public BinaryTree(int numberOfNodes){
		this.numberOfNodes = numberOfNodes;
		
		valueArray = new int[this.numberOfNodes];
		leftChildIndexArray = new int[this.numberOfNodes];
		rightChildIndexArray = new int[this.numberOfNodes];
	}
	
	protected void importTreeData(int[] valueArray, int[] leftChildIndexArray, int[] rightChildIndexArray, int rootIndex){
		this.valueArray = valueArray;
		this.leftChildIndexArray = leftChildIndexArray;
		this.rightChildIndexArray = rightChildIndexArray;
		this.rootIndex = rootIndex;
	}
	
	protected void printAllNodeValue(int i){
		if (leftChildIndexArray[i] == -1 && rightChildIndexArray[i] == -1){
			System.out.println(valueArray[i]);
		}  else if (leftChildIndexArray[i] != -1 && rightChildIndexArray[i] == -1) {
			System.out.println(valueArray[i]);
			printAllNodeValue(leftChildIndexArray[i]);
		} else if (rightChildIndexArray[i] != -1 && leftChildIndexArray[i] == -1){
			System.out.println(valueArray[i]);
			printAllNodeValue(rightChildIndexArray[i]);
		} else {
			System.out.println(valueArray[i]);
			printAllNodeValue(leftChildIndexArray[i]);
			printAllNodeValue(rightChildIndexArray[i]);
		}
	}
}
