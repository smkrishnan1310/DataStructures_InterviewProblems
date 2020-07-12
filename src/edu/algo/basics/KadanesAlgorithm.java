package edu.algo.basics;

/** Kadane's Algorithm (sliding window technique) to find max sub-array sum */
public class KadanesAlgorithm {

	public static void maxSubArraySum(int arr[]) {
		int max = Integer.MIN_VALUE;
		int st = 0;
		int end = 0;
		if (null != arr) {
			int tempMax = 0;
			int t = 0;
			for (int i = 0; i < arr.length; i++) {
				tempMax += arr[i];
				if (tempMax < arr[i]) {
					tempMax = arr[i];
					t = i;
				}
				if (max < tempMax) {
					max = tempMax;
					st = t;
					end = i;
				}
			}
		}
		System.out.println("MaxSum= " + max + " : start= " + st + " : end = " + end);
	}

	public static void main(String[] args) {
		int arr[] = { 12, 7, -22, 9, 8, -2, -4, 6, 3 };
		maxSubArraySum(arr);
	}

}
