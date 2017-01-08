package com.arvind.hackerrank;

import java.util.List;

public class BinaryTreeHelper {
	
	
	private BinaryTreeNode prevNode;
	/**
	 * get inorder traversal of a binary tree returned as list
	 */
	
	public List<Integer> inorderTraversal(BinaryTreeNode root,List<Integer> list) {
		
		if(root == null) {
			return list;
		}
		inorderTraversal(root.left, list);
		list.add(root.data);
		inorderTraversal(root.right, list);
		return list;
	}
	
	
	public void inorderTravesalWithPrevTrack(BinaryTreeNode current) {
		
		if(current == null) {
			return;
		}
		inorderTravesalWithPrevTrack(current.left);
		System.out.println(String.format("node: %s, prev: %s", current.data, prevNode));
		prevNode = current;
		inorderTravesalWithPrevTrack(current.right);
	}
	
	
public void inorderTravesalWithPrev(BinaryTreeNode current,BinaryTreeNode prev) {
		
		if(current == null) {
			return;
		}
		System.out.println(String.format("Arguments received are node: %s, prev: %s", current, prev));
		inorderTravesalWithPrev(current.left,prev);
		System.out.println(String.format("node: %s, prev: %s", current.data, prev));
		prev = new BinaryTreeNode(current.data);
		System.out.println("have set the prev to " + prev);
		inorderTravesalWithPrev(current.right,prev);
	}
	
	public void reCreateTree(BinaryTreeNode current,BinaryTreeNode previous,BinaryTreeNode first, BinaryTreeNode second) {
		
		if(current == null) {
//			if(first !=null && second != null) {
//				System.out.println("Swap the nodes now");
//				BinaryTreeNode temp = first;
//				first = second;
//				second = temp;
//			}
			return;
		}
//		else if(previous !=null && current.data < previous.data) {
//			System.out.println("Trying to populate first and second");
//			
//			if(first == null ) {
//				first = previous;
//			}else {
//				second = current;
//			}
//		}
		reCreateTree(current.left, previous, first, second);
		System.out.println(String.format("CurrentNode: %s, PreviousNode: %s",current,previous));
		previous = current;
		reCreateTree(current.right,previous,first,second);
		
	}

}
