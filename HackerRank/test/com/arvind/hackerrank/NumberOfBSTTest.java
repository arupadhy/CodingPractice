package com.arvind.hackerrank;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NumberOfBSTTest {
	
	private NumberOfBST numberOfBst;
	
	@Before
	public void construct() {
		numberOfBst = new NumberOfBST();
	}
	
	@Test
	public void testNumberOfTrees() {
		assertEquals(1, numberOfBst.numberOfBST(1));
		assertEquals(2, numberOfBst.numberOfBST(2));
		assertEquals(5, numberOfBst.numberOfBST(3));
		assertEquals(14, numberOfBst.numberOfBST(4));
	}

}
