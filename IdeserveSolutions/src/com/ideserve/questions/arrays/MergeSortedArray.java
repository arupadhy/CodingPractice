package com.ideserve.questions.arrays;
/**
 * http://www.ideserve.co.in/learn/merge-two-sorted-arrays-without-extra-space
 * @author arvind
 *
 */

public class MergeSortedArray {
	
	public static void main(String[] args) {
		MergeSortedArray sortedArray = new MergeSortedArray();
		int[] bigger = new int[]{-3, 5, Integer.MIN_VALUE, 7, Integer.MIN_VALUE, 10, Integer.MIN_VALUE, 11, Integer.MIN_VALUE};
		int[] smaller = new int[]{-1, 2, 6, 12};
		//sortedArray.mergeArrays(bigger, smaller, 111);
		int x = sortedArray.partitionInvalidNumbersToFront(bigger, Integer.MIN_VALUE);
		sortedArray.mergeArrays(bigger, smaller, Integer.MIN_VALUE,x+1);
		for(int b: bigger) {
			System.out.print(b+" ");
		}
		
	}
	
	private int partitionInvalidNumbersToFront(int[] arr,int invalid) {
		int head = arr.length-1,tail = arr.length-1;
		while(head>=0){
			if(arr[head]!=invalid) {
				arr[tail] = arr[head];
				tail--;
			}
			head--;
		}
		for(int i=0;i<=tail;i++) {
			arr[i] = invalid;
		}
		return tail;
	}
	
	void mergeArrays(int[]bigger, int[]smaller,int invalidNum,int invalidPoint) {

      	int biggerPointer = invalidPoint;
      	int small = 0,big = 0;
      	while(biggerPointer<bigger.length && small<smaller.length) {
      		if(smaller[small]<bigger[biggerPointer]) {
      			bigger[big] = smaller[small];
      			small++;
      		}else {
      			bigger[big] = bigger[biggerPointer];
      			biggerPointer++;
      		}
      		big++;
      	}
      	if(small<smaller.length) {
      		bigger[big] = smaller[small];
      		small++;big++;
      	}
      }

}
