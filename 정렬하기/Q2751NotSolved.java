package 정렬하기;

import java.util.Arrays;
import java.util.Scanner;

public class Q2751NotSolved {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int arr[] = new int[T];

		for (int i = 0; i < T; i++) {
			arr[i] = sc.nextInt();
		}
		int left = 0, right = arr.length - 1;

		MergeSort.mergeSort(left, right, arr);
		for (int n : arr) {
			System.out.println(n);
		}
	}
}

class MergeSort {

	 

	public static void mergeSort(int left, int right, int[] arr) {

		int mid;
		int a = 0;

		if (left < right) {

			mid = (left + right) / 2;

			mergeSort(left, mid, arr);

			mergeSort(mid + 1, right, arr);

			merge(left, mid, right, arr);

		} 
	}

	public static void merge(int left, int mid, int right, int[] arr) {

		int[] sort = new int[arr.length];
		
		int l = left;
		int m = mid + 1;
		int k = left;

		while (l <= mid || m <= right) {
			if (l <= mid && m <= right) {
				if (arr[l] <= arr[m]) {
					sort[k] = arr[l++];
				} else {
					sort[k] = arr[m++];
				}
			} else if (l <= mid && m > right) {
				sort[k] = arr[l++];
			} else {
				sort[k] = arr[m++];
			}

			k++;
		}

		for (int i = left; i < right + 1; i++) {
			arr[i] = sort[i];
		}

		// System.out.print("합병정렬 = ");
		// for (int i = 0; i < arr.length; i++) {
		// System.out.print(arr[i] + " ");
		// }

	}
}
