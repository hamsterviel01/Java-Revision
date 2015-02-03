/**
 * 
 */
package DataStructureInOOP;

/**
 * @author tuananhn
 *
 */

//Need to redesign Binary Search Tree to allow RedBlackTree inherit from its method
public class RedBlackTree extends BinarySearchTree{
	private BinaryTreeNode[] redBlackTree;
	private int treeSize;
	private ExceptionAlerts exceptionAlerts = new ExceptionAlerts();
	
	public RedBlackTree(int rootIndex, int treeMaxNumberOfNode, int[] keyArray, int[] parentArray, int[] leftChildArray, int[] rightChildArray, int[] satelliteData, String[] color){
		super(rootIndex, treeMaxNumberOfNode, keyArray, parentArray, leftChildArray, rightChildArray, satelliteData);
		redBlackTree = super.getBinaryTree();
		
		//set color of node for red black tree
		for (int i = 1; i < treeMaxNumberOfNode; i++){
			redBlackTree[i].setColor(color[i]);
		}
	}
	
	/*How to know when need swapping? 
	 * -- look into 5 rules of RB Properties
	 * 1. Root are black
	 * 2. all leave are black
	 * 3.  */
	
	//Swap node after insert to protect Red-black properties
	public void fixRedBlackTree(){
		
	}
	
	public void insert(int insertValue){
		super.insert(insertValue);
		fixRedBlackTree();
	}
	
	public void delete(int deleteIndex){
		super.delete(deleteIndex);
		fixRedBlackTree();
	}
}
