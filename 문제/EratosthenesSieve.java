import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        boolean[] arr = new boolean[101];

        for (int i = 2; i <= Math.sqrt(100); i++) {
            for (int j = i + i; j <= 100; j += i) {
                arr[j] = true; // true인 부분은 소수가 아닌 부분
            }
        }

        if (arr[n] == false) {
            System.out.println(n + "은 소수입니다.");
        } else {
            System.out.println(n + "은 소수가 아닙니다");
        }

    }
}