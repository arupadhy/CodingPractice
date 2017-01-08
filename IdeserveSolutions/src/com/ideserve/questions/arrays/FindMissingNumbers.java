package com.ideserve.questions.arrays;

public class FindMissingNumbers {
	
	public static int findMissingNumber(int[] input1, int[] input2) {
		if(input1 == null || input2 == null || input1.length==0 || input2.length==0) {
			throw new IllegalArgumentException();
		}
		int missing = 0;
		for(int i=0;i<input1.length;i++) {
			missing ^=input1[i];
		}
		for(int i=0;i<input2.length;i++) {
			missing ^=input2[i];
		}
		return missing;
	}
	
	public static void main(String[] args) {
		int[] input1 = new int[]{9,7,8,5,4,6,2,3,1};
		int[] input2 = new int[]{2,4,3,9,1,8,5,6};
		System.out.println(findMissingNumber(input1, input2));
	}

}
