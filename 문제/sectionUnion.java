import java.util.*;

public class Main {

    static int[] s;
    static int[] e;
    static long index;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        s = new int[n];
        e = new int[n];

        int start = 0; // i번째 값보다 항상 같거나 작은 값
        int end = 0; // i번째 값보다 항상 큰 값
        int n1, max = 0;

        for (int i = 0; i < n; i++) {
            s[i] = sc.nextInt();
            n1 = sc.nextInt();
            e[i] = n1;

            if (n1 > end) {
                end = n1;
            }
        }
        end++;
        index = sc.nextLong();

        while (start + 1 < end) {
            int mid = (start + end) / 2;

            if (check(mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        System.out.println(start);

    }

    static boolean check(int n) { // n번쨰 값이 i번쨰보다의 값보다 작거나 같은지 여부
                                  // 작다는 것은 왼쪽에 있다는 것이고, start값이 됨

        long i = 0; // n바로 앞까지의 번째count
        long min = 0, max = 0;
        long count = 0;

        for (int j = 0; j < s.length; j++) {
            min = s[j];
            max = e[j];

            if (min == n) {
                i++;
                count--;
                continue;
            } else if (min > n) {
                continue;
            } else {
                if (n > max) {
                    i = i + max - min + 1;
                } else {
                    i = i + n - min + 1;
                }
                if (n > min && n <= max) {
                    count++;
                }
            }
        }

        if (i - Math.abs(count) <= index) {
            return true;
        } else {
            return false;
        }
    }
}