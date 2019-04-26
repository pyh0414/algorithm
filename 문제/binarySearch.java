import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int num;
        boolean result = false;

        for (int i = 0; i < m; i++) {
            num = sc.nextInt();

            result = binarySearch(arr, 0, arr.length - 1, num);

            if (result) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
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
}