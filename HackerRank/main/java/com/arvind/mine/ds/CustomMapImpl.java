package com.arvind.mine.ds;

public class CustomMapImpl<K,V> implements CustomMap<K, V> {
	
	private Entry<K,V>[] bucket = new Entry[10000];
	private int loadFactor;
	private static int INDEX = 1000;
	private int currentSize = 0;
	
	private static class Entry<K,V> {
		
		K key;
		public V value;
		
		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

	private int getIndex(int hash) {
		return hash % INDEX;
	}
	
	
	@Override
	public void put(K key, V value) {
		int index = getIndex(key.hashCode());
		bucket[index] = new Entry(key,value);
		currentSize++;
	}

	@Override
	public V get(K key) {
		int index = getIndex(key.hashCode());
		return bucket[index].value;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return currentSize;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return currentSize == 0;
	}

}
