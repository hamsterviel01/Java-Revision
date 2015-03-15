package com.hamsterviel01.www.datastructure;

public class Queue {
	private int queueSize = 1000;
	private int[] queue;
	private int head = 0;
	private int tail = -1;
	private ExceptionAlerts exceptionAlerts = new ExceptionAlerts();
	
	protected Queue(){
		
	}
	
	
	protected Queue(int queueSize){
		this.queueSize = queueSize;
		queue = new int[this.queueSize];
	}
	
	protected void enqueue(int enqueueValue){
		if (!isFull()){
			tail++;
			queue[tail%queueSize] = enqueueValue;
		} else {
			System.out.println(exceptionAlerts.overFlowExceptionAlert);
		}
		
	}
	
	protected void dequeue(){
		if (!isEmpty()){
			head++;
		} else {
			System.out.println(exceptionAlerts.underFlowExceptionAlert);
		}
	}
	
	protected boolean isEmpty(){
		if (head > tail){
			return true;
		}
		return false;
	}
	
	protected boolean isFull(){
		if (tail - head >= queueSize - 1){
			return true;
		}
		return false;
	}
	
	protected void printQueue(){
		if (!isEmpty()){
			System.out.print("tail->");
			for (int i = tail; i >= head; i--){
				System.out.print(queue[i%queueSize] + "->");
			}
			System.out.println("head");
		} else {
			System.out.println("Queue is empty");
		}
	}
}
