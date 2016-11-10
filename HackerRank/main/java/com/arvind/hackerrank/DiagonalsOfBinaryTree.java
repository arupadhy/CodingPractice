package com.arvind.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 
 * Assume n lines are drawn at a slope of 135 degree that cut binary tree into n+1 groups..
 * return which node belongs to which diagonal
 *
 */
public class DiagonalsOfBinaryTree {

	public static Map<Integer,List<Integer>> diagonalNumberToElements(BinaryTreeNode root,int diagonalNumber, Map<Integer, List<Integer>> map) {
		
		if( root == null) {
			return map;
		}
		if(map.containsKey(diagonalNumber)) {
			map.get(diagonalNumber).add(root.data);
		}else{
			List<Integer> list = new ArrayList<>();
			list.add(root.data);
			map.put(diagonalNumber, list);
		}
		//every thing on the right of a node falls in the same diagonal...Draw a picture and it will makes sense
		diagonalNumberToElements(root.right, diagonalNumber, map);
		diagonalNumberToElements(root.left, diagonalNumber+1, map);
		return map;
		
	}
}
