package com.ideserve.questions.arrays;

public class FindSubArray {
	
	public void printSubArray(int[] input,int sum) {
		
		if(input == null || input.length == 0) {
			return;
		}
		int minLength = Integer.MAX_VALUE;
		int startIndex = 0, currentLength = 0;
		for(int start = 0;start<input.length;start++) {
			int x = sum;
			currentLength = 0;
			for(int i=start;i<input.length;i++) {
				
				x -=input[i];
				currentLength++;
				if(x == 0){
					if(currentLength < minLength) {
						minLength = currentLength;
						startIndex = start;
					}
				}
			}
		}
		
		System.out.println(String.format("Starting index is %s, Length is %s", startIndex,minLength));
		
	}
	
	public static void main(String [] args) {
		int[] input = new int[] {2,3,1,2,4,3};
		new FindSubArray().printSubArray(input, 7);
		
	}

}
