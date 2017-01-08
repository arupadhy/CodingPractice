package com.arvind.mine.ds;

public interface CustomMap<K,V> {
	
	void put(K key, V value);
	
	V get(K key);
	
	int size();
	
	boolean isEmpty();

}
