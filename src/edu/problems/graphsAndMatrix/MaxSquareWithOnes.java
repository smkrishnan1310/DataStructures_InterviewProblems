package edu.problems.graphsAndMatrix;

/**
 * Dynamic Programming problem
 * 
 * Find max square(n*n) filled with ones in the given matrix
 * 
 * Here we have 3*3 square in given input so output is 3
 * 
 * Time Complexity - O(n)- where n - number of elements in matrix
 * 
 * Space Complexity - O(n) - But we can do in O(1) if we are allowed to modify
 * given matrix
 * 
 */

public class MaxSquareWithOnes {

	public static int findMax(int arr[][]) {
		if (null == arr)
			return 0;
		int dp[][] = new int[arr.length][arr[0].length];
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 1) {
					int temp = 0;
					if ((i - 1) >= 0 && (j - 1) >= 0) {
						temp = Math.min(dp[i][j - 1], dp[i - 1][j]);
						temp = Math.min(temp, dp[i - 1][j - 1]);
					}
					dp[i][j] = temp + arr[i][j];
					max = Math.max(dp[i][j], max);
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int arr[][] = { { 1, 1, 1, 1, 1 }, { 1, 1, 1, 0, 0 }, { 1, 1, 1, 0, 0 }, { 1, 1, 1, 0, 0 }, { 1, 1, 1, 1, 1 } };
		System.out.println(findMax(arr));
	}

}
