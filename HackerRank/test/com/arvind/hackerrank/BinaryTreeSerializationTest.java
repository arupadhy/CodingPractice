package com.arvind.hackerrank;

import org.junit.Before;
import org.junit.Test;

public class BinaryTreeSerializationTest {
	
	private BinaryTreeNode root;
	
	@Before
	public void init() {
		root = new BinaryTreeNode(10);
		root.left = new BinaryTreeNode(20);
		root.right = new BinaryTreeNode(30);
	}
	
	@Test
	public void testSerialization() {
		int[] ans;
		int[] result = new int[3];
		ans = BinaryTreeSerialization.convertBinaryTreeToArray(root, result, 0);
		for(int i=0;i<ans.length;i++) {
			System.out.println(ans[i]);
		}
	}

}
