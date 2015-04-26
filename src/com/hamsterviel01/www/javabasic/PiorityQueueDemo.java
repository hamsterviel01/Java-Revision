package com.hamsterviel01.www.javabasic;

import java.util.*;

public class PiorityQueueDemo {
	public static void main(String[] args){
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
		Random rand = new Random(47);
		for (int i=0; i<=10; i++){
			priorityQueue.add(rand.nextInt(i+10));
		}
		QueueDemo.printQ(priorityQueue);
		
		List<Integer> ints = Arrays.asList(23, 1, 4, 5, 6, 23, 56, 43, 15, 69, 03, 12);
		priorityQueue = new PriorityQueue<Integer>(ints);
		QueueDemo.printQ(priorityQueue);
		priorityQueue = new PriorityQueue<Integer>(ints.size(), Collections.reverseOrder());
		priorityQueue.addAll(ints);
		QueueDemo.printQ(priorityQueue);
	}
}
