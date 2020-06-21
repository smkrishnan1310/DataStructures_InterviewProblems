package edu.problems.graphsAndMatrix;

/**
 * 
 * Graph or Matrix question
 * 
 * Find number of islands or no. of components in the graph or matrix
 * 
 * Considering only up, down, left, right. Diagonal not considered.
 * 
 * Here used DFS approach. We can use BFS as well
 * 
 * From (0,0) stared DFS and counting number of DFS happened which is equal to number of islands.
 * 
 * */
public class Islands {

	private static final int R[] = { 0, 0, -1, 1 };
	private static final int C[] = { -1, 1, 0, 0 };

	private static int islands(int arr[][]) {
		int count = 0;
		boolean visi[][] = new boolean[arr.length][arr[0].length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (!visi[i][j] && arr[i][j] == 1) {
					dfs(arr, visi, i, j);
					count++;
				}
			}
		}
		return count;
	}

	private static void dfs(int arr[][], boolean visi[][], int a, int b) {
		if (isValid(arr, a, b)) {
			if (!visi[a][b] && arr[a][b] == 1) {
				visi[a][b] = true;
				
				for (int i = 0; i < 4; i++)
					dfs(arr, visi, a + R[i], b + C[i]);
			}
		}
	}

	private static boolean isValid(int arr[][], int i, int j) {
		return (i >= 0 && i < arr.length && j >= 0 && j < arr[0].length);
	}

	public static void main(String[] args) {
		int arr[][] = { 
						{ 1, 1, 1, 0, 1 }, 
						{ 0, 1, 0, 1, 1 }, 
						{ 1, 0, 1, 1, 1 }, 
					  };
		System.out.println(islands(arr));

	}

}
