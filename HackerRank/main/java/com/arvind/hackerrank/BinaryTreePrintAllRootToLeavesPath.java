package com.arvind.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * 
 * Different problems related to recursive Binary Tree questions
 *
 */
public class BinaryTreePrintAllRootToLeavesPath {
	
	
	
	public static NodeWithParent getParentInfo(Node a, Node root, int level) {
		
		if(root == null || a == null){
			 return null;
		}
		if(a.data == root.data) {
			return new NodeWithParent(a,level,null);
		}
		if((root.left!=null && a.data == root.left.data) || (root.right !=null && a.data == root.right.data)) {
			return new NodeWithParent(a, level+1, root);
		}
		NodeWithParent x = getParentInfo(a, root.left, level+1);
		if( x != null) {
			return x;
		}
		return getParentInfo(a,root.right,level+1);
	}
	
	
	private static class NodeWithParent {
		Node data;
		int level;
		Node parent;
		
		public NodeWithParent(Node data, int level, Node parent) {
			this.data = data;
			this.level = level;
			this.parent = parent;
		}
	}
	
	public static void printInorder(Node root) {
		if(root == null) {
			return;
		}
		printInorder(root.left);
		System.out.println(root.data);
		printInorder(root.right);
	}
	
	public static void printAllPathsFromRootToLeave(Node root,int[] data, int len) {
		
		if(root == null) {
			return;
		}
		data[len] = root.data;
		if(root.left == null && root.right == null) {
			System.out.println("Here is the path from the root.***************************************************");
			for(int i=0;i<=len;i++){
				System.out.println(data[i]);
			}
			System.out.println("****************************************************************");

		}
		len++;
		printAllPathsFromRootToLeave(root.left, data,len);
		printAllPathsFromRootToLeave(root.right, data,len);
	}
	
	public static int sumOfAllLeaves(Node root) {
		if(root == null) {
			return 0;
		}else if( root.left == null && root.right == null) {
			return root.data;
		}
		return sumOfAllLeaves(root.left) + sumOfAllLeaves(root.right);
	}
	
	public static void printNodesAtEachLevel(Node root, int level) {
		
		if(root == null) {
			return;
		}
		else {
			System.out.println("Elements At Level :" + level);
			System.out.println(root.data);
		}
		printNodesAtEachLevel(root.left, level+1);
		printNodesAtEachLevel(root.right, level+1);
	}
	
	private static class Node {
		Node left;
		Node right;
		int data;
		
		public Node(int d) {
			this.data = d;
			this.left = null;
			this.right = null;
		}
	}
	
	private static class NodeWithLevel {
		 Node node;
		 int level;
		
		public NodeWithLevel(Node node, int level) {
			this.node = node;
			this.level = level;
		}
	}
	
	private static NodeWithLevel leafNodeAtOddLevel(Node root, int level) {
		
		if(root == null) {
			 return null;
		}
		if(root.left == null && root.right == null && level%2!=0) {
			System.out.println(String.format("Found a leaf node with value = %s at level %s", root.data,level));
			return new NodeWithLevel(root, level);
		}
		NodeWithLevel leafLeftNode = leafNodeAtOddLevel(root.left, level+1);
		NodeWithLevel leafRightNode = leafNodeAtOddLevel(root.right, level+1);
		if(leafLeftNode == null) {
			return leafRightNode;
		}else if(leafRightNode == null){
			return leafLeftNode;
		}
		int leftLevel = leafLeftNode == null? Integer.MAX_VALUE:leafLeftNode.level;
		int rightLevel = leafRightNode == null? Integer.MAX_VALUE :leafRightNode.level;
		return leftLevel > rightLevel? leafLeftNode:leafRightNode;
		
		
	}
	
	private static void inorderTraversal(Node root,List<Integer>res) {
		
		if(root != null) {
		 inorderTraversal(root.left,res);
		 res.add(root.data);
		 inorderTraversal(root.right,res);
		}
	}
	
	private static void traverseInInorderFashion(Node root,List<Integer>sortedList,int index) {
		
		if(root !=null) {
			traverseInInorderFashion(root.left, sortedList, index);
			root.data = sortedList.get(index);
			index++;
			traverseInInorderFashion(root.right, sortedList, index);
		}
	}
	
	
	private static void convertBinaryTreeIntoBST(Node root) {
		
		List<Integer> inorderTraversalList = new ArrayList<>();
		inorderTraversal(root, inorderTraversalList);
		System.out.println("Inorder traversal of the input tree is: ");
		inorderTraversalList.forEach(x -> System.out.print(x + " , "));
		
		//sort the array
		Collections.sort(inorderTraversalList);
		
		traverseInInorderFashion(root, inorderTraversalList, 0);
		System.out.println("Inorder traversal of the new tree is: ");
		inorderTraversalList.forEach(x -> System.out.print(x + " , "));

	}
	private static boolean isFullBinaryTree(Node root) {
		
		if( root == null) {
			return true;
		}
		else if((root.left ==null && root.right ==null) || (root.left !=null && root.right !=null)) {
			return isFullBinaryTree(root.left) && isFullBinaryTree(root.right);
		}
		else {
			return false;
		}
		
	}
	
