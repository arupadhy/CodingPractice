package com.arvind.string;

/**
 * <b>IDeserve <br>
 * <a href="https://www.youtube.com/c/IDeserve">https://www.youtube.com/c/IDeserve</a>
 * Longest substring without repeating characters
 *
 * @author Saurabh
 */
public class Test {
     
    // Naive algorithm for finding the longest substring without repeating characters
    // Quadratic time complexity 
    public static String getLongestSubstringNonRepeatingCharsNaive(String str) {
        String longestSubstring = "";
        for(int i = 0; i < str.length(); i++) {
            for(int j = i; j < str.length(); j++) {
                if(hasRepeatingChars(str, i, j)) {
                    break;
                } else if(longestSubstring.length() < j-i+1){
                    longestSubstring = str.substring(i, j+1);
                }
            }
        }
        return longestSubstring;
    }
     
    private static boolean hasRepeatingChars(String str, int start, int end) {
        boolean[] isCharPresent = new boolean[256];
        for(int i = 0; i < 256; i++) {
            isCharPresent[i] = false;
        }
        for(int i = start; i <= end; i++) {
            if(isCharPresent[str.charAt(i)]) {
                return true;
            } else {
                isCharPresent[str.charAt(i)] = true;
            }
        }
        return false;
    }
     
    // Linear time algorithm for finding the longest substring without repeating characters
    public static String getLongestSubstringNonRepeatingChars(String str) {
         
    	if(str == null || str.length() <=1) {
    		return str;
    	}
    	
    	int[] last = new int[256];
    	for(int i=0;i<str.length();i++) {
    		last[str.charAt(i)] = -1;
    	}
    	
    	last[str.charAt(0)] = 0;
    	
    	int end=0,maxLength = 1,currentLength = 1;
    	for(int i=1;i<str.length();i++) {
    		char x = str.charAt(i);
    		//either x has not been seen so far or has been seen but not in the substring being considered
    		if(last[x] == -1 || i-currentLength > last[x]) {
    			currentLength++;
    		}else {
    			if(currentLength > maxLength) {
    				maxLength = currentLength;
    				end = last[x];
    			}
    			currentLength = currentLength - last[x];
    		}
    		last[x] = i;
    	}
    	if(currentLength > maxLength) {
			maxLength = currentLength;
			end = str.length()-1;
		}
    	
    	return str.substring(end-maxLength+1, end+1);
    	
    	
    	
    	
    }
 
    public static void main(String[] args) {
        String str = "ABCDABDEFGCABD";
//        String str = "ABBAC";

        /*String longestSubstring = getLongestSubstringNonRepeatingCharsNaive(str);
        System.out.println("Longest substring non repeating chars by Naive method:\t\t" + longestSubstring);*/
        String longestSubstring = getLongestSubstringNonRepeatingChars(str);
        System.out.println("Longest substring non repeating chars by linear time method:\t" + longestSubstring);
 
    }
}
