package com.arvind.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MultiTree {
	
	public static void main(String[] args) {
		MultiTree tree = new MultiTree();
		tree.root = new Node("10");
		
		Node child1_10 = new Node("20");
		Node child2_10 = new Node("21");
		Node child3_10 = new Node("22");
		Node child4_10 = new Node("23");
		List<Node> children_10 = new ArrayList<>();
		children_10.add(child1_10);
		children_10.add(child2_10);
		children_10.add(child3_10);
		children_10.add(child4_10);
		tree.root.children  = children_10;
		
		List<Node> children_20 = new ArrayList<>();
		Node child1_20 = new Node("20-1");
		Node child2_20 = new Node("20-2");
		Node child3_20 = new Node("20-3");
		children_20.add(child1_20);
		children_20.add(child2_20);
		children_20.add(child3_20);
		child1_10.children = children_20;
		
		List<Node> children_21 = new ArrayList<>();
		Node child1_21 = new Node("21-1");
		Node child2_21 = new Node("21-2");
		Node child3_21 = new Node("21-3");
		children_21.add(child1_21);
		children_21.add(child2_21);
		children_21.add(child3_21);
		child2_10.children = children_21;
		
		List<Node> children_22 = new ArrayList<>();
		Node child1_22 = new Node("22-1");
		Node child2_22 = new Node("22-2");
		Node child3_22 = new Node("22-3");
		children_22.add(child1_22);
		children_22.add(child2_22);
		children_22.add(child3_22);
		child3_10.children = children_22;
		
		List<Node> children_23 = new ArrayList<>();
		Node child1_23 = new Node("23-1");
		Node child2_23 = new Node("23-2");
		Node child3_23 = new Node("23-3");
		children_23.add(child1_23);
		children_23.add(child2_23);
		children_23.add(child3_23);
		child4_10.children = children_23;
	}
	
	Node root;
	
	public void printTree() {
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		
		
	}
	
	private static class Node {
		List<Node> children;
		String data;
		public Node(String data) {
			this.data = data;
			this.children = null;
		}
	}
	

}
