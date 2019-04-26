import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }

        quickSort(arr1, 0, arr1.length - 1); // 먼저 arr1을 정렬
        // Arrays.sort(arr1);

        int num;
        boolean result;
        for (int j = 0; j < arr2.length; j++) {
            num = arr2[j];

            result = binarySearch(arr1, 0, arr1.length - 1, num); // arr1배열에서 num값이 있는지 없는지 검사

            if (result) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }

    static boolean binarySearch(int[] arr, int start, int end, int num) {
        if (start > end) {
            return false;
        } else if (start == end) {
            if (arr[start] == num) {
                return true;
            } else {
                return false;
            }
        }

        int mid = (start + end) / 2;
        if (arr[mid] == num) {
            return true;
        }

        if (arr[mid] > num) {
            return binarySearch(arr, start, mid - 1, num);
        } else {
            return binarySearch(arr, mid + 1, end, num);
        }
    }

    static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        } else {
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