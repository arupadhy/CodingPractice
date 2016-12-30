package com.arvind.recursion;

public class PrintValidParenthesis {
	
	
	/**()
	 * (()) ()()
	 * ((())) ()()() (())() ()(())
	 */
	public static void main(String [] args) {
		printParenthesis(3,3,"");
	}
	

	
	public static void printParenthesis(int leftRemaining,int rightRemaining,String str) {
		
		if(leftRemaining == 0 && rightRemaining == 0) {
			System.out.println(str);
		}
		if(leftRemaining >0) {
			printParenthesis(leftRemaining - 1, rightRemaining, str + "(");
		}
		if(rightRemaining >0 && rightRemaining>leftRemaining) {
			printParenthesis(leftRemaining, rightRemaining-1, str + ")");
		}
	}
}
