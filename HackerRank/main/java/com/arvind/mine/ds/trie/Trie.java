package com.arvind.mine.ds.trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {
	
	private TrieNode root;
	
	public Trie() {
		Map<Character, TrieNode> data = new HashMap<>();
		root = new TrieNode(data, false);
	}
	
	private void insert(char x, TrieNode node,boolean isLast) {
		if(node.childrenMapping.containsKey(x)){
			insert(x,node.childrenMapping.get(x),isLast);
		}else {
			Map<Character, TrieNode> t = new HashMap<>();
			TrieNode newNode = new TrieNode(t,isLast);
			node.childrenMapping.put(x, newNode);
		}
	}
	
	public void insert(String input) {
		
		for(int i=0;i<input.length();i++) {
			char c = input.charAt(i);
			insert(c,root,i == input.length()-1);
		}
	}

}
