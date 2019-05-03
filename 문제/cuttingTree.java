import java.util.*;

public class Main {

    static int[] arr;
    static int m;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        int start = 0; // 무조건 나무를 가져갈 수 있는 부분
        int end = max; // 무조건 나무를 가져갈 수 없는 부분

        while (start + 1 < end) {
            int mid = (start + end) / 2;

            if (check(mid)) { // mid위치에서 나무를 가져갈 수 있는지 없는지 확인, 가져갈 수 있다면 mid는 start에 없다면 end에 넣음
                start = mid;
            } else {
                end = mid;
            }
        }

        System.out.println(start);
    }

    static boolean check(int cuttingHeight) { // cuttingHeight위치에서 나무를 가져갈 수 있는지 없는지 확인

        long sum = 0;
        long result;
        long tree;

        for (int i = 0; i < arr.length; i++) {
            tree = arr[i];
            if (tree >= cuttingHeight) {
                result = tree - cuttingHeight;
                sum += result;
            }
        }
        if (sum >= m) {
            return true;
        } else {
            return false;
        }
    }
}