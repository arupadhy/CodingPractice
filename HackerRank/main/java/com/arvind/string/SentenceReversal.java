package com.arvind.string;

public class SentenceReversal {
	
	public static String reverseSentence(String input) {
		StringBuilder result = new StringBuilder();
		if(input == null || input.length() <=1) {
			return input;
		}
		int endIndex = input.length();
		int startIndex = input.length()-1;
		
		while(startIndex > 0) {
			if(input.charAt(startIndex) == ' ') {
				System.out.println(String.format("Found space...reversed word is %s", input.substring(startIndex, endIndex)));
				result.append(input.substring(startIndex, endIndex));
				endIndex = startIndex;
			}
			startIndex--;
		}
		return result.toString();
	}
	
	public static void main(String[] args) {
		String input = "My Name is Arvind Upadhyay";
		System.out.println(reverseSentence(input));
	}

}
