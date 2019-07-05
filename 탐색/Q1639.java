import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        int[] arr = new int[S.length()];
        for (int i = 0; i < S.length(); i++) {
            arr[i] = Integer.parseInt(String.valueOf(S.charAt(i)));
        }

        int start, mid, end; //
        int s, e; // 탐색에 사용할 변수
        int left, right; // mid를 기준으로 왼쪽/오른쪽 값

        end = S.length() % 2 == 0 ? S.length() : S.length() - 1; // 문자열의 길이가 짝수/홀수에 따라 처리

        end += 2; // while문 처음에 바로 -2해주기 때문에 +2를 해주어야함

        while (end > 2) { // 탐색하는 크기를 정함
            start = 0;
            end -= 2;
            e = end;
            s = start;

            while (e <= S.length()) { // 탐색하는 범위를 정함

                mid = (s + e) / 2;
                left = 0;
                right = 0;
                for (int l = s; l < mid; l++) { // mid를 기준으로 왼쪽값
                    left += arr[l];
                }

                for (int r = mid; r < e; r++) { // mid를 기준으로 오른쪽 값
                    right += arr[r];
                }

                if (left == right) {
                    System.out.println(end);
                    return;
                }
                s++;
                e++;
            }
        }
        System.out.println(0);
    }
}
