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

        GCD = gap[n - 1]; // for문을 돌면 gap배열의 제일 오른쪽에 최대공약수가 있음
        first = ary[0];
        last = ary[n - 1];

        System.out.println(((last - first) / GCD - n + 1));

        // last-first/GCD+1의 값은나무간의 간격이 GCD일떄의 세울 수있는 나무의 개수. 예를 들어 기존에 세워져 있던 나무의 개수n은
        // 4(2,6,8,14)일때 last-first = 12
        // 12/2+1 = 7개. 총 2,4,6,8,10,12,14위치에 나무를 세울 수 있다. 여기서 추가적으로 심어야 할 나무는 7-n이 된다.

    }

    static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        } else {
            return gcd(b, a % b);
        }
    }
}
