/**
 * 
 */
package DataStructureInOOP;

import DataStructure.Stack;

/**
 * @author tuananhn
 *
 */
public class BinarySearchTree {
	private int treeMaxNumberOfNode;
	private int rootIndex;
	private BinaryTreeNode[] binaryTree;
	private Stack emptySpaceManager;
	private ExceptionAlerts exceptionAlerts = new ExceptionAlerts();
	
	//For now, we assume what they insert is indeed a binary search tree
	public BinarySearchTree(int rootIndex, int treeMaxNumberOfNode, int[] keyArray, int[] parentArray, int[] leftChildArray, int[] rightChildArray, int[] satelliteData){
		this.treeMaxNumberOfNode = treeMaxNumberOfNode;
		this.binaryTree = new BinaryTreeNode[this.treeMaxNumberOfNode];
		this.rootIndex = rootIndex;
		// May need to check if what people insert is a binary search tree --> here is better than outside constructor
		
		for (int i = 0; i < binaryTree.length; i++){
			this.binaryTree[i] = new BinaryTreeNode();
			this.binaryTree[i].setIndex(i);
			this.binaryTree[i].setParentIndex(parentArray[i]);
			this.binaryTree[i].setLeftChildIndex(leftChildArray[i]);
			this.binaryTree[i].setRightChildIndex(rightChildArray[i]);
			this.binaryTree[i].setSatelliteData(satelliteData[i]);
		}

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
		if (binaryTree[startNode].getLeftChildIndex() != -1){
			printRecursiveInOrderTreeWalk(binaryTree[startNode].getLeftChildIndex());
		}
		
		System.out.print(binaryTree[startNode].getValue() + "-");
		
		if (binaryTree[startNode].getRightChildIndex() != -1){
			printRecursiveInOrderTreeWalk(binaryTree[startNode].getRightChildIndex());
		}
	}
	
	protected void printPreOrderTreeWalk(){
		printRecursivePreOrderTreeWalk(rootIndex);
		System.out.print("\n");
	}
	
	protected void printRecursivePreOrderTreeWalk(int currentNode){
		System.out.print(binaryTree[currentNode].getValue() + "-");
		if (binaryTree[currentNode].getLeftChildIndex() != -1){
			printRecursivePreOrderTreeWalk(binaryTree[currentNode].getLeftChildIndex());
		}
		if (binaryTree[currentNode].getRightChildIndex() != -1){
			printRecursivePreOrderTreeWalk(binaryTree[currentNode].getRightChildIndex());
		}
	}
	protected void printPostOrderTreeWalk(){
		printRecursivePostOrderTreeWalk(rootIndex);
	}
	
	protected void printRecursivePostOrderTreeWalk(int currentNode){
		System.out.println(binaryTree[currentNode].getValue());
		if (binaryTree[currentNode].getLeftChildIndex() != -1){
			printRecursivePostOrderTreeWalk(binaryTree[currentNode].getLeftChildIndex());
		}
		if (binaryTree[currentNode].getRightChildIndex() != -1){
			printRecursivePostOrderTreeWalk(binaryTree[currentNode].getRightChildIndex());
		}
	}
	
