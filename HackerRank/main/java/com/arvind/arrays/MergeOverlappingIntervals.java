package com.arvind.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MergeOverlappingIntervals {
	
	public void printPairs(List<Pair> pairs) {
		pairs.forEach(x -> System.out.println(x));
	}
	
	private boolean isNumberInTheInterval(int number, int a, int b) {
		return (number>a && number<b) || (number>b && number<a);
	}
	
	public boolean isOverlapped(Pair p1, Pair p2) {
		
		if(p1 == null || p2 == null) {
			throw new IllegalArgumentException("invalid pair");
		}
		int leftLower = p1.lower;
		int leftHigher = p1.higher;
		
		int rightLower = p2.lower;
		int rightHigher = p2.higher;
		
		return isNumberInTheInterval(leftLower, rightLower, rightHigher) ||
				isNumberInTheInterval(leftHigher, rightLower, rightHigher) ||
				isNumberInTheInterval(rightLower, leftLower, leftHigher) ||
				isNumberInTheInterval(rightHigher, leftLower, leftHigher);
				
	}
	
	private static class Pair {
		int lower;
		int higher;
		public Pair(int l,int h) {
			this.lower = l;
			this.higher = h;
		}
		public String toString() {
			return "("+lower+","+higher+")";
		}
	}
	
	public List<Pair> mergeOverlappingIntervals(List<Pair> input) {
		
		List<Pair> result = new ArrayList<>();
		Iterator<Pair> itr = input.iterator();
		Pair first = itr.next();
		Pair next = null;
		
		while(itr.hasNext()) {
			 next = itr.next();
			if(isOverlapped(first, next)) {
				System.out.println(String.format("Found overlap between %s and %s", first,next));
				first = new Pair(first.lower,Math.max(next.higher, first.higher));
			}else {
				System.out.println(String.format("No overlap found...first = %s, next = %s", first,next));
				result.add(first);
				first = next;
			}
		}
		if(first!=null){
			result.add(first);
		}
		return result;
	}
	
	
	
	public static void main(String[] args) {
		Pair p1 = new Pair(1, 3);
		Pair p2 = new Pair(4, 6);
		Pair p3 = new Pair(2, 5);
		Pair p4 = new Pair(12, 17);
		Pair p5 = new Pair(5, 8);
		List<Pair> input = new ArrayList<>();
		input.add(p1);
		input.add(p2);
		input.add(p3);
		input.add(p4);
		input.add(p5);
		
		Collections.sort(input, (a1,a2)->{
			if (a1.lower == a2.lower){
				return 0;
			}else if(a1.lower < a2.lower){
				return -1;
			}else {
				return 1;
			}
			});
		new MergeOverlappingIntervals().printPairs(input);
		System.out.println("*************************************************************************");
		System.out.println("*************************************************************************");
		System.out.println("*************************************************************************");

		List<Pair> answer = new MergeOverlappingIntervals().mergeOverlappingIntervals(input);
		 new MergeOverlappingIntervals().printPairs(answer);

		
	}

}