	private static void printVertical(Node root) {
		Map<Integer, Stack<Integer>> map = new LinkedHashMap<>();
		verticalTraversal(root, 0, map);
		List<Integer> ll = new ArrayList<>(map.keySet());
		Collections.sort(ll);
		ll.forEach(key -> System.out.println(key));
		
		System.out.println("***********************************************************************");
		System.out.println("***********************************************************************");

		ll.forEach(k -> {
			Stack<Integer> s = map.get(k);
			while(!s.isEmpty()) {
				System.out.print(s.pop());
			}
			System.out.println("");
		});
	}
	
	private static void verticalTraversal(Node root,int level,Map<Integer, Stack<Integer>> verticalOrderingMap) {
		
		if(root == null) {
			return;
		}
		verticalTraversal(root.left,level-1,verticalOrderingMap);
		Stack<Integer> l;
		if (!verticalOrderingMap.containsKey(level)){
			l = new Stack();
			l.add(root.data);
		}else{
			l = verticalOrderingMap.get(level);
			l.add(root.data);
		}
		verticalOrderingMap.put(level, l);
		verticalTraversal(root.right, level+1, verticalOrderingMap);
	}
	
	
	private static boolean isSubTree(Node root, Node sub) {
		
		if(root == null || sub == null) {
			return true;
		}
		else if( (root == null && sub !=null) || (root !=null && sub == null)) {
			return false;
		}
		System.out.println(String.format("comparing bigTree data: %s with small tree data %s", root.data,sub.data));
		if(root.data == sub.data) {
			return isSubTree(root.left,sub.left) && isSubTree(root.right,sub.right);
		}else {
			return isSubTree(root.left, sub) || isSubTree(root.right,sub);
		}
	}
	
	public static void main(String[] args) {
		//create Tree
		Node root  = new Node(1);
		
		//level 2 nodes
		Node l = new Node(2);
		Node r = new Node(3);
		r.left = new Node(4);
		
		root.left = l;
		root.right = r;
		
		//level 3
		Node ll = new Node(8);
		ll.right = new Node(9);
		
		Node rr = new Node(5);
		rr.left = new Node(6);
		rr.right = new Node(7);
		
		r.right = rr;
		l.left = ll;
		
		//print inorder to check if the tree was constructed properly
		//printInorder(root);
//		printAllPathsFromRootToLeave(root, new int[100],0);
//		System.out.println(sumOfAllLeaves(root));
//		printNodesAtEachLevel(root, 1);
//		NodeWithLevel result = leafNodeAtOddLevel(root, 1);
//		System.out.println(result);
//		System.out.println(String.format("Deepest leaf node is %s at level %s", result.node.data,result.level));
//		
//		System.out.println(isFullBinaryTree(root));
//		NodeWithParent x = getParentInfo(new Node(2), root, 1);
//		System.out.println(String.format(" node data is %s, parent is %s and level is %s", x.data.data,x.parent!=null?x.parent.data:null,x.level));
		
//		convertBinaryTreeIntoBST(root);
		
		
		//Create two trees for testing isSubtree method
		
		Node bigTree = new Node(0);
		bigTree.left = new Node(1);
		bigTree.right = new Node(2);
		
		bigTree.left.left = new Node(3);
		bigTree.left.right = new Node(40);
		
		bigTree.left.left.right = new Node(6);
		bigTree.left.left.right.right = new Node(8);
		
		bigTree.right.left = new Node(5);
		bigTree.right.left.right = new Node(7);
		
		

		//small tree
		
		Node small = new Node(1);
		small.left = new Node(3);
		small.left.right = new Node(6);
		small.left.right.right = new Node(9);
		small.right = new Node(4);
//		
//		
//		
//		System.out.println(isSubTree(bigTree, small));
		
		
		Node verticalTree = new Node(1);
		verticalTree.left = new Node(2);
		verticalTree.right = new Node(3);
		
		verticalTree.right.left = new Node(6);
		verticalTree.right.right = new Node(7);
		
		verticalTree.left.left = new Node(4);
		verticalTree.left.right = new Node(5);
		verticalTree.left.right.right = new Node(8);
		printVertical(verticalTree);
	}

}
