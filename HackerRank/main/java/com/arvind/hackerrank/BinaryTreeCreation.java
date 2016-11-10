package com.arvind.hackerrank;

/**
 * Create a binary tree of minimal height from a sorted array
 *
 */
public class BinaryTreeCreation {
	
	public BinaryTreeNode createTree(int[] data, int low, int high) {
		
		if(low >= high) {
			return null;
		}else {
		int mid = (low + high) /2;
		BinaryTreeNode node = new BinaryTreeNode(data[mid]);
		node.left = createTree(data, low, mid);
		node.right = createTree(data,mid+1,high);
		return node;
		}
	}

}
