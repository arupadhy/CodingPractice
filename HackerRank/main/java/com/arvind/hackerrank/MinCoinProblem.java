package com.arvind.hackerrank;

public class MinCoinProblem {
	
	/**
	 * Bottom up approach DP
	 * @param total
	 * @param availableCoinDenominations
	 * @return
	 */
	
	private static int findMinNumberOfCoins(int total, int[] availableCoinDenominations) {
		int[][] minCoins = new int[availableCoinDenominations.length][total+1];
		for(int i=0;i<availableCoinDenominations.length;i++) {
			for(int j=1;j<=total;j++) {
				
				if(availableCoinDenominations[i]>j) {
					minCoins[i][j] = i-1<0?0:minCoins[i-1][j];
				}else {
					int x = j/availableCoinDenominations[i];
					int remainingTotal = j%availableCoinDenominations[i];
					minCoins[i][j] = Math.min(x + minCoins[i][remainingTotal],i == 0?Integer.MAX_VALUE:minCoins[i-1][j]);
				}
			}
		}
		return minCoins[availableCoinDenominations.length-1][total];
	}
	
	public static void main(String[] args) {
		int[] availableCoins = new int[] {1,5,6,8};
		System.out.println(findMinNumberOfCoins(11, availableCoins));
	}

}
