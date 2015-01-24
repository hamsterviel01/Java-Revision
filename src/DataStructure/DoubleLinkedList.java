package DataStructure;

public class DoubleLinkedList {
	private int linkedListSize;
	private int[] linkedListValue;
	private int[] linkedListPointerNext;
	private int[] linkedListPointerPrev;
	Stack emptySpaceManager;
	private ExceptionAlerts exceptionAlerts = new ExceptionAlerts();
	
	protected DoubleLinkedList(){
		linkedListSize = 10;
		
		linkedListValue = new int[linkedListSize + 1];
		linkedListPointerNext = new int[linkedListSize + 1];
		linkedListPointerPrev = new int[linkedListSize + 1];
		emptySpaceManager = new Stack(linkedListSize);
		
		//initialize values for emptySpaceManager, push all element key but sentinel key to this stack
		for (int i = linkedListSize; i >= 1; i--){
			emptySpaceManager.push(i);
		}
		
		//initialize sentinel
		linkedListPointerNext[0] = 0;
		linkedListPointerPrev[0] = 0;
	}
	
	protected DoubleLinkedList(int linkedListSize){
		this.linkedListSize = linkedListSize;
		
		linkedListValue = new int[this.linkedListSize + 1];
		linkedListPointerNext = new int[this.linkedListSize + 1];
		linkedListPointerPrev = new int[this.linkedListSize + 1];
		emptySpaceManager = new Stack(this.linkedListSize);
		
		//initialize values for emptySpaceManager, push all element key but sentinel key to this stack
		for (int i = linkedListSize; i >= 1; i--){
			emptySpaceManager.push(i);
		}
		
		//initialize sentinel
		linkedListPointerNext[0] = 0;
		linkedListPointerPrev[0] = 0;
	}
	
	protected void insertLinkedList(int value, int pointer){
		//check if pointer point to one element in linked list
		if(isExist(pointer)){
			//check if linked list is full
			if(!isFull()){
				int tempNext = linkedListPointerNext[pointer];
				int tempPrev = linkedListPointerPrev[linkedListPointerNext[pointer]];
				
				//point pointerNext of mentioned element to next available space, and prev pointer of next element to newly added element
				linkedListPointerNext[pointer] = emptySpaceManager.top();
				linkedListPointerPrev[tempNext] = emptySpaceManager.top(); 
				linkedListValue[emptySpaceManager.top()] = value;
				linkedListPointerNext[emptySpaceManager.top()] = tempNext;
				linkedListPointerPrev[emptySpaceManager.top()] = tempPrev;
				
				//update emptySpaceManager
				emptySpaceManager.pop();
				printLinkedList();
			} else {
				System.out.println(exceptionAlerts.overFlowExceptionAlert);
				printLinkedList();
			}
		} else {
			System.out.println(exceptionAlerts.elementNotFoundExceptionAlert);
			printLinkedList();
		}
	}
	
	protected void deleteLinkedList(int pointer){
		//check if pointer is existed and not sentinel, sentinel cannot be deleted
		if (isExist(pointer) && pointer != 0){
			//check if linked list is empty
			if (!isEmpty()){
				//point prev element to next element and next element to prev element
				linkedListPointerNext[linkedListPointerPrev[pointer]] = linkedListPointerNext[pointer];
				linkedListPointerPrev[linkedListPointerNext[pointer]] = linkedListPointerPrev[pointer];
				
				//update emptySpaceManager
				emptySpaceManager.push(pointer);
				printLinkedList();
			} else {
				System.out.println(exceptionAlerts.underFlowExceptionAlert);
				printLinkedList();
			}
		} else {
			System.out.println(exceptionAlerts.elementNotFoundExceptionAlert);
			printLinkedList();
		}
	}
	
	protected boolean isEmpty(){
		if (emptySpaceManager.isFull()){
			return true;
		}
		return false;
	}
	
	protected boolean isFull(){
		if (emptySpaceManager.isEmpty()){
			return true;
		}
		return false;
	}
	
	protected boolean isExist(int pointer){
		//Need to accept pointer 0 as it is necessary for inserting first element, right after sentinel
		if (pointer >= 0 && pointer <= linkedListSize){
			//find this pointer in emptySpaceManager, if it is there then it is not in linked list
			int[] emptySpaceArray = emptySpaceManager.returnStackAsArray();
			int stackLength = emptySpaceManager.getHead();
			for (int i = 0; i < stackLength; i++){
				if (emptySpaceArray[i] == pointer){
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	protected void printLinkedList(){
		//check if linked list is empty
		if (!isEmpty()){
			int i = 0;
			System.out.print("|Sentinel|<-->");
			do {
				//don't print out sentinel
				if (i != 0){
					System.out.print("(" + i + ": " + linkedListPointerNext[i] + ": " + linkedListPointerPrev[i] + ": " + linkedListValue[i] + ")<-->");
				}
				i = linkedListPointerNext[i];
			} while (i != 0);
			System.out.print("|Sentinel|\n");
		} else {
			System.out.println("Linked-list is empty");
		}
	}
}
