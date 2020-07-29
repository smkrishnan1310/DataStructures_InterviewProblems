package edu.problems.others.dp;
/**
 * Egg dropping problem - Dynamic programming 
 * 
 * Below is Basic for of solution using DP.
 * 
 * Time complexity = O(n ^2 * e)
 * space complexity = O(e*n)
 * n- no. of floors
 * e- no. of eggs
 * 
 * */
public class EggDroppingDP {

	public static int findMinMoves(int floors, int eggs) {
		// Base case 1
		if (eggs == 1)
			return floors;
		// Base case 2
		if (floors <= 1)
			return 1;

		floors++;
		eggs++;

		int dp[][] = new int[floors][eggs];

		// Base case 1 : For one egg we can do max one move. So, no. of moves=no. of
		// floors
		for (int i = 0; i < floors; i++) {
			dp[i][1] = i;
		}

		// Base case 2 : For one floor we need max only one move despite of no.. of eggs
		for (int i = 0; i < eggs; i++) {
			dp[1][i] = 1;
		}

		/**
		 * If we are in Xth floor and if we drop then, We have two case 1. It will break
		 * else 2. It will not break.
		 * 
		 * case 1: If egg broken, correct floor should be at between 0th and X-1 th floor
		 * case 2: If Not broken, correct floor should be at between X+1 th and N th floor
		 * 
		 * Max of which we need to find so recurrence is
		 * 
		 * max( dp[n-x][e], dp[x-1][e-1]) +1 
		 * 
		 * we need to check and find minimum for each upto current floor X
		 * 
		 * so, it will be 1->X min{ max( dp[n-x][e], dp[x-1][e-1]) +1  }
		 * 
		 * n- no. of floors, e- no. of eggs, X - current floor
		 * 
		 */

		for (int i = 2; i < floors; i++) {
			for (int j = 2; j < eggs; j++) {
				int temp = Integer.MAX_VALUE;
				for (int x = 1; x < i; x++) { // For every floor from 1->i find Minimum X - current floor
					int eggBroken = dp[x - 1][j - 1];
					int noBroke = dp[i - x][j];
					int max = 1 + Math.max(noBroke, eggBroken);
					temp = Math.min(temp, max);
				}
				dp[i][j] = temp;
			}
		}

		return dp[floors - 1][eggs - 1];
	}

	public static void main(String[] args) {
		int floors = 20;
		int eggs = 3;
		System.out.println(findMinMoves(floors, eggs));
	}

}