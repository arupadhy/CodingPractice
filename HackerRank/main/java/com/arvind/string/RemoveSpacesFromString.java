package com.arvind.string;

public class RemoveSpacesFromString {
	
	public static String removeSpaces(String input,char space) {
		
		int start = 0;
		StringBuilder result = new StringBuilder();
		char[] text = input.toCharArray();
		for(int nonSpaceCharIndex = 0;nonSpaceCharIndex<text.length;nonSpaceCharIndex++) {
			if(text[nonSpaceCharIndex] != space) {
				result.append(text[nonSpaceCharIndex]);
				start++;
			}
		}
		//anything after start isn't needed
		// java string isn't terminated by '\0'.
		return result.toString();
	}
	
	public static void main(String[] args) {
		String input = "A  rvind    u  padhy ay    x";
		System.out.println(removeSpaces(input, ' '));
	}

}
