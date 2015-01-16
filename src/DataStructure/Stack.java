package DataStructure;

public class Stack {
	private int stackSize = 1000;
	private int[] stack;
	private int head = -1;
	private ExceptionAlerts exceptionAlerts = new ExceptionAlerts();
	
	protected Stack(){
		stack = new int[stackSize];
	}
	
	protected Stack(int stackSize){
		this.stackSize = stackSize;
		stack = new int[this.stackSize];
	}
	
	protected void printStack(){
		if (head == -1){
			System.out.println("Stack is empty");
		} else {
			for (int i=0; i <= head; i++){
				System.out.print(stack[i] + "-");
			}
			System.out.print("head\n");
		}
	}
	protected void push(int pushValue){
		if (!isFull()){
			head++;
			stack[head] = pushValue;
		} else {
			System.out.println(exceptionAlerts.overFlowExceptionAlert);
		}
	}
	
	protected void pop(){
		if (!isEmpty()){
			head--;
		} else {
			System.out.println(exceptionAlerts.underFlowExceptionAlert);
		}
		
	}
	
	protected int top(){
		return stack[head];
	}
	
	protected boolean isEmpty(){
		if (head != -1){
			return false;
		}
		return true;
	}
	
	protected boolean isFull(){
		if (head >= (stackSize - 1)){
			return true;
		} else {
			return false;
		}
	}
	
	protected int getHead(){
		return head;
	}
	
	protected int[] returnStackAsArray(){
		return stack;
	}
}
