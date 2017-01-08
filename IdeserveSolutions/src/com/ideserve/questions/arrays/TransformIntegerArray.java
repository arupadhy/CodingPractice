package com.ideserve.questions.arrays;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TransformIntegerArray {
	
	public static void main(String[] args) {
		int[] input = new int[] {-1,3,2,4,5,-6,7,-9};
		new TransformIntegerArray().transformArray(input);
		Stack<Integer> s = new Stack<>();
		
	}
	
	private int getNext(Queue<Integer> pQueue,Queue<Integer> nQueue,boolean isPositive) {
		if(isPositive) {
			if(!pQueue.isEmpty()) {
				return pQueue.remove();
			}else{
				return nQueue.remove();
			}
		}else {
			if(!nQueue.isEmpty()) {
				return nQueue.remove();
			}else {
				return pQueue.remove();
			}
		}
	}
	
	public void transformArray(int[] input) {
		
		if(input == null || input.length == 0) {
			return;
		}
		
		Queue<Integer> pQueue = new LinkedList<>();
		Queue<Integer> nQueue = new LinkedList<>();
		
		for(int i=0;i<input.length;i++) {
			if(input[i]>=0) {
				pQueue.add(input[i]);
			}else {
				nQueue.add(input[i]);
			}
		}
		
		for(int i=0;i<input.length;i++) {
				input[i] = i%2==0? getNext(pQueue, nQueue, true):getNext(pQueue, nQueue, false);
		}
		
		System.out.println(String.format("Transformed array is ", null));
		for(int i=0;i<input.length;i++) {
			System.out.print(input[i] +" ");
		}
		
	}

}
