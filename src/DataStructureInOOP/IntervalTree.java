/**
 * 
 */
package DataStructureInOOP;

/**
 * @author tuananhn
 *
 */
public class IntervalTree extends RedBlackTree{
	private BinaryTreeNode[] intervalTree;

	public IntervalTree(int rootIndex, int treeMaxNumberOfNode, int[] lowValueArray, int[] highValueArray, int[] parentArray, int[] leftChildArray, int[] rightChildArray, int[] satelliteData, String[] color){
		super(rootIndex, treeMaxNumberOfNode, lowValueArray, parentArray, leftChildArray, rightChildArray, satelliteData, color);
		
		intervalTree = super.getBinaryTree();
	}
	
	protected boolean isOverlapped(BinaryTreeNode interval1, BinaryTreeNode interval2){
		if ((interval1.getHigh() < interval2.getHigh() && interval1.getHigh() > interval2.getLow()) || 
				(interval1.getLow() < interval2.getHigh() && interval1.getLow() > interval2.getLow())) {
			return true;
		}
		return false;
	}
	
	protected int intervalSearch(int low, int high){
		
	}
}
