package com.ideserve.questions.arrays;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class LongestSubstringWithNoRepeatition {
	
	
	public static String findLongestSubString_efficient(String input) {
		
		if(input == null || input.length() <=1) {
			return input;
		}
		int[] lastIndex = new int[256];
		for(int i=0;i<256;i++) {
			lastIndex[i] = -1;
		}
		
		int maxLength = 1, currentLength = 1, start = 0;
		lastIndex[input.charAt(0)] = 0;
		
		for(int i=1;i<input.length();i++) {
			char c = input.charAt(i);
			int last = lastIndex[c];
			if(last !=-1 && last>=start) {
				if(currentLength > maxLength) {
					maxLength = currentLength;
				}
				start = last + 1;
				currentLength = i-start+1;
				
				
			}else {
				currentLength++;
			}
			lastIndex[c] = i;
		}
		if(currentLength > maxLength) {
			maxLength = currentLength;
		}
		return input.substring(start, start+maxLength);
		
	}
	


	public static void main(String[] args) {
		String input = "ABCDEFGH";
		System.out.println(findLongestSubString_efficient(input));
//		new LongestSubstringWithNoRepeatition().longestSubstringWithNoRepeatition(input);
		
		
	}

	public void longestSubstringWithNoRepeatition(String input) {

		if(input == null || input.length() == 0) {
			return;
		}
		int maxLength = 0;
		Set<Character> answer = new LinkedHashSet<>();
		for(int i=0;i<input.length();i++) {

			Set<Character> set = new LinkedHashSet<>();

			for(int j=i;j<input.length();j++) {
				if(!set.add(input.charAt(j))) {
					if(maxLength < set.size()) {
						answer = set;
						maxLength = set.size();
					}
					System.out.println(set);
					break;
				}
			}
			if(set.size() == input.length()) {
				System.out.println(set);
				break;
			}
		}

		for(Character x: answer) {
			System.out.print(x);
		}


	}

}
