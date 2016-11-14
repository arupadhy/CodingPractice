package com.arvind.matrix;

public class PrintMatixZicZacOrder {
	
	public static void main(String[] args) {
		int[][] matrix = new int[][]{ {1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		new PrintMatixZicZacOrder().printArrayInAlternateFashion(matrix, 4, 4);
	}
	
	public void printArrayInAlternateFashion(int[][] matrix, int row, int col) {
		
		for(int i=0; i<row;i++) {
			if(i % 2 ==0) {
				System.out.println("");
				printInLinearFashion(matrix[i], col);
			}else{
				System.out.println("");
				printInReverseOrder(matrix[i], col-1);;
			}
		}
	}
	
	private void printInLinearFashion(int[] row, int cols) {
		for(int i=0;i<cols;i++) {
			System.out.print(row[i] + " ");
		}
	}
	private void printInReverseOrder(int[]row,int colStart) {
		for(int i=colStart;i>=0;i--) {
			System.out.print(row[i]+" ");
		}
	}

}
