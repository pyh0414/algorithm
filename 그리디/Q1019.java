import java.util.*;

public class Main {

    static int[] ans = new int[10];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int end = N; // 책의 마지막 페이지
        int start = 1; // 책의 첫 페이지

        int gap = 1;

        while (true) {

            while (end % 10 != 9 && start <= end) { // end의 일의 자리가 9가 될떄까지 --
                cal(end, gap);
                end--;
            }

            if (end < start) {
                break;
            }

            while (start % 10 != 0 && start <= end) { // start의 일의 자리가 0이 될떄까지++
                cal(start, gap);
                start++;
            }

            start /= 10; // 일의 자리 빼기
            end /= 10; // 일의 자리 빼기

            for (int i = 0; i < 10; i++) {
                ans[i] += (end - start + 1) * gap;
            }

            gap *= 10;
        }

        for (int i = 0; i < 10; i++) {
            System.out.print(ans[i] + " ");
        }

    }

    static void cal(int n, int gap) { // n숫자에서 0~9숫자들이 모두 몇번 있는지 확인
        while (n > 0) {
            ans[n % 10] += gap;
            n /= 10;
        }
    }
}
