package com.ideserve.questions.arrays;

public class StringPermutation {
	
	private static void printPermutations(String input,String perm) {
		if(input == null)
			return;
		if(input.length() ==0) {
			System.out.println(perm);
		}
		for(int i=0;i<input.length();i++) {
			char first = input.charAt(i);
			String rest = getFilteredWord(input, i);
			printPermutations(rest, perm+first);
		}
		
	}
	
	private static String getFilteredWord(String input, int removeIndex) {
		StringBuilder result = new StringBuilder();
		for(int i=0;i<input.length();i++) {
			if(removeIndex!=i) {
				result.append(input.charAt(i));
			}
		}
		return result.toString();
	}

	public static void main(String[] args) {

		String input = "abc";
		printPermutations(input, "");
		
	}

}
