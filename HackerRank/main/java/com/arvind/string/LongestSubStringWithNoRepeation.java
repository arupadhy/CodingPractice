package com.arvind.string;

public class LongestSubStringWithNoRepeation {
	
	public static String longestSubString(String input) {
		
		if(input == null || input.length() <=1) {
			return input;
		}
		int[] lastOccurence = new int[256];
		for(int i=0;i<lastOccurence.length;i++) {
			lastOccurence[i] = -1;
		} 
		lastOccurence[input.charAt(0)] = 0;
		
		int end=0,maxLength=1,currentLength=1;
		for(int i=1;i<input.length();i++) {
			char x = input.charAt(i);
			
			if(lastOccurence[x] == -1) {
				currentLength++;
			}else {
				if(maxLength < currentLength) {
					maxLength = currentLength;
					end = lastOccurence[x];
				}
				currentLength = i - lastOccurence[x];
				
				for(int j =0;j<=lastOccurence[x];j++) {
					lastOccurence[input.charAt(j)] = -1;
				}
			}
		}
		
		return input.substring(end-maxLength-1, end);
	}
	
	public static void main(String[] args) {
		String input = "ABAE";
		System.out.println(longestSubString(input));
	}

}
