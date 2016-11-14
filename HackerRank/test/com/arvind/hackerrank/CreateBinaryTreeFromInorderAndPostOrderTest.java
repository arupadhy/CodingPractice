package com.arvind.hackerrank;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CreateBinaryTreeFromInorderAndPostOrderTest {

	@Test
	public void testBinaryTreeCreation() {
//		int[] inOrder = new int[]{ 4, 2, 5, 1, 6, 3, 7 };
//		int[] pos­tOrder = new int[]{ 4, 5, 2, 6, 7, 3, 1 };
		
		int[] inOrder = new int[] {1,3,2};
		int[] pos­tOrder = new int[] {1,2,3};
		BinaryTreeNode root = new CreateBinaryTreeFromInorderAndPostOrderTraversal().
				createBinaryTree(pos­tOrder, 6, inOrder, 0, inOrder.length-1);
		
		List<Integer> list = new BinaryTreeHelper().inorderTraversal(root, new ArrayList<>());
		list.forEach(x -> System.out.println(x));
	}
}
