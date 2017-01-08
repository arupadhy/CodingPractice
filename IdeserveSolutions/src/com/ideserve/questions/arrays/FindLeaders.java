package com.ideserve.questions.arrays;

public class FindLeaders {
	
	void printLeaders(int [] input) {
		
		if (input == null || input.length==0) {
			return;
		}
		int index = input.length-2;
		int leaderSoFar = input[input.length-1];
		System.out.println(leaderSoFar);
		while(index>=0) {
			if(input[index]>leaderSoFar) {
				leaderSoFar = input[index];
				System.out.println(leaderSoFar);
			}
			index--;
		}
	}
	
	public static void main(String [] args) {
		int[] input = new int[] {98,23,54,12,20,7,27};
		new FindLeaders().printLeaders(input);
	}

}
