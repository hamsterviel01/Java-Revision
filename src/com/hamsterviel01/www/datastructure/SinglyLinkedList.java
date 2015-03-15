
package com.hamsterviel01.www.datastructure;

public class SinglyLinkedList {
	private int linkedListSize = 5;
	private int[] linkedListValue;
	private int[] linkedListPointerNext;
	//Improve this programe by not using stack to save memory
	private Stack emptySpaceManager;
	private ExceptionAlerts exceptionAlerts = new ExceptionAlerts();
	
	protected SinglyLinkedList(){
		//first element reserved for sentinel (+1)
		linkedListValue = new int[linkedListSize + 1];
		linkedListPointerNext = new int[linkedListSize + 1];
		emptySpaceManager = new Stack(linkedListSize);
		
		//initialize empty space
		for (int i = linkedListSize; i >= 1; i--){
			emptySpaceManager.push(i);
		}
		
		//initialize sentinel
		linkedListPointerNext[0] = 0;
	}
	
	protected SinglyLinkedList(int linkedListSize){
		this.linkedListSize = linkedListSize;
		
		//first element reserved for sentinel (+1)
		linkedListValue = new int[this.linkedListSize + 1];
		linkedListPointerNext = new int[this.linkedListSize + 1];
		emptySpaceManager = new Stack(this.linkedListSize);
				
		//initialize empty space
		for (int i = linkedListSize; i >= 1; i--){
			emptySpaceManager.push(i);
		}
				
		//initialize sentinel
		linkedListPointerNext[0] = 0;
	}
	
	protected void insertLinkedList(int value, int pointer){
		//First search for key existence
		if(isExist(pointer)){
			//Next, check if linked-list is full
			if (!isFull()){
				
				//point keyElement.pointerNext to new inserted element
				int pointerNextOfKeyElement = linkedListPointerNext[pointer];
				linkedListPointerNext[pointer] = emptySpaceManager.top();
				
				//insert Value to next available space of linkedList, point it to next Element;
				linkedListValue[emptySpaceManager.top()] = value;
				linkedListPointerNext[emptySpaceManager.top()] = pointerNextOfKeyElement;
				
				//update emptySpaceManager
				emptySpaceManager.pop();
				
				//for testing purpose only
				printLinkedList();
			} else {
				System.out.println(exceptionAlerts.overFlowExceptionAlert);
			}
		} else {
			System.out.println(exceptionAlerts.elementNotFoundExceptionAlert);
		}
	}
	
	protected void deleteLinkedList(int pointer){
		//Check for key existence, if list is empty, surely key will not exist
		if (isExist(pointer)){
			// Check if linked-list is empty
			if(!isEmpty()){
				//find previous element first
				int previousElement = returnPreviousElement(pointer);
				
				//pointer previous element to next element
				if (previousElement != -1){
					linkedListPointerNext[previousElement] = linkedListPointerNext[pointer];
				}
				
				//update emptySpaceManager
				emptySpaceManager.push(pointer);
				
				//for testing purpose only
				printLinkedList();
			} else {
				System.out.println(exceptionAlerts.underFlowExceptionAlert);
			}
		} else {
			System.out.println(exceptionAlerts.elementNotFoundExceptionAlert);
		}
	}
	
	protected void printLinkedList(){
		if (!isEmpty()){
			int i = 0;
			do {
				// Don't print out sentinel content
				if (i == 0){
					System.out.print("|Sentinel|-->");
				} else {
					System.out.print("(" + i + ": " + linkedListPointerNext[i] + ": " + linkedListValue[i] + ")-->");
				}
				i = linkedListPointerNext[i];
			} while(i != 0);
			System.out.print("|Sentinel|\n");
		} else {
			System.out.println("Linked-list is empty");
		}
	}
	
	protected boolean isExist(int pointer){	
		//This need to accept pointer 0, because pointer 0 is necessary for inserting first element
		if (pointer >= 0 && pointer <= linkedListSize){
			int[] emptySpaceManagerAsArray = emptySpaceManager.returnStackAsArray();
			for (int i = 0; i <= emptySpaceManager.getHead(); i++){
				if (emptySpaceManagerAsArray[i] == pointer){
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	//How to reduce run time of this one to O(1)
	protected int returnPreviousElement(int pointer){
		int i = 0;
		while (linkedListPointerNext[i] != 0){
			if (pointer == linkedListPointerNext[i]){
				return i;
			}
			i = linkedListPointerNext[i];
		}
		System.out.println(exceptionAlerts.elementNotFoundExceptionAlert);
		return -1;
	}
	
	protected boolean isFull(){
		//if no empty space available --> it is full
		if (emptySpaceManager.isEmpty()){
			return true;
		}
		return false;
	}
	
	protected boolean isEmpty(){
		//if last element is also sentinel --> this linked list is empty
		if (emptySpaceManager.isFull()){
			return true;
		}
		return false;
	}
}
