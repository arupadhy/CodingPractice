package com.arvind.hackerrank;

public class LowestCommonAncestor {


	public BinaryTreeNode getLCA(BinaryTreeNode node1, BinaryTreeNode node2,BinaryTreeNode root) {
		if( node1 == null || node2 == null || root == null) {
			return null;
		}
		
		if(root.data == node1.data || root.data == node2.data) {
			return root;
		}
		BinaryTreeNode left = getLCA(node1,node2,root.left);
		BinaryTreeNode right = getLCA(node1,node2,root.right);
		if(left != null && right!=null) {
			return root;
		}else if(left == null) {
			return right;
		}
		return left;
	}

}
