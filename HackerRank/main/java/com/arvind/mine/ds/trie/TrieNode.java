package com.arvind.mine.ds.trie;

import java.util.Map;

public class TrieNode {
	
	Map<Character,TrieNode> childrenMapping;
	boolean isLast;
	
	public TrieNode(Map<Character, TrieNode>map,boolean flag) {
		this.childrenMapping = map;
		this.isLast = flag;
	}
	

}
