package com.arvind.hackerrank;

public class CreateBinaryTreeFromInorderAndPostOrderTraversal {

	private int getIndexOfElement(int[] data, int number) {
		for(int i=0;i<data.length;i++) {
			if(data[i] == number) {
				return i;
			}
		}
		return -1;
	}
	
	public BinaryTreeNode createBinaryTree(int[]postOrder,int index, int[]inorder,int low,int high) {
		
		if(index<0){
			return null;
		}
		int nodeValue = postOrder[index];
		System.out.println(String.format("Looking to create node from following value: %s", nodeValue));
		BinaryTreeNode root = new BinaryTreeNode(nodeValue);
		int indexOfNodeInInorder = getIndexOfElement(inorder, nodeValue);
		System.out.println(String.format("Found element %s in inorder array at position %s", nodeValue,indexOfNodeInInorder));
		if(indexOfNodeInInorder == -1) {
			throw new IllegalArgumentException("Bad input data");
		}
		int newIndex = index -1;
		if(getIndexOfElement(inorder, postOrder[newIndex]) > indexOfNodeInInorder) {
			root.right = createBinaryTree(postOrder, newIndex, inorder, indexOfNodeInInorder+1, high);
		}
		else {
			root.left = createBinaryTree(postOrder, newIndex, inorder, low, indexOfNodeInInorder);

		}
		return root;
		
	}
}
