package com.arvind.hackerrank;

public class BinaryTreeSerialization {
	
	public static int[] convertBinaryTreeToArray(BinaryTreeNode root,int[]result, int index) {
		if(root == null) {
			return result;
		}
		result[index] = root.data;
		convertBinaryTreeToArray(root.left, result, 2*index+1);
		convertBinaryTreeToArray(root.right, result, 2*index+2);
		return result;
	}

}
