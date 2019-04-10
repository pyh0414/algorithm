import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long first, last;
        long GCD;
        long[] ary = new long[n];
        long[] num = new long[1000000];

        long nn;

        for (int i = 0; i < n; i++) {
            nn = sc.nextLong();
            ary[i] = nn;

            if (i > 0) {
                num[i - 1] = ary[i] - ary[i - 1];
            }
        }

        for (int j = 1; j < n; j++) {
            num[j] = gcd(num[j], num[j - 1]);
        }

        GCD = num[n - 1];
        first = ary[0];
        last = ary[n - 1];

        System.out.println(((last - first) / GCD - n + 1));
    }

    static long gcd(long a, long b) {
        if (a % b == 0) {
            return b;
        } else {
            return gcd(b, a % b);
        }
    }
}
