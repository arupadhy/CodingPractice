package com.arvind.hackerrank;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class BinaryTreeCreationTest {
	
	@Test
	public void testBinaryTreeFromArray() {
		
		int[] data = new int[] {1,2,3,4,5,6,7,8,9,10};
		BinaryTreeCreation binaryTreeCreation = new BinaryTreeCreation();
		BinaryTreeNode root = binaryTreeCreation.createTree(data, 0, data.length-1);
		//print inorder traversal now
		List<Integer> list = new ArrayList<>();
		new BinaryTreeHelper().inorderTraversal(root, list);
		list.forEach(x -> System.out.println(x));
	}

}
