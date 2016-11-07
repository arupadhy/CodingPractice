package com.arvind.hackerrank;

/**
 * 
 * Find how many BST can be crated with n diff keys
 *
 */
public class NumberOfBST {
	
	private static int numberOfBST(int keys) {
		if(keys == 0) {
			return 1;
		}
	else if(keys == 1) {
			return 1;
		}else if(keys == 2) {
			return 2;
		}
		int totalTrees = 0;
		for(int i=1;i<=keys;i++) {
			totalTrees += numberOfBST(i-1)*numberOfBST(keys-i);
		}
		return totalTrees;
	}


}
