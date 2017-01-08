package com.arvind.string;

public class FindLongestSubstringWithNoRepeatingChars {
	
	
	public static void main(String [] args) {
//		String input = "ABCDABDEFGCABD";
		String input = "ABBCA";
		System.out.println(lengthOfLongestSubString(input));
	}
	
	public static int lengthOfLongestSubString(String input) {
		
		if(input == null || input.length() == 0) {
			return 0;
		}
		int[] lastOccurence = new int[256];
		for(int i=0;i<lastOccurence.length;i++) {
			lastOccurence[i] = -1;
		}
		int maxLength = 1;
		int currentLength = 1;
		lastOccurence[input.charAt(0)] = 0;
		int start = 0;
		for( int i=1;i<input.length();i++) {
			
			int prev = lastOccurence[input.charAt(i)];
			lastOccurence[input.charAt(i)] = i;
			if(prev == -1) {
				currentLength++;
			}else {
				if(maxLength < currentLength) {
					start = i - prev-1;
					maxLength = currentLength;
					currentLength = currentLength - prev;
				}
			}
		}
		System.out.println(input.substring(start, start+Math.max(currentLength, maxLength)));
		return Math.max(currentLength, maxLength);
	}

}
