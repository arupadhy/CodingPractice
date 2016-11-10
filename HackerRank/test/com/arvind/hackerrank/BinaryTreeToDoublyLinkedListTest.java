package com.arvind.hackerrank;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class BinaryTreeToDoublyLinkedListTest {
	
	private BinaryTreeNode root;
	
	@Before
	public void init() {
		root = new BinaryTreeNode(10);
		root.left = new BinaryTreeNode(8);
		root.right = new BinaryTreeNode(15);
		
		root.left.left = new BinaryTreeNode(2);
		root.left.right = new BinaryTreeNode(9);
		
		
		root.right.left = new BinaryTreeNode(12);
		root.right.right = new BinaryTreeNode(16);
	}
	
	@Test
	public void testConvertTreeToList() {
		BinaryTreeToDoublyLinkedList conversion = new BinaryTreeToDoublyLinkedList();
		System.out.println("BEfore converting tree to list...here is the inorder traversal of the tree");
		List<Integer> ans = new BinaryTreeHelper().inorderTraversal(root, new ArrayList<Integer>());
		ans.forEach(x -> System.out.print(x + "  "));
		BinaryTreeNode dblList = conversion.convert(root);
		System.out.println("Convertion of tree to list is complete now.************************************* Here is the traversal of the linkedlist");
		BinaryTreeNode current = dblList;
		BinaryTreeNode head = dblList;
		boolean start = true;
		while(current!=head || start) {
			System.out.println(current.data);
			start = false;
			current = current.right;
		}
		
		
		
	}

}
