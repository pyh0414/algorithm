import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] ary = s.toCharArray();
        int mid; // 문자에서 가운데 값 조사

        if (ary.length % 2 == 0) { // 글자의 긹이가 짝수인 경우
            mid = ary.length / 2 - 1;

            for (int i = 0; i <= mid; i++) { // start -> mid <-last의 모양으로 start,last의 값을 비교
                                             // 하나라도 값이 다르면 NO출력, for문에서 문제가 없으면 YES출력
                if (ary[i] != ary[ary.length - 1 - i]) {
                    System.out.println("NO");
                    return;
                }
            }
        } else { // 글자의 길이가 홀수인 경우
            mid = ary.length / 2;
            for (int i = 0; i <= mid; i++) {
                if (ary[i] != ary[ary.length - 1 - i]) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }
}