import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int[] arr = { 7, 3, 5, 9, 12, 8, 4, 0, 2, 22 };

        mergeSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    static void mergeSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        } else {

            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merging(arr, start, mid, mid + 1, end);
        }
    }

    static void merging(int[] arr, int s1, int e1, int s2, int e2) {
        int p = s1;
        int q = s2;
        int[] result = new int[100];
        int index = 0;

        while (p <= e1 && q <= e2) {
            if (arr[p] > arr[q]) {
                result[index++] = arr[q];
                q++;
            } else {
                result[index++] = arr[p];
                p++;
            }
        }

        if (q > e2) {
            for (int i = p; i <= e1; i++) {
                result[index++] = arr[i];
            }
        } else if (p > e1) {
            for (int i = q; i <= e2; i++) {
                result[index++] = arr[i];
            }
        }
        for (int i = s1; i <= e2; i++) {
            arr[i] = result[i - s1];
        }
    }
}