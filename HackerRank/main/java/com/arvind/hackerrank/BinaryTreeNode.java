package com.arvind.hackerrank;

public class BinaryTreeNode {
	
	public BinaryTreeNode left;
	public BinaryTreeNode right;
	public int data;
	
	public BinaryTreeNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	

	@Override
	public String toString() {
		return "value: " + data;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + data;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BinaryTreeNode other = (BinaryTreeNode) obj;
		if (data != other.data)
			return false;
		return true;
	}

}
