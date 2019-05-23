import java.util.Scanner;

public class Main {

    static int[] arr;
    static int n, S;

    public static void main(String[] args) {

        // 9 14
        // 2 1 8 1 3 7 2 6 3
        // 여기서 구간의 합이 14이상인 경우의 최대길이는 ?
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        S = sc.nextInt();

        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int start = 1;
        int end = n;

        if (check(1)) {
            System.out.println(1);
            return;
        }

        if (!check(n)) {
            System.out.println(-1);
            return;
        }

        while (start + 1 < end) {
            int mid = (start + end) / 2;

            if (check(mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }

        System.out.println(end);
    }

    static boolean check(int interval) {
        // 구간의 길이가 interval만큼 정했을 때, 그 합이 S이상인 경우가 있는가 ?
        // 있으면 true, 없으면 false
        int sum = 0;
        for (int i = 0; i < interval; i++) {
            sum += arr[i];
        }
        if (sum >= S) {
            return true;
        }

        for (int i = 0; i < n - interval; i++) {
            sum = sum - arr[i] + arr[i + interval];
            if (sum >= S) {
                return true;
            }
        }
        return false;
    }
}