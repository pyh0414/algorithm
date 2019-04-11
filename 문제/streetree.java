import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 입력받은 나무의 수
        int first, last; // 첫번쨰, 마지막 나무의 위치
        int GCD; // 각 나무들 간의 차이의 최대공약수
        int[] ary = new int[n]; // 나무들의 위치를 저장
        int[] gap = new int[100000]; // 나무들 간의 차이값을 저장

        for (int i = 0; i < n; i++) {
            ary[i] = sc.nextInt();

            if (i > 0) { // 2번쨰 나무부터 n - n-1, 각 나무의 간격을 구한다.
                gap[i - 1] = ary[i] - ary[i - 1];
            }
        }

        for (int j = 1; j < n; j++) { // 나무 간격의 최대 공약수를 구한다.
            gap[j] = gcd(gap[j], gap[j - 1]);
        }

        GCD = gap[n - 1];
        first = ary[0];
        last = ary[n - 1];

        System.out.println(((last - first) / GCD - n + 1));
    }

    static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        } else {
            return gcd(b, a % b);
        }
    }
}
