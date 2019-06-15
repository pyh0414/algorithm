import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        int leftCount;

        for (int val = 0; val < n; val++) {
            leftCount = sc.nextInt();

            for (int i = 0; i < n; i++) {
                if (leftCount == 0 && arr[i] == 0) {
                    arr[i] = val + 1;
                    break;
                } else if (arr[i] == 0) {
                    leftCount--;
                }
            }
        }

        for (int f : arr) {
            System.out.print(f + " ");
        }
    }
}