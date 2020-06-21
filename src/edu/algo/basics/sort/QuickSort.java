package edu.algo.basics.sort;

public class QuickSort {

	public void sort(int arr[]) {
		if (null != arr && arr.length > 1)
			sort(arr, 0, arr.length - 1);
	}

	private void sort(int arr[], int l, int r) {
		if (l < r) {
			int p = partition(arr, l, r);
			sort(arr, l, p - 1);
			sort(arr, p + 1, r);
		}
	}

	private void swap(int arr[], int a, int b) {
		int t = arr[a];
		arr[a]=arr[b];
		arr[b]=t;
	}

	private int partition(int arr[], int l, int r) {
		int p = r;
		int i = l;
		int j = l;
		for (; i < r; i++) {
			if (arr[p] > arr[i]) {
				swap(arr, j, i);
				j++;
			}
		}
		swap(arr, j, p);
		return j;
	}

	public static void main(String args[]) {
		int arr[] = {1, 4, 0, 2};
		QuickSort qs = new QuickSort();
		qs.sort(arr);
		for(int i:arr) {
			System.out.print(i+", ");
		}
	}
}
