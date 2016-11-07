package com.arvind.hackerrank;

import java.util.HashSet;
import java.util.Set;

public class UniquePairFinder {
	
	private static class UniquePairs {
		int left;
		int right;
		
		public int getLeft() {
			return left;
		}

		public int getRight() {
			return right;
		}
		
		public UniquePairs(int l, int r) {
			this.left = l;
			this.right = r;
		}
		public int hashCode() {
			return left+right;
		}
		public boolean equals(Object obj) {
			UniquePairs p = (UniquePairs)obj;
			return (this.left == p.left && this.right == p.right);
		}
	}
	
	public static int countUniquePairs(int[]input, int sum) {
		
		Set<UniquePairs> set = new HashSet<>();
		UniquePairs p1 = new UniquePairs(10, 2);
		UniquePairs p2 = new UniquePairs(10, 2);
		set.add(p1);
		set.add(p2);
		System.out.println(set.size());
		return 0;
	}

	public static void main(String[] args) {
		
		int[] input = new int[]{1,2,4,5,6,7,8};
		System.out.println(countUniquePairs(input, 9));
	}

}
