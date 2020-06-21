package edu.algo.basics.sort;

public class MergeSort {

	public void sort(int arr[]) {
		if (null != arr)
			sort(arr, 0, arr.length - 1);
	}

	public void sort(int arr[], int l, int r) {
		if (l < r) {
			int mid = (l + r) / 2;
			sort(arr, l, mid);
			sort(arr, mid + 1, r);
			merge(arr, l, mid, r);
		}
	}

	public void merge(int arr[], int l, int mid, int r) {
		int i = l;
		int j = mid + 1;
		int k = 0;

		int temp[] = new int[r - l + 1];
		while (i <= mid && j <= r) {
			if (arr[i] < arr[j])
				temp[k++] = arr[i++];
			else
				temp[k++] = arr[j++];
		}
		while (i <= mid)
			temp[k++] = arr[i++];
		while (j <= r)
			temp[k++] = arr[j++];
		for (int v : temp)
			arr[l++] = v;
	}

	public static void main(String args[]) {
		int arr[] = { 23, 34, 1, 22, -9, 10, -22 };
		MergeSort ms = new MergeSort();
		ms.sort(arr);
		for (int i : arr)
			System.out.print(i + ", ");

	}

}
