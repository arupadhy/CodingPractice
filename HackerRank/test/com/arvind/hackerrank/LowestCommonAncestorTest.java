package com.arvind.hackerrank;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LowestCommonAncestorTest {
	
	private BinaryTreeNode bTree;
	
	@Before
	public void initTree() {
		bTree = new BinaryTreeNode(1);
		bTree.left = new BinaryTreeNode(3);
		bTree.right = new BinaryTreeNode(4);
		
		bTree.left.left = new BinaryTreeNode(5);
		bTree.left.right = new BinaryTreeNode(15);
		bTree.left.left.left = new BinaryTreeNode(6);
		bTree.left.left.right = new BinaryTreeNode(60);
		bTree.left.left.left.right = new BinaryTreeNode(70);
	}
	
	@Test
	public void testCommonAncestor_case1() {
		LowestCommonAncestor ancestor = new LowestCommonAncestor();
		assertEquals(ancestor.getLCA(null, null,bTree), null);
	}
	
	@Test
	public void testCommonAncestor_case2() {
		LowestCommonAncestor ancestor = new LowestCommonAncestor();
		assertEquals(ancestor.getLCA(new BinaryTreeNode(1), new BinaryTreeNode(3),bTree), new BinaryTreeNode(1));
	}
	
	@Test
	public void testCommonAncestor_case3() {
		LowestCommonAncestor ancestor = new LowestCommonAncestor();
		assertEquals(ancestor.getLCA(new BinaryTreeNode(1), null,bTree), null);
	}
	
	@Test
	public void testCommonAncestor_case4() {
		LowestCommonAncestor ancestor = new LowestCommonAncestor();
		assertEquals(ancestor.getLCA(new BinaryTreeNode(3), new BinaryTreeNode(4),bTree), new BinaryTreeNode(1));
	}
	
	@Test
	public void testCommonAncestor_case5() {
		LowestCommonAncestor ancestor = new LowestCommonAncestor();
		assertEquals(ancestor.getLCA(new BinaryTreeNode(4), new BinaryTreeNode(70),bTree), new BinaryTreeNode(1));
	}

}
