package com.arvind.mine.ds;

import static org.junit.Assert.*;

import org.junit.Test;

public class CustomMapTest {
	
	@Test
	public void testMap_case1(){
		
		CustomMap<Integer, String> indexToNameMap = new CustomMapImpl<>();
		indexToNameMap.put(1, "Arvind Upadhyay");
		assertEquals(indexToNameMap.size(), 1);
	}

}
