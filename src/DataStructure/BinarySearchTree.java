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
	public BinarySearchTree(int rootIndex, int treeMaxNumberOfNode, int[] keyArray, int[] parentArray, int[] leftChildArray, int[] rightChildArray, int[] satelliteData){
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
		this.satelliteData = satelliteData;
		emptySpaceManager = new Stack(treeMaxNumberOfNode);
		
		//initialize emptySpaceManager
		//it should be empty since no space is available --> seek for space with -1 as index of parent and children
	}
	
	protected void printInOrderTreeWalk(){
		printRecursiveInOrderTreeWalk(rootIndex);
		System.out.print("\n");
	}
	
	protected void printRecursiveInOrderTreeWalk(int startNode){
		//print tree from start node x: x.left -> print x --> print x.right
		if (leftChildArray[startNode] != -1){
			printRecursiveInOrderTreeWalk(leftChildArray[startNode]);
		}
		System.out.print(keyArray[startNode] + "-");
		if (rightChildArray[startNode] != -1){
			printRecursiveInOrderTreeWalk(rightChildArray[startNode]);
		}
	}
	
	protected void printPreOrderTreeWalk(){
		printRecursivePreOrderTreeWalk(rootIndex);
		System.out.print("\n");
	}
	
	protected void printRecursivePreOrderTreeWalk(int currentNode){
		System.out.print(keyArray[currentNode] + "-");
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
					if (leftChildArray[parentArray[index]] == index){
						//return successor
						return index;
					}
					index = parentArray[index];
				} while (index != rootIndex);
				
				//if it reach root and root's left child is not its (our node) ancestor, return no successor
				return -1;
			} else {
				//if current node has right child --> its leftmost child is successor
				index = rightChildArray[index];
				while (leftChildArray[index] != -1){
					index = leftChildArray[index];
				}
				return index;
			}
		} else {
			System.out.println(exceptionAlerts.elementNotFoundExceptionAlert);
			return -1;
		}
	}
	
	protected int predecessor(int index){
		//Check if index belong to tree or not
		if (isExist(index)){
			//If node has no left child, first ancestor with right child is also an ancestor of index will be its predecessor
			if (leftChildArray[index] == -1){
				do {
					if (rightChildArray[parentArray[index]] == index){
						return parentArray[index];
					}
					index = parentArray[index];
				} while (index != rootIndex);
				return -1;
			} else {
				//if node has left child --> rightmost child of left sub-tree is it predecessor
				index = leftChildArray[index];
				while (rightChildArray[index] != -1){
					index = rightChildArray[index];
				}
				return index;
			}
		} else {
			System.out.println(exceptionAlerts.elementNotFoundExceptionAlert);
			return -1;
		}
	}
	
	protected int minNode(){
		int currentNodeIndex = rootIndex;
		
		//if tree is not empty
		if (!isEmpty()){
			while (leftChildArray[currentNodeIndex] != -1){
				currentNodeIndex = leftChildArray[currentNodeIndex];
			}
			return currentNodeIndex;
		} else {
			System.out.println("Tree is empty!");
			return currentNodeIndex;
		}
	}
	
	protected int maxNode(){
		int currentNodeIndex = rootIndex;
		
		//if tree is not empty
		if (!isEmpty()){
			while (rightChildArray[currentNodeIndex] != -1){
				currentNodeIndex = rightChildArray[currentNodeIndex];
			}
			return currentNodeIndex;
		} else {
			System.out.println("Tree is empty!");
			return currentNodeIndex;
		}
	}
	
	protected void insert(int insertValue){
		//looking for place to insert value
		if (!isFull()){
			int currentNode = rootIndex;
			int successorCurrentNode = successor(currentNode);
			int predecessorCurrentNode = predecessor(currentNode); 
			int insertIndex = emptySpaceManager.top();
			
			do {
				if (insertValue > keyArray[currentNode]){
					currentNode = rightChildArray[currentNode];	
				} else if (insertValue < keyArray[currentNode]){
					currentNode = leftChildArray[currentNode];
				} else {
					//to avoid ArrayOutOfBoundException -1: rootIndex = currentNode
					currentNode = rightChildArray[currentNode];

				}
			} 
			/*Satisfy:
			 * - insert value belong to [parent, node] or [node, parent]
			 * - node has no more child*/
			while ((!(insertValue >= keyArray[currentNode] && insertValue < keyArray[parentArray[currentNode]])
					|| !(insertValue <= keyArray[currentNode] && insertValue >= keyArray[parentArray[currentNode]])) && hasChild(currentNode));
						
			System.out.println(currentNode);
			if (insertValue >= keyArray[currentNode]){
				//insert to currentNode as its right child

				rightChildArray[currentNode] = insertIndex;
				
				keyArray[insertIndex] = insertValue;
				parentArray[insertIndex] = currentNode;
				rightChildArray[insertIndex] = -1;
				leftChildArray[insertIndex] = -1;
			} else {
				//insert to currentNode as its left child;
				System.out.println(currentNode);
				leftChildArray[currentNode] = insertIndex;
				
				keyArray[insertIndex] = insertValue;
				parentArray[insertIndex] = currentNode;
				rightChildArray[insertIndex] = -1;
				leftChildArray[insertIndex] = -1;
			}
			emptySpaceManager.pop();
		} else {
			System.out.println(exceptionAlerts.overFlowExceptionAlert);
		}
	}
	
	protected void delete(int index){
		//Imagine that it is a sorted order list --> to delete is to modified relationship between its predecessor and successor 
		//--> choose among predecessor and successor which one has no child --> save the hassle
		//if both has no child or both has child --> choose the successor
		if (isExist(index)){
			//case 1: if it has no child --> just set its parent and its value to -1 accordingly
			if (!hasChild(index)){
				if (rightChildArray[parentArray[index]] == index){
					rightChildArray[parentArray[index]] = -1;
				} else if (leftChildArray[parentArray[index]] == index) {
					leftChildArray[parentArray[index]] = -1;
				} else {
					System.out.println(exceptionAlerts.unexpectedErrorInDataStructure);
				}
				
				//put all key and parent index to -1
				setValueOfDeletedNode(index);
			} else {
				//case 2: if it has child --> started to care about predecessor and successor
				//        let the child fill up its position.
				//first: if it has 1 child --> easy
				if (hasChild(index) && (leftChildArray[index] == -1 || rightChildArray[index] == -1)) {
					//adjust index's parent
					if (rightChildArray[parentArray[index]] == index){
						rightChildArray[parentArray[index]] = leftChildArray[index];
					} else if (leftChildArray[parentArray[index]] == index) {
						leftChildArray[parentArray[index]] = leftChildArray[index];
					} else {
						System.out.println(exceptionAlerts.unexpectedErrorInDataStructure);
					}
					
					//adjust index's left child or right child
					if (leftChildArray[index] != -1){
						parentArray[leftChildArray[index]] = parentArray[index];
					} else {
						parentArray[rightChildArray[index]] = parentArray[index];
					}
					
					//delete index
					setValueOfDeletedNode(index);
  				  } else {
					/* if node has both children
					 * this mean node will have both successor and predecessor as its grand... child 
					 * take the successor --> successor will not has right child.
					 */
					int successorIndex = successor(index);
					if (hasChild(successorIndex)) {
						//adjust child of successor if successor has right child
						parentArray[rightChildArray[successorIndex]] = parentArray[successorIndex];
						leftChildArray[parentArray[successorIndex]] = rightChildArray[successorIndex];
						
						//adjust parent of successor:
						rightChildArray[parentArray[successorIndex]] = -1;
						
						//adjust successor
						parentArray[successorIndex] = parentArray[index];
						rightChildArray[successorIndex] = rightChildArray[index];
						leftChildArray[successorIndex] = leftChildArray[index];
						
						
						//adjust child of index
						parentArray[rightChildArray[index]] = successorIndex;
						parentArray[leftChildArray[index]] = successorIndex;
						
						//adjust parent of index
						rightChildArray[parentArray[index]] = successorIndex;
						
						//delete index
						setValueOfDeletedNode(index);
					} else {
						System.out.println(parentArray[successor(index)]);
						//adjust parent of successor:
						leftChildArray[parentArray[successorIndex]] = -1;
						
						// now successor(index) = 9
						System.out.println(parentArray[successorIndex] + " " + rightChildArray[successorIndex] + " " + leftChildArray[successorIndex]);

						//adjust successor
						parentArray[successorIndex] = parentArray[index];
						rightChildArray[successorIndex] = rightChildArray[index];
						leftChildArray[successorIndex] = leftChildArray[index];
						
						System.out.println(parentArray[successorIndex] + " " + rightChildArray[successorIndex] + " " + leftChildArray[successorIndex]);

						
						//adjust child of index
						parentArray[rightChildArray[index]] = successorIndex;
						parentArray[leftChildArray[index]] = successorIndex;
						
						//adjust parent of index
						rightChildArray[parentArray[index]] = successorIndex;
						
						//delete index
						setValueOfDeletedNode(index);
					}
				}
			}
		}
	}
	
	private void setValueOfDeletedNode(int index){
		parentArray[index] = -1;
		leftChildArray[index] = -1;
		rightChildArray[index] = -1;
		
		//adjust emptySpaceManager
		emptySpaceManager.push(index);
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
		return emptySpaceManager.isEmpty();
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
	
	protected boolean hasChild(int index){
		if (rightChildArray[index] != -1 || leftChildArray[index] != -1){
			return true;
		}
		return false;
	}
}
