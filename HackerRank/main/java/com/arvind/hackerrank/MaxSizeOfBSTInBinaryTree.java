package com.arvind.hackerrank;

/**
 * 
 * @author arvind
 *
 *Find maximum size of BinarySearchTree within a large Binary Tree
 */
public class MaxSizeOfBSTInBinaryTree {
	
	
	
	public BstSize maxSizeWithinBinaryTree(BinaryTreeNode root) {
		
		if(root == null) {
			return new BstSize(true,0, Integer.MAX_VALUE, Integer.MIN_VALUE);
		}
		BstSize leftSize = maxSizeWithinBinaryTree(root.left);
		BstSize rightSize = maxSizeWithinBinaryTree(root.right);
		
		int currentData = root.data;
		boolean isBST = leftSize.isBst && rightSize.isBst && currentData>leftSize.maxSoFar && currentData < rightSize.minSoFar;
		int newMin = isBST? leftSize.minSoFar: Integer.MIN_VALUE;
		int newMax = isBST? rightSize.maxSoFar: Integer.MAX_VALUE;
		int maxSize = isBST? 1+leftSize.size+rightSize.size: Math.max(leftSize.size, rightSize.size);
		return new BstSize(isBST, maxSize, newMin, newMax);
	}
	
	
	private class BstSize {
		int size;
		int minSoFar;
		int maxSoFar;
		boolean isBst;
		
		public BstSize(boolean isBST,int size, int min, int max) {
			this.isBst = isBST;
			this.size = size;
			this.minSoFar = min;
			this.maxSoFar = max;
		}
	}

}
