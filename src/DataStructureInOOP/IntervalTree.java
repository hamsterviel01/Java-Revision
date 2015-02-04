/**
 * 
 */
package DataStructureInOOP;

/**
 * @author tuananhn
 *
 */
public class IntervalTree extends RedBlackTree{

	public IntervalTree(int rootIndex, int treeMaxNumberOfNode, int[] keyArray, int[] parentArray, int[] leftChildArray, int[] rightChildArray, int[] satelliteData, String[] color){
		super(rootIndex, treeMaxNumberOfNode, keyArray, parentArray, leftChildArray, rightChildArray, satelliteData, color);
	}
}
