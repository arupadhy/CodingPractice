package com.arvind.hackerrank;

public class BinaryTreeToDoublyLinkedList {

	public BinaryTreeNode convert(BinaryTreeNode root) {
		
		if( root == null) {
			return null;
		}
		
		BinaryTreeNode leftList = convert(root.left);
		BinaryTreeNode rightList = convert(root.right);
		
		// make root as one node in a circular list
		root.right = root;
		root.left = root;
		
		//start combining the three lists here
		BinaryTreeNode x = append(leftList,root);
		BinaryTreeNode y = append(x,rightList);
		return y;
	}
	
	private BinaryTreeNode append(BinaryTreeNode a, BinaryTreeNode b) {
		
		if(a == null) {
			return b;
		}
		else if(b == null) {
			return a;
		}
		BinaryTreeNode aFirst = a;
		BinaryTreeNode bFirst = b;
		
		BinaryTreeNode aLast = a.left; //prev
		BinaryTreeNode bLast = b.left; //left in a tree in previous in dblList
		
		aLast.right = bFirst;   //right corresponds to next in dblList
		bLast.right = aFirst;
		
		aFirst.left = bLast;
		bFirst.left = aLast;
		return a;
	}

}
