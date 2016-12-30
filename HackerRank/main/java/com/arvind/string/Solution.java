package com.arvind.string;
import java.util.*;


public class Solution
{        
  // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
  // @RETURN AN EMPTY LIST IF NO ANAGRAM FOUND
	
	public static void main(String[] args) {
		List<Integer> res = getAnagramIndices("abdcghbaabcdij", "bcda");
		System.out.println(res);
	}
  public static List<Integer> getAnagramIndices(String haystack, String needle)
 {
    List<Integer> anagramIndices = new ArrayList<Integer>();
    // WRITE YOUR CODE HERE   
    if(haystack == null || needle == null || needle.length() == 0 || haystack.length() == 0) {
        return anagramIndices;
    }
    
    int length = needle.length();
    for(int i=0;i<haystack.length()-length;i++) {
        String subString = haystack.substring(i,i+length);
        if(isAnagram(subString,needle)) {
            anagramIndices.add(i);
        }

    }
    return anagramIndices;
  }
  
  private static boolean isAnagram(String input1, String input2 ) {
      
      if(input1 == null || input2 == null) {
          return false;
      }
      int[] occurences = new int[256];
      for(int i=0;i<input1.length();i++) {
          int index = input1.charAt(i);
          occurences[index]++;
      }
      for(int i=0;i<input2.length();i++) {
          int index = input2.charAt(i);
          occurences[index]--;
      }
      for(int i=0;i<occurences.length;i++){
          if(occurences[i]!=0) {
              return false;
          }
      }
      return true;
  }
}