	//T(n) = O(h) + O(h) = O(h)
	protected int successor(int index){
		//check if this index belong to tree or not
		if (isExist(index)){
			//if node has no right child --> the first ancestor who previous ancestor a left child will be its successor
			if (binaryTree[index].getRightChildIndex() == -1){
				do {
					if (binaryTree[binaryTree[index].getParentIndex()].getLeftChildIndex() == index){
						//return successor
						return index;
					}
					index = binaryTree[index].getParentIndex();
				} while (index != rootIndex);
				
				//if it reach root and root's left child is not its (our node) ancestor, return no successor
				return -1;
			} else {
				//if current node has right child --> its leftmost child is successor
				index = binaryTree[index].getRightChildIndex();
				while (binaryTree[index].getLeftChildIndex() != -1){
					index = binaryTree[index].getLeftChildIndex();
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
			if (binaryTree[index].getLeftChildIndex() == -1){
				do {
					if (binaryTree[binaryTree[index].getParentIndex()].getRightChildIndex() == index){
						return binaryTree[index].getParentIndex();
					}
					index = binaryTree[index].getParentIndex();
				} while (index != rootIndex);
				return -1;
			} else {
				//if node has left child --> rightmost child of left sub-tree is it predecessor
				index = binaryTree[index].getLeftChildIndex();
				while (binaryTree[index].getRightChildIndex() != -1){
					index = binaryTree[index].getRightChildIndex();
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
			while (binaryTree[currentNodeIndex].getLeftChildIndex() != -1){
				currentNodeIndex = binaryTree[currentNodeIndex].getLeftChildIndex();
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
			while (binaryTree[currentNodeIndex].getRightChildIndex() != -1){
				currentNodeIndex = binaryTree[currentNodeIndex].getRightChildIndex();
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
				if (insertValue > binaryTree[currentNode].getValue()){
					currentNode = binaryTree[currentNode].getRightChildIndex();	
				} else if (insertValue < binaryTree[currentNode].getValue()){
					currentNode = binaryTree[currentNode].getLeftChildIndex();
				} else {
					//to avoid ArrayOutOfBoundException -1: rootIndex = currentNode
					currentNode = binaryTree[currentNode].getRightChildIndex();

				}
			} 
			/*Satisfy:
			 * - insert value belong to [parent, node] or [node, parent]
			 * - node has no more child*/
			while ((!(insertValue >= binaryTree[currentNode].getValue() && insertValue < binaryTree[binaryTree[currentNode].getParentIndex()].getValue())
					|| !(insertValue <= binaryTree[currentNode].getValue() && insertValue >= binaryTree[binaryTree[currentNode].getParentIndex()].getValue())) && hasChild(currentNode));
						
			System.out.println(currentNode);
			if (insertValue >= binaryTree[currentNode].getValue()){
				//insert to currentNode as its right child
				binaryTree[currentNode].setRightChildIndex(insertIndex);
				
				binaryTree[insertIndex].setValue(insertValue);
				binaryTree[insertIndex].setParentIndex(currentNode);
				binaryTree[insertIndex].setRightChildIndex(-1);
				binaryTree[insertIndex].setLeftChildIndex(-1);
			} else {
				//insert to currentNode as its left child;
				System.out.println(currentNode);
				binaryTree[currentNode].setLeftChildIndex(insertIndex);
				
				binaryTree[insertIndex].setValue(insertValue);
				binaryTree[insertIndex].setParentIndex(currentNode);
				binaryTree[insertIndex].setRightChildIndex(-1);
				binaryTree[insertIndex].setLeftChildIndex(-1);
			}
			emptySpaceManager.pop();
		} else {
			System.out.println(exceptionAlerts.overFlowExceptionAlert);
		}
	}
	
	//May need to find a way to not call getter and setter too many time.
	protected void delete(int index){
		//Imagine that it is a sorted order list --> to delete is to modified relationship between its predecessor and successor 
		//--> choose among predecessor and successor which one has no child --> save the hassle
		//if both has no child or both has child --> choose the successor
		if (isExist(index)){
			//case 1: if it has no child --> just set its parent and its value to -1 accordingly
			if (!hasChild(index)){
				if (binaryTree[binaryTree[index].getParentIndex()].getRightChildIndex() == index){
					binaryTree[binaryTree[index].getParentIndex()].setRightChildIndex(-1); 
				} else if (binaryTree[binaryTree[index].getParentIndex()].getLeftChildIndex() == index) {
					binaryTree[binaryTree[index].getParentIndex()].setLeftChildIndex(-1);
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
					} else if (binaryTree[binaryTree[index].getParentIndex()].getLeftChildIndex() == index) {
						binaryTree[binaryTree[index].getParentIndex()].setLeftChildIndex(binaryTree[index].getLeftChildIndex());
					} else {
						System.out.println(exceptionAlerts.unexpectedErrorInDataStructure);
					}
					
					//adjust index's left child or right child
					if (binaryTree[index].getLeftChildIndex() != -1){
						binaryTree[binaryTree[index].getLeftChildIndex()].setParentIndex(binaryTree[index].getParentIndex());
					} else {
						binaryTree[binaryTree[index].getRightChildIndex()].setParentIndex(binaryTree[index].getParentIndex());
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
						binaryTree[binaryTree[successorIndex].getRightChildIndex()].setParentIndex(binaryTree[successorIndex].getParentIndex());
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
		binaryTree[index].setParentIndex(-1);
		binaryTree[index].setLeftChildIndex(-1);
		binaryTree[index].setRightChildIndex(-1);
		
		//adjust emptySpaceManager
		emptySpaceManager.push(index);
	}
	
	//O(1)
	protected boolean isEmpty(){
		//if root has no key --> no root
		if (binaryTree[rootIndex].getValue() == -1){
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
					if (binaryTree[binaryTree[key].getParentIndex()].getRightChildIndex() == key || binaryTree[binaryTree[key].getParentIndex()].getLeftChildIndex() == key){
						// check node's parent --> see if it valid
						key = binaryTree[key].getParentIndex(); 
					} else {
						return false;
					}
				}
				while (binaryTree[key].getParentIndex() != -1);
				
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
		if (binaryTree[index].getRightChildIndex() != -1 || binaryTree[index].getLeftChildIndex()  != -1){
			return true;
		}
		return false;
	}
}
