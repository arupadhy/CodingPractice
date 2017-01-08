package com.arvind.matrix;
/**
 * 
 *Matrix is sorted row wise and col wise. Check if an element exists
 * complexity:  O(numberOfRows+numberOfColumns)
 */
public class FindElementInSortedMatrix {
	
	boolean isAvailable(int[][] matrix, int totalRows,int totalCols,int no) {
		
		int rowStart = 0;
		int colStart = totalCols -1;
		while(rowStart < rowStart &&  colStart > 0) {
			if(matrix[rowStart][colStart] == no) {
				return true;
			}else if(matrix[rowStart][colStart] > no) {
				colStart--;
			}else {
				rowStart++;
			}
		}
		return false;
	}
}
