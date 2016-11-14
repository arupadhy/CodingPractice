package com.arvind.matrix;

public class PrintMatrixInDiagonalFashion {
	
	public static void main(String[] args) {
		int[][] data = new int[][]{ {1,5,9,13},
									{2,6,10,14},
									{3,7,11,15},
									{4,8,12,16}
								  };
//		printInDiagonalFashion(data,4,4);
		printInSpiralOrder(data, 4, 4);

	
	}
	
	/**
*   lc--------rc
	* * * * * * topRow
	* * * * * *
	* * * * * *
	* * * * * *
	* * * * * *
	* * * * * *bottomRow
	 */
	
	
	public static void printInSpiralOrder(int[][]matrix,int Rows,int Cols) {
		//set the boundary of the first layer
		int leftCol = 0, rightColumn = Cols-1, topRow = 0, bottomRow = Rows-1;
		
		while(leftCol < rightColumn && topRow < bottomRow) {
			
			int currentRow = topRow;
			while(currentRow <= bottomRow) {
				System.out.println(matrix[currentRow][leftCol]);
				currentRow++;
			}
			
			int currentCol = leftCol+1;
			while(currentCol <=rightColumn) {
				System.out.println(matrix[bottomRow][currentCol]);
				currentCol++;
			}
			
			currentRow = bottomRow -1;
			while(currentRow >=topRow) {
				System.out.println(matrix[currentRow][rightColumn]);
				currentRow--;
			}
			
			currentCol = rightColumn-1;
			while(currentCol > leftCol-1) {
				System.out.println(matrix[topRow][currentCol]);
				currentCol--;
			}
			//set the new Boundary
			leftCol++;
			topRow++;
			rightColumn--;
			bottomRow--;
			
		}
		
		
	}

	public static void printInDiagonalFashion(int[][]matrix, int Rows,int Cols) {
		
		for(int row=Rows-1,col=0;row>=0 && col<Cols;row--,col++) {
			int rowStart = 0;
			while(rowStart <= row) {
				System.out.println(matrix[rowStart][col]);
				rowStart++;
			}
			int temp = col;
			temp++;
			while(temp < Cols) {
				System.out.println(matrix[row][temp]);
				temp++;
			}
			
			
		}
		
	}
}
