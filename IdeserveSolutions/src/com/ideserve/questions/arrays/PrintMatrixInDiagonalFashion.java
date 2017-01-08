package com.ideserve.questions.arrays;

public class PrintMatrixInDiagonalFashion {
	
	void printMatrixDiagonally(int[][] matrix) {
		if(matrix == null || matrix.length == 0) {
			return;
		}
		int rowStart = 0;
		
		while(rowStart <=matrix.length -1) {
			
			int row = rowStart;
			int col = 0;
			while(row>=0 && col<=matrix.length) {
				System.out.print(matrix[row][col]+ " ");
				row--;
				col++;
			}
			rowStart++;
			System.out.println();
		}
		
		int colStart = 1;
		while(colStart <= matrix[0].length) {
			
			int row = matrix.length-1;
			int col = colStart;
			while(row>=0 && col<= matrix[0].length-1) {
				System.out.print(matrix[row][col] + " ");
				row--;col++;
			}
			colStart++;
			System.out.println();
		}
		
	}
	
	public static void main(String [] args) {
		int[][] matrix = {  {1,2,3,4,5},
							{6,7,8,9,10},
							{11,12,13,14,15},
							{16,17,18,19,20}
						 };
		new PrintMatrixInDiagonalFashion().printMatrixDiagonally(matrix);
	}
	

}
