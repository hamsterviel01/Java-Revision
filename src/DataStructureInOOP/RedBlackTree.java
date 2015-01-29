/**
 * 
 */
package DataStructureInOOP;

/**
 * @author tuananhn
 *
 */

//Need to redesign Binary Search Tree to allow RedBlackTree inherit from its method
public class RedBlackTree {
	private BinaryTreeNode[] redBlackTree;
	private int treeSize;
	private ExceptionAlerts exceptionAlerts = new ExceptionAlerts();
	
	public RedBlackTree(int treeSize, BinaryTreeNode[] redBlackTree){
		if (treeSize != redBlackTree.length){
			System.out.println(exceptionAlerts.unexpectedErrorInDataStructure);
			return;
		}
		this.redBlackTree = redBlackTree;
	}
	
	//Can 
	public BinaryTreeNode search(int value){
		
	}
}
