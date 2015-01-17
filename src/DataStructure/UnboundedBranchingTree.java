/**
 * 
 */
package DataStructure;

/**
 * @author DrHamsterviel
 *
 */
public class UnboundedBranchingTree {
	private int numberOfNodes;
	private int[] parentArray;
	private int[] leftmostChildArray;
	private int[] rightSiblingArray;
	private int[] valueArray;
	
	protected UnboundedBranchingTree(){
		numberOfNodes = 5;
		parentArray = new int[numberOfNodes];
		leftmostChildArray = new int[numberOfNodes];
		rightSiblingArray = new int[numberOfNodes];
		valueArray = new int[numberOfNodes];
	}
	
	protected UnboundedBranchingTree(int numberOfNodes){
		this.numberOfNodes = numberOfNodes;
		
		parentArray = new int[this.numberOfNodes];
		leftmostChildArray = new int[this.numberOfNodes];
		rightSiblingArray = new int[this.numberOfNodes];
		valueArray = new int[this.numberOfNodes];
	}
	
	protected boolean isEmpty(){
		
	}
	
	protected boolean isFull(){
		
	}
	
	protected boolean isExist(int pointer){
		
	}
	
	protected int[] getAllChild(int pointer){
		
	}
	
	protected void insertNode(int value, int pointer){
		
	}
	
	protected void deleteNode(int pointer){
		
	}
}
