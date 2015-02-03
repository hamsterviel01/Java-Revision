/**
 * 
 */
package DataStructureInOOP;

/**
 * @author tuananhn
 *
 */
public class BinaryTreeNode {
	private int value;
	private int leftChildIndex;
	private int rightChildIndex;
	private int parentIndex;
	private int satelliteData;
	
	//For Red Black Tree
	private String color;
	private int index;
	
	protected BinaryTreeNode() {
		return;
	}
	
	protected BinaryTreeNode(int value, int leftChildIndex, int rightChildIndex, int parentIndex){
		this.value = value;
		this.leftChildIndex = leftChildIndex;
		this.rightChildIndex = rightChildIndex;
		this.parentIndex = parentIndex;
		return;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getLeftChildIndex() {
		return leftChildIndex;
	}

	public void setLeftChildIndex(int leftChildIndex) {
		this.leftChildIndex = leftChildIndex;
	}

	public int getRightChildIndex() {
		return rightChildIndex;
	}

	public void setRightChildIndex(int rightChildIndex) {
		this.rightChildIndex = rightChildIndex;
	}

	public int getParentIndex() {
		return parentIndex;
	}

	public void setParentIndex(int parentIndex) {
		this.parentIndex = parentIndex;
	}
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	public int getSatelliteData() {
		return satelliteData;
	}

	public void setSatelliteData(int satelliteData) {
		this.satelliteData = satelliteData;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
