package com.arvind.string;

import java.util.ArrayList;
import java.util.List;

public class BinarySequencesWithNoConsecutiveOnes {
	public static void main(String []args) {
		
		List<String> res = findBinarySequences(2);
		res.forEach(x -> System.out.println(x));
	}
	
	public static List<String> findBinarySequences(int n) {

		if (n<=1) {
			List<String> res = new ArrayList<>();
			res.add("0");
			res.add("1");
			return res;
		}

		List<String> res = findBinarySequences(n-1);
		List<String> newRe = new ArrayList<>();
		for(String se: res) {
			StringBuilder x = new StringBuilder(se);
			char last = se.charAt(se.length()-1);
			if(last !='1') {
				x.append("1");
			}else{
				x.append("0");
			}
			newRe.add(x.toString());
		}
		res.addAll(newRe);
		return res;
	}

}
