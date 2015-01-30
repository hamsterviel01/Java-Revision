package DataStructure;

public class Stack {
	private int stackSize = 1000;
	private int[] stack;
	private int head = -1;
	private ExceptionAlerts exceptionAlerts = new ExceptionAlerts();
	
	public Stack(){
		stack = new int[stackSize];
	}
	
	public Stack(int stackSize){
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
	public void push(int pushValue){
		if (!isFull()){
			head++;
			stack[head] = pushValue;
		} else {
			System.out.println(exceptionAlerts.overFlowExceptionAlert);
		}
	}
	
	public void pop(){
		if (!isEmpty()){
			head--;
		} else {
			System.out.println(exceptionAlerts.underFlowExceptionAlert);
		}
		
	}
	
	public int top(){
		return stack[head];
	}
	
	public boolean isEmpty(){
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
