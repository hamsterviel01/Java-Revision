/**
 * 
 */
package DataStructure;

/**
 * @author tuananhn
 *
 */
public class BinarySearchTree {
	private int treeMaxNumberOfNode;
	private int rootIndex;
	private int[] keyArray;
	private int[] parentArray;
	private int[] leftChildArray;
	private int[] rightChildArray;
	private int[] satelliteData;
	private Stack emptySpaceManager;
	private ExceptionAlerts exceptionAlerts = new ExceptionAlerts();
	
	//For now, we assume what they insert is indeed a binary search tree
	public BinarySearchTree(int rootIndex, int treeMaxNumberOfNode, int[] keyArray, int[] parentArray, int[] leftChildArray, int[] rightChildArray){
		this.treeMaxNumberOfNode = treeMaxNumberOfNode;
		if (keyArray.length != treeMaxNumberOfNode){
			System.out.println(exceptionAlerts.arrayLengthMismatchAlert);
			return;
		}
		if (parentArray.length != treeMaxNumberOfNode){
			System.out.println(exceptionAlerts.arrayLengthMismatchAlert);
			return;
		}
		if (leftChildArray.length != treeMaxNumberOfNode){
			System.out.println(exceptionAlerts.arrayLengthMismatchAlert);
			return;
		}
		if (rightChildArray.length != treeMaxNumberOfNode){
			System.out.println(exceptionAlerts.arrayLengthMismatchAlert);
			return;
		}
		
		// May need to check if what people insert is a binary search tree --> here is better than outside constructor
		
		this.rootIndex = rootIndex;
		this.keyArray = keyArray;
		this.parentArray = parentArray;
		this.leftChildArray = leftChildArray;
		this.rightChildArray = rightChildArray;
		emptySpaceManager = new Stack(treeMaxNumberOfNode);
		
		//initialize emptySpaceManager
		
	}
	
	protected void printInOrderTreeWalk(int startNode){
		//print tree from start node x: x.left -> print x --> print x.right
		System.out.println(startNode);
		if (leftChildArray[startNode] != -1){
			printInOrderTreeWalk(leftChildArray[startNode]);
		}
		if (rightChildArray[startNode] != -1){
			printInOrderTreeWalk(rightChildArray[startNode]);
		}
	}
	
	protected void printPreOrderTreeWalk(){
		
	}
	
	protected void printPostOrderTreeWalk(){
		
	}
	
	protected int[] sucessor(int key){
		
	}
	
	protected int[] precedessor(int key){
		
	}
	
	protected int[] minNode(){
		int currentNodeIndex = rootIndex;
		int[] minNode = new int[4];
		
		//if tree is not empty
		if (!isEmpty()){
			while (leftChildArray[currentNodeIndex] != -1){
				currentNodeIndex = leftChildArray[currentNodeIndex];
			}
			minNode[0] = keyArray[currentNodeIndex];
			minNode[1] = parentArray[currentNodeIndex];
			minNode[2] = leftChildArray[currentNodeIndex];
			minNode[3] = rightChildArray[currentNodeIndex];
			minNode[4] = satelliteData[currentNodeIndex];
			return minNode;
		} else {
			System.out.println("Tree is empty!");
			return minNode;
		}
	}
	
	protected int[] maxNode(){
		int currentNodeIndex = rootIndex;
		int[] maxNode = new int[4];
		
		//if tree is not empty
		if (!isEmpty()){
			while (rightChildArray[currentNodeIndex] != -1){
				currentNodeIndex = rightChildArray[currentNodeIndex];
			}
			maxNode[0] = keyArray[currentNodeIndex];
			maxNode[1] = parentArray[currentNodeIndex];
			maxNode[2] = leftChildArray[currentNodeIndex];
			maxNode[3] = rightChildArray[currentNodeIndex];
			maxNode[4] = satelliteData[currentNodeIndex];
			return maxNode;
		} else {
			System.out.println("Tree is empty!");
			return maxNode;
		}
	}
	
	protected void insert(int key){
		
	}
	
	protected void delete(int key){
		
	}
	
	//O(1)
	protected boolean isEmpty(){
		//if root has no key --> no root
		if (keyArray[rootIndex] == -1){
			return true;
		}
		return false;
	}
	
	//O(1)
	protected boolean isFull(){
		return !emptySpaceManager.isEmpty();
	}
	
	//T(n) = O(h)
	protected boolean isExist(int key){
		//check if key is root	
		if (key == rootIndex){
			return true;
		} else {
			do {
				//check if node is a valid child of its parent (either right child or left child)
				if (rightChildArray[parentArray[key]] == key || leftChildArray[parentArray[key]] == key){
					// check node's parent --> see if it valid
					key = parentArray[key]; 
				} else {
					return false;
				}
			}
			while (parentArray[key] != -1);
			
			//see if the oldest ancestor is root.
			if (key == rootIndex){
				return true;
			} else {
				return false;
			}
		}
	}
}
