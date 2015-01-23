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
	
	protected void printInOrderTreeWalk(){
		printRecursiveInOrderTreeWalk(rootIndex);
	}
	
	protected void printRecursiveInOrderTreeWalk(int startNode){
		//print tree from start node x: x.left -> print x --> print x.right
		if (leftChildArray[startNode] != -1){
			printRecursiveInOrderTreeWalk(leftChildArray[startNode]);
		}
		System.out.println(keyArray[startNode]);
		if (rightChildArray[startNode] != -1){
			printRecursiveInOrderTreeWalk(rightChildArray[startNode]);
		}
	}
	
	protected void printPreOrderTreeWalk(){
		printRecursivePreOrderTreeWalk(rootIndex);
	}
	
	protected void printRecursivePreOrderTreeWalk(int currentNode){
		System.out.println(keyArray[currentNode]);
		if (leftChildArray[currentNode] != -1){
			printRecursivePreOrderTreeWalk(leftChildArray[currentNode]);
		}
		if (rightChildArray[currentNode] != -1){
			printRecursivePreOrderTreeWalk(rightChildArray[currentNode]);
		}
	}
	protected void printPostOrderTreeWalk(){
		printRecursivePostOrderTreeWalk(rootIndex);
	}
	
	protected void printRecursivePostOrderTreeWalk(int currentNode){
		System.out.println(keyArray[currentNode]);
		if (leftChildArray[currentNode] != -1){
			printRecursivePostOrderTreeWalk(leftChildArray[currentNode]);
		}
		if (rightChildArray[currentNode] != -1){
			printRecursivePostOrderTreeWalk(rightChildArray[currentNode]);
		}
	}
	
	//T(n) = O(h) + O(h) = O(h)
	protected int successor(int index){
		//check if this index belong to tree or not
		if (isExist(index)){
			//if node has no right child --> the first ancestor who previous ancestor a left child will be its successor
			if (rightChildArray[index] == -1){
				do {
					int temp = index;
					index = parentArray[index];
					if (leftChildArray[index] == temp){
						//return successor
						return index;
					}
				} while(parentArray[index] != -1);
				
				//if it reach root and root's left child is not its (our node) ancestor, return no successor
				return -1;
			} else {
				//if current node has right child --> its leftmost child is successor
				index = rightChildArray[index];
				if (leftChildArray[index] != -1){
					do {
						index = leftChildArray[index];
					} while (leftChildArray[index] != -1);
					//return successor
					return index;
				} else {
					//return successor
					return index;
				}
			}
		} else {
			System.out.println(exceptionAlerts.elementNotFoundExceptionAlert);
			return -1;
		}
	}
	
	protected int[] precedessor(int index){
		if (isExist(index)){
			
		} else {
			System.out.println(exceptionAlerts.elementNotFoundExceptionAlert);
			return -1;
		}
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
		//check if key is in range	
		if (key >= 0 && key < treeMaxNumberOfNode){
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
		} else {
			return false;
		}
	}
}
