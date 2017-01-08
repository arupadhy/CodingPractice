package com.arvind.string;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

public class LongestSubStringWithNoRepeationTest {
	
	
	@Test
	@Ignore
	public void checkForNoRepeatition_case1() {
		String input = "ABCDEFGHIJKL";
		assertEquals(input, LongestSubStringWithNoRepeation.longestSubString(input));
	}
	
	@Test
	public void checkForNoRepeatition_case2() {
		String input = "AAAVVVBBBCDEF";
		assertEquals("BCDEF", LongestSubStringWithNoRepeation.longestSubString(input));
	}

}
