import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int m = sc.nextInt();

        int result = binarySearch(arr, 0, n - 1, m);

        if (result == -1) {
            System.out.println("못찾았습니다");
        } else {
            System.out.println(result + "번째 위치에 있습니다");
        }
    }

    static int binarySearch(int[] arr, int start, int end, int value) {
        if (start > end) {
            return -1;
        } else if (start == end) {
            if (arr[start] == value) {
                return start;
            } else {
                return -1;
            }
        } else {
            int mid = (start + end) / 2;
            if (arr[mid] == value) {
                return mid;
            } else if (arr[mid] > value) {
                return binarySearch(arr, start, mid - 1, value);
            } else {
                return binarySearch(arr, mid + 1, end, value);
            }
        }
    }
}