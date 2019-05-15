import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        long k = sc.nextLong();

        long start, end;

        start = 1; // 내가 찾고자 하는 번째 수보다 항상 작거나 같은 숫자
        end = n * n + 1; // 내가 찾고자 하는 번쨰 수보다 항상 큰 숫자

        while (start + 1 < end) {
            long mid = (start + end) / 2;
            if (check(mid, k, n)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        System.out.println(start);
    }

    static boolean check(long mid, long k, long n) {

        if (mid == 1) {
            return true;
        }

        long count = 0;
        long max;

        for (int i = 1; i <= n; i++) {

            max = i * n;

            if (i == 1) {
                if (mid > max) {
                    count = count + max;
                } else if (mid == max) {
                    count = count + max - 1;
                } else if (mid < max) {
                    count = count + mid - 1;
                }
            } else if (i > 1) {
                if (mid > max) {
                    count = count + max / i;
                } else if (mid == max) {
                    count = count + max / i - 1;
                } else if (mid < max) {
                    count = count + mid / i;
                    if (mid % i == 0) {
                        count--;
                    }
                }
            }
        }
        // i=1일때,
        // mid가 max보다 크다 : max를 더한다.
        // mid와 max가 같다 : max-1를 더한다.
        // mid가 max보다 작다 : mid-1를 더한다.

        // i > 1일때,
        // mid가 max보다 크다 : max/i를 더한다.
        // mid와 max가 같다 : max/i-1를 더한다.
        // mid가 max보다 작다 : mid/i를 더한다 만약 mid%i==0이면 하나를 빼준다

        // System.out.println(i+" "+count);
        // if(out){
        // break;
        // }
        // for(int j=1;j<=n;j++){
        // num = i*j;
        // if(num < mid){
        // count++;
        // }
        // if(count > k){
        // out=true;
        // break;
        // }
        // }

        if (count < k) {
            return true;
        }
        return false;
    }
}