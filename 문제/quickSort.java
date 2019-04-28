import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int[] arr = { 7, 3, 5, 9, 12, 8, 4, 0, 2, 22 };

        quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = arr[start];

        int[] left = new int[100];
        int[] right = new int[100];

        int leftCount = getLeft(arr, left, start + 1, end, pivot);
        int rightCount = getRight(arr, right, start + 1, end, pivot);

        for (int i = 0; i < leftCount; i++) {
            arr[start + i] = left[i];
        }
        arr[start + leftCount] = pivot;

        for (int i = 0; i < rightCount; i++) {
            arr[start + leftCount + 1 + i] = right[i];
        }

        quickSort(arr, start, start + leftCount - 1);
        quickSort(arr, start + leftCount + 1, end);
    }

    static int getLeft(int[] arr, int[] left, int start, int end, int pivot) {
        int index = 0;
        for (int i = start; i <= end; i++) {
            if (arr[i] <= pivot) {
                left[index++] = arr[i];
            }
        }
        return index;
    }

    static int getRight(int[] arr, int[] right, int start, int end, int pivot) {
        int index = 0;
        for (int i = start; i <= end; i++) {
            if (arr[i] > pivot) {
                right[index++] = arr[i];
            }
        }
        return index;
    }
}