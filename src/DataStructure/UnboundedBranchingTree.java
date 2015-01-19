/**
 * 
 */
package DataStructure;

/**
 * @author DrHamsterviel
 *
 */
public class UnboundedBranchingTree {
	private int maxNumberOfNodes;
	private int rootIndex;
	private int numberOfNodes = 0;
	private int[] parentIndex;
	private int[] leftmostChildIndex;
	private int[] rightSiblingIndex;
	private int[] value;
	
	protected UnboundedBranchingTree(int rootIndex){
		maxNumberOfNodes = 5;
		parentIndex = new int[maxNumberOfNodes];
		leftmostChildIndex = new int[maxNumberOfNodes];
		rightSiblingIndex = new int[maxNumberOfNodes];
		value = new int[maxNumberOfNodes];
		this.rootIndex = rootIndex;
	}
	
	protected UnboundedBranchingTree(int maxNumberOfNodes, int rootIndex){
		this.maxNumberOfNodes = maxNumberOfNodes;
		
		parentIndex = new int[this.maxNumberOfNodes];
		leftmostChildIndex = new int[this.maxNumberOfNodes];
		rightSiblingIndex = new int[this.maxNumberOfNodes];
		value = new int[this.maxNumberOfNodes];
		this.rootIndex = rootIndex;
	}
	
	//For quickly input tree nodes
	//How to check if array is equal in length?
	protected UnboundedBranchingTree(int[] parentIndex, int[] leftmostChildIndex, int[] rightSiblingIndex, int[] value, int rootIndex){
		this.parentIndex = parentIndex;
		this.leftmostChildIndex = leftmostChildIndex;
		this.rightSiblingIndex = rightSiblingIndex;
		this.value = value;
		this.rootIndex = rootIndex;
	}
	
	protected boolean isEmpty(){
		//if root has no leftmost child, tree is empty
		if (leftmostChildIndex[rootIndex] != -1){
			return false;
		}
		return true;
	}
	
	protected boolean isFull(){
		//if numberOfNodes = maxNumberOfNodes --> tree is full
		if (numberOfNodes == maxNumberOfNodes){
			return true;
		}
		return false;
	}
	
	protected void search(int index){
		searchRecursive(index, rootIndex);
	}
	
	//May need to improve on this method, since search and isExist function will be used a lot
	//Running time = O(n) (worst case)
	//May use hashtable??
	private int[] searchRecursive(int pointer, int currentNodeIndex){
		//We need to assume array can contain garbage data that not belong to the tree, need algorithm to check if it is really belong to current tree
		int[] resultNode = new int[4];
		
		//quick check: if current parent node is null and it is not root then it is not exist in tree
		if (pointer != rootIndex && parentIndex[pointer] == -1){
			return resultNode;
		}
		
		if (currentNodeIndex == pointer){
			resultNode[0] = value[currentNodeIndex];
			resultNode[1] = leftmostChildIndex[currentNodeIndex];
			resultNode[2] = rightSiblingIndex[currentNodeIndex];
			resultNode[3] = parentIndex[currentNodeIndex];
			return resultNode;
		} else if (leftmostChildIndex[currentNodeIndex] == -1 && rightSiblingIndex[currentNodeIndex] != -1){
			return resultNode;
		} else {
			// run search on each child
			int[] allChild = getAllChild(currentNodeIndex);
			for (int i = 0; i < allChild.length; i++){
				searchRecursive(pointer, allChild[i]);
			}
		}
		return resultNode;
	}
	
	//This is assumed that this node is existed
	protected int[] getAllChild(int pointer){
		
		//how to get size of allChild without run through the entire node? 
		//--> save some temporary space, especially when tree is very large
		int[] allChild = new int[maxNumberOfNodes];
		
		//check if node has any child
		if (leftmostChildIndex[pointer] != -1){
			System.out.println("This node has no child");
		} else {
			int i = leftmostChildIndex[pointer];
			int index = 0;
			
			//using rightSiblingIndex array to get index of all child until rightSiblingIndex == -1
			do {
				allChild[index] = i;
				index++;
				i = rightSiblingIndex[i];
			} while (rightSiblingIndex[i] != -1);
		}
		return allChild;
	}
	
	protected void insertNode(int value, int pointer){
		
	}
	
	protected void deleteNode(int pointer){
		
	}
}
