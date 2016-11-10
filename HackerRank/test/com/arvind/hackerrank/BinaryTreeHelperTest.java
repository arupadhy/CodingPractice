package com.arvind.hackerrank;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class BinaryTreeHelperTest {
	private BinaryTreeNode root;
	
	@Before
	public void initTree() {
//		root  = new BinaryTreeNode(10);
//		root.left = new BinaryTreeNode(15);//
//		root.left.left = new BinaryTreeNode(4);
//		root.left.right = new BinaryTreeNode(7);
//		
//		root.right = new BinaryTreeNode(5);//
//		root.right.left = new BinaryTreeNode(14);
//		root.right.right = new BinaryTreeNode(17);
		
		root  = new BinaryTreeNode(10);
		root.left = new BinaryTreeNode(2);//
		
		root.right = new BinaryTreeNode(3);//
		
		
	}
	
	@Test
	@Ignore
	public void inorderWithPrevTrack() {
		new BinaryTreeHelper().inorderTravesalWithPrevTrack(root);
	}
	@Test
	public void inorderWithPrevTrack1() {
		new BinaryTreeHelper().inorderTravesalWithPrev(root,null);
	}
	
	

	@Test
	@Ignore
	public void testInorderTraversal() {
		List<Integer> inorder = new BinaryTreeHelper().inorderTraversal(root, new ArrayList<>());
		inorder.forEach(x -> System.out.println(x));
		
		System.out.println("lets fix the tree now..**********************************************");
		new BinaryTreeHelper().reCreateTree(root, null, null, null);
		
		List<Integer> newInorder = new BinaryTreeHelper().inorderTraversal(root, new ArrayList<>());
		newInorder.forEach( x -> System.out.println(x));
	}

}
