package com.ideserve.questions.arrays;
/**
 * http://www.ideserve.co.in/learn/rotate-an-array
 * @author arvind
 *
 */
public class RotateArray {
	private void reverseArray(int[]arr, int start, int end) {
		if(arr == null || arr.length == 0){
			return;
		}
		while(start<end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

	public void rotateInPlace(int[] arr, int k) {
		if(k <=0 || arr == null || arr.length ==0) {
			return;
		}
		reverseArray(arr,k,arr.length-1);
		int newPos = 0;
		int oldPos = newPos + k;
		while(newPos<k && oldPos<arr.length) {
			int temp = arr[newPos];
			arr[newPos] = arr[oldPos];
			arr[oldPos] = temp;
			newPos++;
			oldPos++;
		}
	}
	
	public void printArray(int[] array) {
		for(int x: array) {
			System.out.print(x+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] input = new int[]{1,2,3,4,5,6,7,8};
		RotateArray rotate = new RotateArray();
		rotate.printArray(input);
		rotate.rotateInPlace(input, 4);
		System.out.println("Here is rotated array:");
		rotate.printArray(input);
		
	}

}
