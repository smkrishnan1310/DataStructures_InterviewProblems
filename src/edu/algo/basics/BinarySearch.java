package edu.algo.basics;

public class BinarySearch {

	public int searchRecursively(int arr[], int val) {
		if (null == arr)
			return -1;
		return searchRecursively(arr, 0, arr.length - 1, val);
	}

	private int searchRecursively(int arr[], int st, int en, int val) {
		if (st > en)
			return -1;
		int mid = (st + en) / 2;
		if (arr[mid] == val)
			return mid;
		if (arr[mid] > val)
			return searchRecursively(arr, st, mid - 1, val);
		return searchRecursively(arr, mid + 1, en, val);
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6 };
		BinarySearch bs = new BinarySearch();
		System.out.println(":::" + bs.searchRecursively(arr, 4));

	}

}
