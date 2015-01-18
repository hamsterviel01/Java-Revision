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
	
	protected void importTreeData(int[] valueArray, int[] leftChildIndexArray, int[] rightChildIndexArray, int[] parrentIndexArray, int rootIndex){
		this.valueArray = valueArray;
		this.leftChildIndexArray = leftChildIndexArray;
		this.rightChildIndexArray = rightChildIndexArray;
		this.parrentIndexArray = parrentIndexArray;
		this.rootIndex = rootIndex;
	}
	
	//10dot4dot2 is name of exercise in Introduction to Algorithms
	protected void printAllNodeValueRecursive10dot4dot2(int i){
		if (leftChildIndexArray[i] == -1 && rightChildIndexArray[i] == -1){
			System.out.println(valueArray[i]);
		}  else if (leftChildIndexArray[i] != -1 && rightChildIndexArray[i] == -1) {
			System.out.println(valueArray[i]);
			printAllNodeValueRecursive10dot4dot2(leftChildIndexArray[i]);
		} else if (rightChildIndexArray[i] != -1 && leftChildIndexArray[i] == -1){
			System.out.println(valueArray[i]);
			printAllNodeValueRecursive10dot4dot2(rightChildIndexArray[i]);
		} else {
			System.out.println(valueArray[i]);
			printAllNodeValueRecursive10dot4dot2(leftChildIndexArray[i]);
			printAllNodeValueRecursive10dot4dot2(rightChildIndexArray[i]);
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
			
		} while (leftMostSiblingContainChildIndex != -2 && leftChildIndexArray[currentNode] != -1 && rightChildIndexArray[currentNode] != -1);
	}
}
