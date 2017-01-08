package com.arvind.hackerrank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class DiagonalsOfBinaryTreeTest {
	
	private BinaryTreeNode root;
	
	
	@Before
	public void init() {
		root = new BinaryTreeNode(0);
		root.right = new BinaryTreeNode(2);
		root.right.right = new BinaryTreeNode(3);
		root.right.right = new BinaryTreeNode(6);
		
		root.right.left = new BinaryTreeNode(3);
		root.left = new BinaryTreeNode(1);
		root.left.right = new BinaryTreeNode(5);
		
		root.left.right.left = new BinaryTreeNode(7);
		root.left.left = new BinaryTreeNode(4);
		
	}
	
	@Test
	public void diagonalSumBinaryTreeTest() {
		Map<Integer, List<Integer>> map = new HashMap<>();
		Map<Integer, List<Integer>>  res = DiagonalsOfBinaryTree.diagonalNumberToElements(root, 1, map);
		res.keySet().forEach(x -> {
			System.out.println("");
			System.out.println("**************DIAGONAL "+x+"  *********************************");
			res.get(x).forEach( data -> System.out.print(data));
		});
	}

}
